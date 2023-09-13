package jumelis.dev.projectbackend.domain.ports.out;

import jumelis.dev.projectbackend.domain.models.Article;

import java.util.List;
import java.util.Optional;


// This is a port for the ArticleRepository class
public interface ArticleRepositoryPort {
    // TODO: Add pagination
    Article create(Article article);

    Optional<Article> update(Article article);

    boolean delete(Long id);

    List<Article> getAll();
}
