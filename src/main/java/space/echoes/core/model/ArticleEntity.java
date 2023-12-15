package space.echoes.core.model;

import java.util.Objects;
import java.util.UUID;

public class ArticleEntity {
    private UUID uuid;
    private String title;
    private String summary;
    private String body;
    private UUID authorUuid;

    public ArticleEntity(UUID uuid, String title, String summary, String body, UUID authorUuid) {
        this.uuid = uuid;
        this.title = title;
        this.summary = summary;
        this.body = body;
        this.authorUuid = authorUuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UUID getAuthorUuid() {
        return authorUuid;
    }

    public void setAuthorUuid(UUID authorUuid) {
        this.authorUuid = authorUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity that = (ArticleEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
