package space.echoes.core.repository;

import space.echoes.core.mapper.AccountRowMapper;
import space.echoes.core.mapper.RowMapper;
import space.echoes.core.model.AccountEntity;
import space.echoes.core.util.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AccountRepositoryJdbcImpl implements Repository<AccountEntity> {
    private ConnectionProvider connectionProvider;
    private RowMapper rowMapper;

    public AccountRepositoryJdbcImpl(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
        this.rowMapper = new AccountRowMapper();
    }

    public Optional<AccountEntity> findByEmailAddressAndPassword(final String emailAddress,
                                                                       final String hashedPassword) {
        Optional<AccountEntity> accountEntityOptional;

        try {
            final PreparedStatement preparedStatement =
                    connectionProvider.getConnection().prepareStatement("select * from account where email_address = ? and hashed_password = ?");
            preparedStatement.setString(1, emailAddress);
            preparedStatement.setString(2, hashedPassword);

            final List<AccountEntity> accountList = extract(rowMapper, preparedStatement.executeQuery());

            accountEntityOptional = accountList.isEmpty() ? Optional.empty() : Optional.of(accountList.get(0));

            return accountEntityOptional;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
