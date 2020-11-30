package exception;

public class UserAgeLess18Exception extends Exception {
    public UserAgeLess18Exception(String message) {
        super(message);
    }
}