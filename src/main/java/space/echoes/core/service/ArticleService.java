package space.echoes.core.service;

import space.echoes.core.ApplicationContext;
import space.echoes.core.exception.ArticleNotFoundException;
import space.echoes.core.model.AccountEntity;
import space.echoes.core.model.ArticleEntity;
import space.echoes.core.repository.ArticleRepositoryJdbcImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class ArticleService {

    private ArticleRepositoryJdbcImpl articleRepository;

    public ArticleService() {
        articleRepository =
                (ArticleRepositoryJdbcImpl) ApplicationContext
                        .getInstance()
                        .getServletContext()
                        .getAttribute("articleRepositoryJdbcImpl");
    }

    public void prepareForPreview(String title, String summary, String articleBody, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("previewTitle", title);
        req.getSession().setAttribute("previewSummary", summary);
        req.getSession().setAttribute("previewArticleBody", articleBody);
    }

    public ArticleEntity getByUuid(UUID articleUuid) throws ArticleNotFoundException {
        Optional<ArticleEntity> articleEntityOptional = articleRepository.findByUuid(articleUuid);

        if (articleEntityOptional.isEmpty()) {
            throw new ArticleNotFoundException(articleUuid);
        }

        return articleEntityOptional.get();
    }

    public Set<ArticleEntity> getAll() {
        return articleRepository.getAll();
    }

    public ArticleEntity save(String title, String summary, String articleBody, AccountEntity author) {
        return articleRepository.save(new ArticleEntity(UUID.randomUUID(), title, summary, articleBody, author.getUuid()));
    }

    public Integer getReadingDuration(ArticleEntity articleEntity) {
        return articleEntity.getBody().split("\\s").length / 200;
    }
}
