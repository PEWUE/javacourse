public class Movie extends LibraryItem {
    public static int counter = 0;

    private final String director;
    private final int duration;

    public Movie(String title, String director, int duration, boolean isBorrowed) {
        super(title, isBorrowed);
        this.director = director;
        this.duration = duration;
        counter++;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }

    public String toString() {
        return "Movie - title: " + getTitle() +
                " director: " + getDirector() +
                " duration: " + getDuration() +
                " is borrowed: " + isBorrowed();
    }
}
