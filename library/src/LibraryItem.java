import exceptions.ItemNotAvailableException;

public abstract class LibraryItem {
    private String title;
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
            throw new ItemNotAvailableException("Pozycja \"" + title + "\" " + "nie jest obecnie możliwa do wypożyczenia.");
        }
        isBorrowed = true;
    }

    public void returnItem() {
        isBorrowed = false;
    }
}
