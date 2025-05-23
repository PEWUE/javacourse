import exceptions.ItemNotAvailableException;
import exceptions.ItemNotBorrowedException;

public abstract class LibraryItem {
    private final String title;
    private boolean isBorrowed;

    public LibraryItem(String title, boolean isBorrowed) {
        this.title = title;
        this.isBorrowed = isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowItem() {
        if (isBorrowed) {
            throw new ItemNotAvailableException("Pozycja \"" + title + "\" " + "nie jest możliwa do wypożyczenia.");
        }
        isBorrowed = true;
    }

    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
        }
        throw new ItemNotBorrowedException("Nie możesz zwrócić \"" + title + "\". Pozycja nie jest przez Ciebie wypożyczona.");
    }
}
