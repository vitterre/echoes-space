package space.echoes.core.filter;

import space.echoes.core.service.AccountService;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter extends HttpFilter {
    private static final String[] securedPaths = new String[]{ "/article/create" };
    private AccountService accountService;

    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
        accountService = (AccountService) getServletContext().getAttribute("accountService");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean prot = false;
        for (String path : securedPaths) {
            if (path.equals(req.getRequestURI().substring(req.getContextPath().length()))) {
                prot = true;
                break;
            }
        }

        if (prot && !accountService.isNonAnonymous(req, res)) {
            res.sendRedirect(req.getContextPath() + "/sign-in");
        } else {
            if (accountService.isNonAnonymous(req, res)) {
                req.setAttribute("account", accountService.getAccount(req, res));
            }
            chain.doFilter(req, res);
        }
    }
}
