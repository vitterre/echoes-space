package space.echoes.core.mapper;

import space.echoes.core.model.ArticleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ArticleMapper implements RowMapper<ArticleEntity> {
    @Override
    public ArticleEntity from(ResultSet rs, int rowNum) throws SQLException {
        return new ArticleEntity(
                (UUID) rs.getObject("uuid"),
                rs.getString("title"),
                rs.getString("summary"),
                rs.getString("body"),
                (UUID) rs.getObject("author_uuid")
        );
    }
}
