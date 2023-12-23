package space.echoes.core.exception;

import java.util.UUID;

public class PodcastNotFoundException extends Exception {
    public PodcastNotFoundException(UUID podcastUuid) {
        super("Podcast with provided uuid = " + podcastUuid + " was not found.");

    }
}
