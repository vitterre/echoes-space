package space.echoes.core.exception;

public class UserAccountNotFoundException extends Exception {
    public UserAccountNotFoundException(String emailAddress) {
        super("Account with provided email address was not found.");
    }
}
