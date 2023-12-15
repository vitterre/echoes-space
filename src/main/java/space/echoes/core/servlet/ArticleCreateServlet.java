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

@WebServlet("/article/create")
public class ArticleCreateServlet extends HttpServlet {
    private ArticleService articleService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/article/create-article.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String title = req.getParameter("title");
        final String summary = req.getParameter("summary");
        final String articleBody = req.getParameter("articleBody");
        final AccountEntity account = (AccountEntity) req.getSession().getAttribute("account");


        if (Validator.isStringValid(title) &&
                Validator.isStringValid(summary) &&
                Validator.isStringValid(articleBody)) {
            ArticleEntity createdArticle = articleService.save(title, summary, articleBody, account);
//            req.setAttribute("viewArticle", createdArticle);

//            getServletContext().getRequestDispatcher("/WEB-INF/view/article/view-article.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/article/view?article-uuid=" + createdArticle.getUuid());
        }
    }
}
