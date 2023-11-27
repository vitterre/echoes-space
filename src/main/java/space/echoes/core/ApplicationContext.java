package space.echoes.core;

import javax.servlet.ServletContext;

public class ApplicationContext {
    private static ApplicationContext instance = new ApplicationContext();
    private ServletContext servletContext;

    private ApplicationContext() {}

    public static ApplicationContext getInstance() {
        return instance;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}
