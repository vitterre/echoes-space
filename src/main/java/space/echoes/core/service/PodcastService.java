package space.echoes.core.service;

import space.echoes.core.ApplicationContext;
import space.echoes.core.model.PodcastEntity;
import space.echoes.core.repository.PodcastRepositoryJdbcImpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class PodcastService {
    private PodcastRepositoryJdbcImpl podcastRepository;

    public PodcastService() {
        podcastRepository =
                (PodcastRepositoryJdbcImpl) ApplicationContext
                        .getInstance()
                        .getServletContext()
                        .getAttribute("podcastRepositoryJdbcImpl");
    }

    public PodcastEntity save(String title, String summary, String voices, String filePath) {
        return podcastRepository.save(PodcastEntity.builder()
                .uuid(UUID.randomUUID())
                .title(title)
                .summary(summary)
                .filePath(filePath)
                .uploadDate(new Timestamp(System.currentTimeMillis()))
                .voices(voices)
                .build()
        );
    }

    public PodcastEntity getByUuid(UUID podcastUuid) {
        Optional<PodcastEntity> podcastEntityOptional = podcastRepository.findByUuid(podcastUuid);

        if (podcastEntityOptional.isEmpty()) {
            throw new RuntimeException("podcast not found");
        }

        return podcastEntityOptional.get();
    }

    public Set<PodcastEntity> getAll() {
        return podcastRepository.getAll();
    }
}
