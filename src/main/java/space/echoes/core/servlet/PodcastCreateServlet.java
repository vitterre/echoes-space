package space.echoes.core.servlet;

import org.apache.commons.io.IOUtils;
import space.echoes.core.model.PodcastEntity;
import space.echoes.core.service.PodcastService;
import space.echoes.core.util.Validator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@WebServlet("/podcast/create")
@MultipartConfig
public class PodcastCreateServlet extends HttpServlet {
    private PodcastService podcastService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        podcastService = (PodcastService) getServletContext()
                .getAttribute("podcastService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/podcast/create-podcast.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String title = req.getParameter("title");
        final String summary = req.getParameter("summary");
        final Part podcastFilePart = req.getPart("podcastFile");

        final String fileName = UUID.randomUUID().toString() + ".mp3";
        final String filePath = "/Users/hero/Projects/echoes-space/" + fileName;

        if (Validator.isStringValid(title)
                && Validator.isStringValid(summary)
                && podcastFilePart.getSize() > 0) {
            try (InputStream fileContent = podcastFilePart.getInputStream();
                 OutputStream outputStream = new FileOutputStream(filePath)) {
                IOUtils.copy(fileContent, outputStream);
                PodcastEntity podcastEntity = podcastService.save(title, summary, filePath);
                resp.sendRedirect(req.getContextPath() + "/podcast/listen?podcast-uuid=" + podcastEntity.getUuid());
            }
        }

    }
}
