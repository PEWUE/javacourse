import exceptions.ItemNotFoundException;

import java.util.List;

public class Library {
    List<LibraryItem> libraryItems = List.of(
            new Book("Tytuł książki 1", "Autor 1", 300, true),
            new Book("Tytuł książki 2", "Autor 2", 200, false),
            new Movie("Tytuł filmu 1", "Reżyser 1", 128, false),
            new Book("Tytuł książki 3", "Autor 3", 256, true),
            new Movie("Tytuł filmu 2", "Reżyser 2", 90, false),
            new Book("Tytuł książki 4", "Autor 4", 512, true),
            new Movie("Tytuł filmu 3", "Reżyser 3", 150, true),
            new Book("Tytuł książki 5", "Autor 5", 100, true),
            new Movie("Tytuł filmu 4", "Reżyser 4", 168, false)
    );

    public List<LibraryItem> getItems() {
        return libraryItems;
    }

    public boolean borrow(String title) {
        LibraryItem byTitle = findByTitle(title);

        if (!byTitle.isBorrowed()) {
            byTitle.borrowItem();
            return true;
        }
        return false;
    }

    public boolean returnItem(String title) {
        LibraryItem byTitle = findByTitle(title);

        if (byTitle.isBorrowed()) {
            byTitle.returnItem();
            return true;
        }
        return false;
    }

    private LibraryItem findByTitle(String title) {
        return libraryItems.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Nie znaleziono pozycji \"" + title + "\"."));

    }
}
