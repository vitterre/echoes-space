package space.echoes.core.exception;

public class InvalidEmailAddressException extends Exception {
    public InvalidEmailAddressException() {
        super("Bad email address format");
    }
}
