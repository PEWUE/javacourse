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
        isBorrowed = true;
    }

    public void returnItem() {
        isBorrowed = false;
    }
}
