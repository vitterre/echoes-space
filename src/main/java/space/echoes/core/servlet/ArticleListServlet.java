package space.echoes.core.servlet;

import space.echoes.core.model.ArticleEntity;
import space.echoes.core.service.ArticleService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {
    private ArticleService articleService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ArticleEntity> articles = articleService.getAll();
        req.setAttribute("articles", articles);

        getServletContext().getRequestDispatcher("/WEB-INF/view/article/list-article.jsp").forward(req, resp);
    }
}
