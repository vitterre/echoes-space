package space.echoes.core.repository;

import space.echoes.core.mapper.AccountRowMapper;
import space.echoes.core.mapper.RowMapper;
import space.echoes.core.model.AccountEntity;
import space.echoes.core.util.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class AccountRepositoryJdbcImpl implements Repository<AccountEntity> {
    private ConnectionProvider connectionProvider;
    private RowMapper<AccountEntity> rowMapper;


    //language=sql
    private final String SQL_GET_BY_UUID = """
            select * from account where uuid = ?
            """;

    //language=sql
    private final String SQL_GET_BY_EMAIL_ADDRESS = """
            select * from account where email_address = ?
            """;

    //language=sql
    private final String SQL_GET_BY_EMAIL_ADDRESS_AND_PASSWORD = """
            select * from account where email_address = ? and hashed_password = ?
            """;

    //language=sql
    private final String SQL_SAVE_ACCOUNT = """
            insert into account(uuid, first_name, last_name, email_address, hashed_password)
                values (?, ?, ?, ?, ?) 
            """;

    public AccountRepositoryJdbcImpl(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
        this.rowMapper = new AccountRowMapper();
    }

    public Optional<AccountEntity> findByEmailAddressAndPassword(String emailAddress,
                                                                 String hashedPassword) {
        Optional<AccountEntity> accountEntityOptional;

        try (final PreparedStatement preparedStatement =
                     connectionProvider.getConnection().prepareStatement(SQL_GET_BY_EMAIL_ADDRESS_AND_PASSWORD)) {
            preparedStatement.setString(1, emailAddress);
            preparedStatement.setString(2, hashedPassword);

            final List<AccountEntity> accountList = extract(rowMapper, preparedStatement.executeQuery());

            accountEntityOptional = accountList.isEmpty() ? Optional.empty() : Optional.of(accountList.get(0));

            return accountEntityOptional;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<AccountEntity> findByUuid(UUID uuid) {
        Optional<AccountEntity> accountEntityOptional;

        try (final PreparedStatement preparedStatement =
                     connectionProvider.getConnection().prepareStatement(SQL_GET_BY_UUID)) {
            preparedStatement.setObject(1, uuid);

            List<AccountEntity> accountList = extract(rowMapper, preparedStatement.executeQuery());

            accountEntityOptional = accountList.isEmpty() ? Optional.empty() : Optional.of(accountList.get(0));

            return accountEntityOptional;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<AccountEntity> findByEmailAddress(String emailAddress) {
        Optional<AccountEntity> accountEntityOptional;

        try (final PreparedStatement preparedStatement =
                     connectionProvider.getConnection().prepareStatement(SQL_GET_BY_EMAIL_ADDRESS)) {
            preparedStatement.setString(1, emailAddress);

            final List<AccountEntity> accountList = extract(rowMapper, preparedStatement.executeQuery());

            accountEntityOptional = accountList.isEmpty() ? Optional.empty() : Optional.of(accountList.get(0));

            return accountEntityOptional;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(AccountEntity entity) {
        try (final PreparedStatement preparedStatement =
                     connectionProvider.getConnection().prepareStatement(SQL_SAVE_ACCOUNT)) {
            preparedStatement.setObject(1, entity.getUuid());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getLastName());
            preparedStatement.setString(4, entity.getEmailAddress());
            preparedStatement.setString(5, entity.getHashedPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
