package jumelis.dev.projectbackend.domain.ports.in;

import jumelis.dev.projectbackend.domain.models.Article;

import java.util.Optional;

// UpdateArticleUseCase is a port that is used by the application layer to update
public interface UpdateArticleUseCase {
    Optional<Article> update(Article article);
}
