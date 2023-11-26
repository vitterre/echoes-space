package space.echoes.core.service;

import space.echoes.core.model.AccountEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class AccountService {
    public void auth(AccountEntity account, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("account", account);
    }

    public boolean isNonAnonymous(HttpServletRequest request, HttpServletResponse response) {
        return Objects.nonNull(request.getSession().getAttribute("account"));
    }

    public AccountEntity getAccount(HttpServletRequest request, HttpServletResponse response) {
        return (AccountEntity) request.getSession().getAttribute("account");
    }
}
