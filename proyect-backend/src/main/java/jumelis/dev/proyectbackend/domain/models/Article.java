package jumelis.dev.proyectbackend.domain.models;

import java.time.LocalDateTime;

// Article model class that represents the article entity in the domain layer
public class Article {
    private Long id;
    private String title;
    private String imageURL;
    private String author;
    private LocalDateTime date;
    private String content;
    private boolean isPublished;
    private String url;

    // Constructor
    public Article(Long id, String title, String imageURL, String author, LocalDateTime date, String content,
                   boolean isPublished, String url) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.author = author;
        this.date = date;
        this.content = content;
        this.isPublished = isPublished;
        this.url = url;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public String getUrl() {
        return url;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Article [title=" + title + ", imageURL=" + imageURL + ", author=" + author + ", date=" + date
                + ", content=" + content + ", isPublished=" + isPublished + ", url=" + url + "]";
    }

}
