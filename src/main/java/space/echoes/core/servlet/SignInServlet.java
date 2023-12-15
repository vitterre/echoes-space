package space.echoes.core.servlet;

import space.echoes.core.exception.InvalidEmailAddressException;
import space.echoes.core.exception.UserAccountNotFoundException;
import space.echoes.core.exception.UserAccountWrongCredentialsException;
import space.echoes.core.model.AccountEntity;
import space.echoes.core.repository.AccountRepositoryJdbcImpl;
import space.echoes.core.service.AccountService;
import space.echoes.core.util.Validator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {
    private AccountService accountService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        accountService = (AccountService) getServletContext().getAttribute("accountService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/security/sign-in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String emailAddress = req.getParameter("emailAddress");
        final String password = req.getParameter("password");

        if (Validator.isStringValid(emailAddress)
                && Validator.isStringValid(password)) {
            try {
                if (!Validator.isEmailValid(emailAddress)) {
                    throw new InvalidEmailAddressException();
                }
                accountService.signIn(emailAddress, password, req, resp);
                resp.sendRedirect(req.getContextPath() + "/article/list");
                return;
            } catch (UserAccountNotFoundException | UserAccountWrongCredentialsException | InvalidEmailAddressException exception) {
                req.setAttribute("message", exception.getMessage());
            }
        } else {
            req.setAttribute("message", "Fill all the fields");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/security/sign-in.jsp").forward(req, resp);
    }


}
