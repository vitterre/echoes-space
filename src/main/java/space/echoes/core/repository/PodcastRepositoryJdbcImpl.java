package space.echoes.core.repository;

import space.echoes.core.mapper.PodcastMapper;
import space.echoes.core.mapper.RowMapper;
import space.echoes.core.model.ArticleEntity;
import space.echoes.core.model.PodcastEntity;
import space.echoes.core.util.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PodcastRepositoryJdbcImpl implements Repository<PodcastEntity> {
    private ConnectionProvider connectionProvider;
    private RowMapper<PodcastEntity> rowMapper;

    //language=sql
    private final String SQL_SAVE_PODCAST = """
            insert into podcast(uuid, title, summary, upload_date, file_path)
                values (?, ?, ?, ?, ?)
            """;

    //language=sql
    private final String SQL_FIND_PODCAST_BY_UUID = """
            select *
                from podcast
            where uuid = ?
            """;

    public PodcastRepositoryJdbcImpl(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
        this.rowMapper = new PodcastMapper();
    }

    public PodcastEntity save(PodcastEntity podcastEntity) {
        try (final PreparedStatement preparedStatement =
                     connectionProvider.getConnection().prepareStatement(SQL_SAVE_PODCAST)) {
            preparedStatement.setObject(1, podcastEntity.getUuid());
            preparedStatement.setString(2, podcastEntity.getTitle());
            preparedStatement.setString(3, podcastEntity.getSummary());
            preparedStatement.setObject(4, podcastEntity.getUploadDate());
            preparedStatement.setString(5, podcastEntity.getFilePath());

            preparedStatement.executeUpdate();

            return podcastEntity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<PodcastEntity> findByUuid(UUID podcastUuid) {
        try (final PreparedStatement preparedStatement =
                     connectionProvider.getConnection().prepareStatement(SQL_FIND_PODCAST_BY_UUID)) {
            preparedStatement.setObject(1, podcastUuid);
            List<PodcastEntity> podcastEntities = extract(rowMapper, preparedStatement.executeQuery());

            if (podcastEntities.isEmpty()) {
                return Optional.empty();
            }

            return Optional.of(podcastEntities.get(0));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
