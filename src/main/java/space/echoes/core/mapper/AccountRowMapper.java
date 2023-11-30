package space.echoes.core.mapper;

import space.echoes.core.model.AccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AccountRowMapper implements RowMapper<AccountEntity> {
    @Override
    public AccountEntity from(ResultSet rs, int rowNum) throws SQLException {
        return new AccountEntity(
                (UUID) rs.getObject("uuid"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email_address"),
                rs.getString("hashed_password")
        );
    }
}
