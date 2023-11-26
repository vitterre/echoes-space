package space.echoes.core.servlet;

import space.echoes.core.model.AccountEntity;
import space.echoes.core.repository.AccountRepositoryJdbcImpl;
import space.echoes.core.service.AccountService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    private AccountRepositoryJdbcImpl accountRepository;
    private AccountService accountService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        accountRepository = (AccountRepositoryJdbcImpl) getServletContext().getAttribute("accountRepositoryJdbcImpl");
        accountService = (AccountService) getServletContext().getAttribute("accountService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/security/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailAddress = req.getParameter("emailAddress");
        String password = req.getParameter("password");

        if (Objects.nonNull(emailAddress) && Objects.nonNull(password)) {
            Optional<AccountEntity> accountEntityOptional = accountRepository.findByEmailAddressAndPassword(emailAddress, password);

            if (accountEntityOptional.isEmpty()) {
                req.setAttribute("message", "Wrong pair emailAddress - password");
            } else {
                accountService.auth(accountEntityOptional.get(), req, resp);
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/view/security/signin.jsp").forward(req, resp);
    }


}
