package space.echoes.core;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import space.echoes.core.util.ConnectionProvider;

@WebListener
public class ApplicationInitializationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
    }
}
