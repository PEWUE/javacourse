import exceptions.ItemNotAvailableException;
import exceptions.ItemNotBorrowedException;
import exceptions.ItemNotFoundException;
import functional.ListPrinter;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    public static final int EXIT = 0;
    public static final int DISPLAY_ITEMS = 1;
    public static final int BORROW_ITEM = 2;
    public static final int RETURN_ITEM = 3;
    public static final int DISPLAY_ITEMS_COUNTER = 4;

    public static Library library = new Library();

    public static void main(String[] args) {
        int userChoice = -1;

        while (userChoice != EXIT) {
            try {
                System.out.println("Wybierz opcje: ");
                System.out.println(DISPLAY_ITEMS + " - wyświetl dostępne i wypożyczone");
                System.out.println(BORROW_ITEM + " - wypożycz");
                System.out.println(RETURN_ITEM + " - zwróć");
                System.out.println(DISPLAY_ITEMS_COUNTER + " - wyświetl liczbę książek/filmów");
                System.out.println(EXIT + " - zamknij program");

                userChoice = sc.nextInt();
                sc.nextLine();

                switch (userChoice) {
                    case DISPLAY_ITEMS -> displayItems();
                    case BORROW_ITEM -> borrowItem();
                    case RETURN_ITEM -> returnItem();
                    case DISPLAY_ITEMS_COUNTER -> displayItemsCounter();
                    case EXIT -> close();
                }
            } catch (ItemNotAvailableException | ItemNotFoundException | ItemNotBorrowedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void close() {
        sc.close();
        System.out.println("Bye bye");
    }

    private static void displayItemsCounter() {
        System.out.println("Liczba książek: " + Book.counter);
        System.out.println("Liczba filmów: " + Movie.counter);
    }

    private static void borrowItem() {
        System.out.println("Podaj tytuł: ");
        String title = sc.nextLine();
        boolean result = library.borrow(title);
        System.out.println(result ? "Wypożyczono pomyślnie" : "Nie można wypożyczyć");
    }

    private static void returnItem() {
        System.out.println("Podaj tytuł: ");
        String title = sc.nextLine();
        boolean result = library.returnItem(title);
        System.out.println(result ? "Zwrócono pomyślnie" : "Nie można zwrócić");
    }

    private static void displayItems() {
        List<LibraryItem> libraryItems = library.getItems();
        ListPrinter<LibraryItem> printer = (list, predicate) -> list.stream()
                .filter(predicate)
                .forEach(System.out::println);
        Predicate<LibraryItem> available = item -> !item.isBorrowed();
        Predicate<LibraryItem> borrowed = LibraryItem::isBorrowed;

        System.out.println("Dostępne książki/filmy: ");
        printer.print(libraryItems, available);

        System.out.println("Wypożyczone książki/filmy: ");
        printer.print(libraryItems, borrowed);
    }
}