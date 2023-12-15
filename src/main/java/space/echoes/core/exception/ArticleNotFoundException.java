package space.echoes.core.exception;

import java.util.UUID;

public class ArticleNotFoundException extends Exception {
    public ArticleNotFoundException(UUID articleUuid) {
        super("Article with provided uuid = " + articleUuid + " was not found.");
    }
}
