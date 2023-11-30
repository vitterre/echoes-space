package space.echoes.core.exception;

public class UserAccountWrongCredentialsException extends Exception {
    public UserAccountWrongCredentialsException(String emailAddress) {
        super("Wrong credentials provided for " + emailAddress);
    }
}
