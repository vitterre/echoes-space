package space.echoes.core.mapper;

import space.echoes.core.model.PodcastEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class PodcastMapper implements RowMapper<PodcastEntity> {
    @Override
    public PodcastEntity from(ResultSet rs, int rowNum) throws SQLException {
        return PodcastEntity.builder()
                .uuid((UUID) rs.getObject("uuid"))
                .title(rs.getString("title"))
                .summary(rs.getString("summary"))
                .uploadDate((Timestamp) rs.getObject("upload_date"))
                .filePath(rs.getString("file_path"))
                .voices(rs.getString("voices"))
                .build();
    }
}
