package space.echoes.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper<E> {
    E from(ResultSet rs, int rowNum) throws SQLException;
}
