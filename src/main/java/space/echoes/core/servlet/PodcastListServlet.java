package space.echoes.core.servlet;

import space.echoes.core.model.PodcastEntity;
import space.echoes.core.service.PodcastService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/podcast/list")
public class PodcastListServlet extends HttpServlet {
    private PodcastService podcastService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        podcastService = (PodcastService) getServletContext().getAttribute("podcastService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<PodcastEntity> podcasts = podcastService.getAll();
        req.setAttribute("podcasts", podcasts);

        getServletContext().getRequestDispatcher("/WEB-INF/view/podcast/list-podcast.jsp").forward(req, resp);
    }
}
