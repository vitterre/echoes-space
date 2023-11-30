package space.echoes.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionProvider {
    private static ConnectionProvider instance;

    public static ConnectionProvider getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ConnectionProvider();
        }

        return instance;
    }

    private Connection connection;

    private ConnectionProvider() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/echoes_space",
                    "postgres",
                    "2h9yd8y2");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
