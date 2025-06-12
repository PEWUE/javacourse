import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Anna", "Nowak");
        Person p2 = new Person("Jan", "Kowalski");
        Person p3 = new Person("Ewa", "Wiśniewska");
        Person p4 = new Person("Tomasz", "Dąbrowski");
        Person p5 = new Person("Kasia", "Mazur");
        Person p6 = new Person("Paweł", "Zieliński");
        Person p7 = new Person("Magda", "Woźniak");
        Person p8 = new Person("Ola", "Krawczyk");
        Person p9 = new Person("Marek", "Wójcik");
        Person p10 = new Person("Piotr", "Kaczmarek");

        Account acc1 = new Account(p1, 1000);
        Account acc2 = new Account(p2, 2000);
        Account acc3 = new Account(p3, 1500);

        BankAccount bankAcc1 = new BankAccount(p4, 5000);
        BankAccount bankAcc2 = new BankAccount(p5, 3000);
        BankAccount bankAcc3 = new BankAccount(p6, 2500);

        BankAccountVIP vipAcc1 = new BankAccountVIP(p7, 7000, 5.0, 1000);
        BankAccountVIP vipAcc2 = new BankAccountVIP(p8, 4000, 4.5, 1500);
        BankAccountVIP vipAcc3 = new BankAccountVIP(p9, 3500, 6.2, 800);
        BankAccountVIP vipAcc4 = new BankAccountVIP(p10, 4500, 5.8, 1200);

        List<Account> accounts = List.of(
                acc1,
                acc2,
                acc3,
                bankAcc1,
                bankAcc2,
                bankAcc3,
                vipAcc1,
                vipAcc2,
                vipAcc3,
                vipAcc4
        );

        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}