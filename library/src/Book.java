public class Book extends LibraryItem {
    public static int counter = 0;

    private final String author;
    private final int pages;

    public Book(String title, String author, int pages, boolean isBorrowed) {
        super(title, isBorrowed);
        this.author = author;
        this.pages = pages;
        counter++;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book - title: " + getTitle() +
                " author: " + getAuthor() +
                " pages: " + getPages() +
                " is borrowed: " + isBorrowed();
    }
}
