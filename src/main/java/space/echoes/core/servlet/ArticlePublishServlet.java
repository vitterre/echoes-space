package space.echoes.core.servlet;

import space.echoes.core.model.AccountEntity;
import space.echoes.core.model.ArticleEntity;
import space.echoes.core.service.ArticleService;
import space.echoes.core.util.Validator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/article/publish")
public class ArticlePublishServlet extends HttpServlet {
    private ArticleService articleService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String title = req.getParameter("previewTitle");
        final String summary = req.getParameter("previewSummary");
        final String articleBody = req.getParameter("previewArticleBody");
        final AccountEntity account = (AccountEntity) req.getSession().getAttribute("account");

        if (Validator.isStringValid(title) &&
                Validator.isStringValid(summary) &&
                Validator.isStringValid(articleBody)) {
            articleService.save(title, summary, articleBody, account);
        }
    }
}
