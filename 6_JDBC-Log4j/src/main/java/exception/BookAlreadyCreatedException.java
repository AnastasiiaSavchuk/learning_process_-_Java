package exception;

public class BookAlreadyCreatedException extends Exception {
    public BookAlreadyCreatedException(String message) {
        super(message);
    }
}
