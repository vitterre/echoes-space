package space.echoes.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodcastEntity {
    private UUID uuid;
    private String title;
    private String summary;
    private Timestamp uploadDate;
    private String voices;
    private String filePath;
}
