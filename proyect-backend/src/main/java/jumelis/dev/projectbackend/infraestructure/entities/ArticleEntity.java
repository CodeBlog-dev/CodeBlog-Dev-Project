package jumelis.dev.projectbackend.infraestructure.entities;

import jakarta.persistence.*;
import jumelis.dev.projectbackend.domain.models.Article;

import java.time.LocalDateTime;

// ArticleEntity is an entity that is used by the infrastructure layer to persist articles.
// It is mapped to the articles table in the database.
@Entity
@Table(name = "articles")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageURL;
    private String author;
    private LocalDateTime date;
    private String content;
    private boolean isPublished;
    private String url;

    public ArticleEntity() {
    }

    // ArticleEntity is an entity that is used by the infrastructure layer to persist articles.
    public ArticleEntity(Long id, String title, String imageURL, String author, LocalDateTime date, String content,
                         boolean isPublished,
                         String url) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.author = author;
        this.date = date;
        this.content = content;
        this.isPublished = isPublished;
        this.url = url;
    }

    // fromDomainModel is a method that converts an Article domain model to an ArticleEntity entity.
    public static ArticleEntity fromDomainModel(Article article) {
        return new ArticleEntity(article.getId(), article.getTitle(), article.getImageURL(), article.getAuthor(),
                article.getDate(), article.getContent(), article.isPublished(), article.getUrl());
    }

    // toDomainModel is a method that converts an ArticleEntity entity to an Article domain model.
    public Article toDomainModel() {
        return new Article(this.id, this.title, this.imageURL, this.author, this.date, this.content, this.isPublished,
                this.url);
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

}
