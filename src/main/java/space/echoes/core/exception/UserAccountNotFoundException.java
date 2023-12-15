package space.echoes.core.exception;

import java.util.UUID;

public class UserAccountNotFoundException extends Exception {
    public UserAccountNotFoundException(String emailAddress) {
        super("Account with provided email address was not found");
    }
    public UserAccountNotFoundException(UUID uuid) {
        super("Account with provided uuid was not found");
    }
}
