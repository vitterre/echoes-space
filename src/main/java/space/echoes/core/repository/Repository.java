package space.echoes.core.repository;

import space.echoes.core.mapper.RowMapper;
import space.echoes.core.model.AccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface Repository<T> {
    default List<T> extract(RowMapper<T> rowMapper, ResultSet resultSet) throws SQLException {
        boolean next = resultSet.next();
        List<T> entities = new ArrayList<>();

        int i = 0;
        while (next) {
            entities.add(rowMapper.from(resultSet, i));
            next = resultSet.next();
            i++;
        }

        return entities;
    }
}