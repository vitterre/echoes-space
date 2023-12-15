package space.echoes.core.servlet;

import org.apache.commons.io.IOUtils;
import space.echoes.core.model.PodcastEntity;
import space.echoes.core.service.PodcastService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@WebServlet("/podcast/get-audio")
public class PodcastGetAudioServlet extends HttpServlet {
    private PodcastService podcastService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        podcastService = (PodcastService) getServletContext().getAttribute("podcastService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringPodcastUuid = req.getParameter("podcast-uuid");
        UUID podcastUuid = UUID.fromString(stringPodcastUuid);

        PodcastEntity podcastEntity = podcastService.getByUuid(podcastUuid);
        String podcastFilePath = podcastEntity.getFilePath();

        try (InputStream fileContent = new FileInputStream(podcastFilePath)) {
            resp.setContentType("audio/mp3");
            resp.setContentLength((int)new File(podcastFilePath).length());

            IOUtils.copy(fileContent, resp.getOutputStream());
            resp.getOutputStream().flush();
        }
    }
}
