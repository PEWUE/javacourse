import generator.HoldingGenerator;
import model.*;
import model.Currency;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exercises {

    private static final List<Holding> holdings = new HoldingGenerator().generate();

    public static void main(String[] args) {
        System.out.println("getHoldingsWhereAreCompanies \n" + getHoldingsWhereAreCompanies() + "\n");
        System.out.println("getHoldingNames \n" + getHoldingNames() + "\n");
        System.out.println("getHoldingNamesAsString \n" + getHoldingNamesAsString() + "\n");
        System.out.println("getCompaniesAmount \n" + getCompaniesAmount() + "\n");
        System.out.println("getAllUserAmount \n" + getAllUserAmount() + "\n");
        System.out.println("getAllCompaniesNamesAsLinkedList \n" + getAllCompaniesNamesAsLinkedList() + "\n");
        Predicate<User> userAgePredicate = user -> user.getAge() >= 20;
        System.out.println("getUsersForPredicate(userAgePredicate) -  user is at least 20 years old \n" + getUsersForPredicate(userAgePredicate) + "\n");
        Predicate<User> userPermitPredicate = user -> user.hasPermit(Permit.LOAN);
        System.out.println("getUsersForPredicate(userPermitPredicate) - user has Permit.LOAN \n" + getUsersForPredicate(userPermitPredicate) + "\n");
        Consumer<Company> printCompanyName = company -> System.out.println(company.getName());
        System.out.println("executeForEachCompany(printCompanyName) - print company name");
        executeForEachCompany(printCompanyName);
        System.out.println("\nexecuteForEachCompany(printGenderStatisticsForCompany) - print gender statistics for each company");
        Consumer<Company> printGenderStatisticsForCompany = company -> {
            long manCount = getUserStream()
                    .map(User::getSex)
                    .filter(sex -> sex.equals(Sex.MAN))
                    .count();
            long womanCount = getUserStream()
                    .map(User::getSex)
                    .filter(sex -> sex.equals(Sex.WOMAN))
                    .count();
            System.out.println("Liczba mężczyzn pracujących w " + company.getName() + ": " + manCount);
            System.out.println("Liczba kobiet pracujących w " + company.getName() + ": " + womanCount + "\n");
        };
        executeForEachCompany(printGenderStatisticsForCompany);
        if (getRichestWoman().isPresent()) {
            System.out.println("getRichestWoman() \n" + getRichestWoman().get() + "\n");
        }
        System.out.println("getFirstNCompany(2) \n" + getFirstNCompany(2) + "\n");
        System.out.println("getFirstNCompany(5) \n" + getFirstNCompany(5) + "\n");
        System.out.println("getUserPerCompany() " + getUserPerCompany() + "\n");
        try {
            System.out.println(getUser(userPermitPredicate));
//            System.out.println(getUser(user -> user.getAge() > 100));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Napisz metodę, która zwróci liczbę holdingów, w których jest przynajmniej jedna firma.
     */
    public static long getHoldingsWhereAreCompanies() {
        return holdings.stream()
                .filter(Holding::hasAnyCompany)
                .count();
    }

    /**
     * Napisz metodę, która zwróci nazwy wszystkich holdingów pisane z wielkiej litery w formie listy.
     */
    public static List<String> getHoldingNames() {
        return holdings.stream()
                .map(Holding::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Zwraca nazwy wszystkich holdingów sklejone w jeden string i posortowane.
     * String ma postać: (Coca-Cola, Nestle, Pepsico)
     */
    public static String getHoldingNamesAsString() {
        return holdings.stream()
                .sorted(Comparator.comparing(Holding::getName))
                .map(Holding::getName)
                .collect(Collectors.joining(", ", "(", ")"));
    }

    /**
     * Zwraca liczbę firm we wszystkich holdingach.
     */
    public static long getCompaniesAmount() {
        return holdings.stream()
                .mapToLong(Holding::getCompanyCount)
                .sum();
    }

    /**
     * Zwraca liczbę wszystkich pracowników we wszystkich firmach.
     */
    public static long getAllUserAmount() {
        return getCompanyStream()
                .mapToLong(Company::getEmployeeCount)
                .sum();
    }

    /**
     * Zwraca listę wszystkich firm jako listę, której implementacja to LinkedList. Obiektów nie przepisujemy
     * po zakończeniu działania strumienia.
     */
    public static LinkedList<String> getAllCompaniesNamesAsLinkedList() {
        return getCompanyStream()
                .map(Company::getName)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Zwraca imiona użytkowników w formie zbioru, którzy spełniają podany warunek.
     */
    public static Set<String> getUsersForPredicate(final Predicate<User> userPredicate) {
        return getUserStream()
                .filter(userPredicate)
                .map(User::getFirstName)
                .collect(Collectors.toSet());
    }

    /**
     * Dla każdej firmy uruchamia przekazaną metodę.
     */
    public static void executeForEachCompany(Consumer<Company> consumer) {
        getCompanyStream().forEach(consumer);
    }

    /**
     * Wyszukuje najbogatsza kobietę i zwraca ją. Metoda musi uzwględniać to że rachunki są w różnych walutach.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/55052733/9360524
    public static Optional<User> getRichestWoman() {
        return getUserStream()
                .filter(user -> user.getSex() == Sex.WOMAN)
                .max(Comparator.comparing(Exercises::getUserAmountInPLN));
    }

    private static BigDecimal getUserAmountInPLN(final User user) {
        return user.getAccounts()
                .stream()
                .map(Exercises::getAccountAmountInPLN)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Przelicza kwotę na rachunku na złotówki za pomocą kursu określonego w enum Currency.
     */
    public static BigDecimal getAccountAmountInPLN(Account account) {
        return account
                .getAmount()
                .multiply(BigDecimal.valueOf(account.getCurrency().getRate()))
                .setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Zwraca nazwy pierwszych N firm. Kolejność nie ma znaczenia.
     */
    private static Set<String> getFirstNCompany(final int n) {
        return getCompanyStream()
                .map(Company::getName)
                .limit(n)
                .collect(Collectors.toSet());
    }

    /**
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników.
     */
    public static Map<String, List<User>> getUserPerCompany() {
        return getCompanyStream()
                .collect(Collectors.toMap(Company::getName, Company::getUsers));
    }

    /**
     * Zwraca pierwszego z brzegu użytkownika dla podanego warunku. W przypadku kiedy nie znajdzie użytkownika, wyrzuca
     * wyjątek IllegalArgumentException.
     */
    public static User getUser(final Predicate<User> predicate) {
        return getUserStream()
                .filter(predicate)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono usera o danych wytycznych"));
    }

    /**
     * Zwraca mapę rachunków, gdzie kluczem jest numer rachunku, a wartością ten rachunek.
     */
    public static Map<String, Account> createAccountsMap() {
        return null;
    }

    /**
     * Zwraca listę wszystkich imion w postaci Stringa, gdzie imiona oddzielone są spacją i nie zawierają powtórzeń.
     */
    public static String getUserNames() {
        return null;
    }

    /**
     * Metoda wypisuje na ekranie wszystkich użytkowników (imię, nazwisko) posortowanych od z do a.
     * Zosia Psikuta, Zenon Kucowski, Zenek Jawowy ... Alfred Pasibrzuch, Adam Wojcik
     */
    public static void showAllUser() {
    }

    /**
     * Zwraca zbiór walut w jakich są rachunki.
     */
    public static Set<Currency> getCurenciesSet() {
        return null;
    }

    /**
     * Zwraca strumień wszystkich firm.
     */
    private static Stream<Company> getCompanyStream() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream());
    }

    /**
     * Tworzy strumień użytkowników.
     */
    private static Stream<User> getUserStream() {
        return getCompanyStream()
                .flatMap(company -> company.getUsers().stream());
    }

    /**
     * Tworzy strumień rachunków.
     */
    private static Stream<Account> getAccoutStream() {
        return getUserStream()
                .flatMap(user -> user.getAccounts().stream());
    }

}
