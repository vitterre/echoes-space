package space.echoes.core.repository;

import space.echoes.core.mapper.ArticleMapper;
import space.echoes.core.mapper.RowMapper;
import space.echoes.core.model.AccountEntity;
import space.echoes.core.model.ArticleEntity;
import space.echoes.core.util.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class ArticleRepositoryJdbcImpl implements Repository<ArticleEntity> {
    private ConnectionProvider connectionProvider;
    private RowMapper<ArticleEntity> rowMapper;

    //language=sql
    private final String SQL_GET_ALL_ARTICLES = """
            select *
                from article
            """;

    //language=sql
    private final String SQL_SAVE_ARTICLE = """
            insert into article(uuid, title, summary, body, author_uuid)
                values (?, ?, ?, ?, ?)
            """;

    //language=sql
    private final String SQl_FIND_ARTICLE_BY_UUID = """
            select *
                from article
            where uuid = ?
            """;

    public ArticleRepositoryJdbcImpl(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
        this.rowMapper = new ArticleMapper();
    }

    public Optional<ArticleEntity> findByUuid(UUID articleUuid) {
        try (final PreparedStatement preparedStatement =
                connectionProvider.getConnection().prepareStatement(SQl_FIND_ARTICLE_BY_UUID)) {
            preparedStatement.setObject(1, articleUuid);
            List<ArticleEntity> articleEntities = extract(rowMapper, preparedStatement.executeQuery());

            if (articleEntities.isEmpty()) {
                return Optional.empty();
            }

            return Optional.of(articleEntities.get(0));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<ArticleEntity> getAll() {
        try (final PreparedStatement preparedStatement =
                connectionProvider.getConnection().prepareStatement(SQL_GET_ALL_ARTICLES)) {
            List<ArticleEntity> articles = extract(rowMapper, preparedStatement.executeQuery());

            return new HashSet<>(articles);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArticleEntity save(ArticleEntity articleEntity) {
        try (final PreparedStatement preparedStatement =
                    connectionProvider.getConnection().prepareStatement(SQL_SAVE_ARTICLE)) {
            preparedStatement.setObject(1, articleEntity.getUuid());
            preparedStatement.setString(2, articleEntity.getTitle());
            preparedStatement.setString(3, articleEntity.getSummary());
            preparedStatement.setString(4, articleEntity.getBody());
            preparedStatement.setObject(5, articleEntity.getAuthorUuid());

            preparedStatement.executeUpdate();

            return articleEntity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
