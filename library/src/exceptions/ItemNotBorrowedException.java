package exceptions;

public class ItemNotBorrowedException extends RuntimeException {
    public ItemNotBorrowedException(String message) {
        super(message);
    }
}
