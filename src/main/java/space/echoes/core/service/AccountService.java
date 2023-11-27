package space.echoes.core.service;

import space.echoes.core.ApplicationContext;
import space.echoes.core.exception.UserAccountNotFoundException;
import space.echoes.core.exception.UserAccountWrongCredentialsException;
import space.echoes.core.model.AccountEntity;
import space.echoes.core.repository.AccountRepositoryJdbcImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

public class AccountService {
    private AccountRepositoryJdbcImpl accountRepository;

    public AccountService() {
        accountRepository =
                (AccountRepositoryJdbcImpl) ApplicationContext
                        .getInstance()
                        .getServletContext()
                        .getAttribute("accountRepositoryJdbcImpl");
    }

    private void auth(AccountEntity account, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("account", account);
    }

    public boolean isNonAnonymous(HttpServletRequest request, HttpServletResponse response) {
        return Objects.nonNull(request.getSession().getAttribute("account"));
    }

    public AccountEntity getAccount(HttpServletRequest request, HttpServletResponse response) {
        return (AccountEntity) request.getSession().getAttribute("account");
    }

    public void signIn(String emailAddress, String password, HttpServletRequest request, HttpServletResponse response)
            throws UserAccountNotFoundException, UserAccountWrongCredentialsException {
        final Optional<AccountEntity> accountEntityByEmailAddress = accountRepository.findByEmailAddress(emailAddress);

        if (accountEntityByEmailAddress.isEmpty()) {
            throw new UserAccountNotFoundException(emailAddress);
        }

        final Optional<AccountEntity> accountEntityByCredentials =
                accountRepository.findByEmailAddressAndPassword(emailAddress, password);

        if (accountEntityByCredentials.isEmpty()) {
            throw new UserAccountWrongCredentialsException(emailAddress);
        }

        auth(accountEntityByCredentials.get(), request, response);
    }
}
