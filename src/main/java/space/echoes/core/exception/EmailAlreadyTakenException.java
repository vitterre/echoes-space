package space.echoes.core.exception;

public class EmailAlreadyTakenException extends Exception {
    public EmailAlreadyTakenException() {
        super("This email address is already taken");
    }
}
