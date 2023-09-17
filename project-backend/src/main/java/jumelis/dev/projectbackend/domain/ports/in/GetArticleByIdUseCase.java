package jumelis.dev.projectbackend.domain.ports.in;

import jumelis.dev.projectbackend.domain.models.Article;

import java.util.Optional;

public interface GetArticleByIdUseCase {
    Optional<Article> getById(Long id);
}
