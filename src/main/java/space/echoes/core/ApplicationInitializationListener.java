package space.echoes.core;

import space.echoes.core.repository.AccountRepositoryJdbcImpl;
import space.echoes.core.service.AccountService;
import space.echoes.core.util.ConnectionProvider;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationInitializationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
        sce.getServletContext().setAttribute("accountRepositoryJdbcImpl", new AccountRepositoryJdbcImpl(connectionProvider));
        sce.getServletContext().setAttribute("accountService", new AccountService());
    }
}
