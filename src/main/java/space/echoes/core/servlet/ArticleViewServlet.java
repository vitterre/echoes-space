package space.echoes.core.servlet;

import space.echoes.core.exception.ArticleNotFoundException;
import space.echoes.core.exception.UserAccountNotFoundException;
import space.echoes.core.model.AccountEntity;
import space.echoes.core.model.ArticleEntity;
import space.echoes.core.service.AccountService;
import space.echoes.core.service.ArticleService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/article/view")
public class ArticleViewServlet extends HttpServlet {
    private ArticleService articleService;
    private AccountService accountService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
        accountService = (AccountService) getServletContext().getAttribute("accountService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringArticleUuid = req.getParameter("article-uuid");
        UUID articleUuid = UUID.fromString(stringArticleUuid);

        try {
            ArticleEntity article = articleService.getByUuid(articleUuid);
            AccountEntity author = accountService.getByUuid(article.getAuthorUuid());

            req.getSession().setAttribute("viewingArticle",
                    article);
            req.getSession().setAttribute("viewingArticleAuthorName",
                    author.getFirstName() + " " + author.getLastName());
            req.getSession().setAttribute("viewingArticleDuration",
                    articleService.getReadingDuration(article));

        } catch (ArticleNotFoundException | UserAccountNotFoundException e) {
            throw new RuntimeException(e);

        }


        getServletContext().getRequestDispatcher("/WEB-INF/view/article/view-article.jsp").forward(req, resp);
    }
}
