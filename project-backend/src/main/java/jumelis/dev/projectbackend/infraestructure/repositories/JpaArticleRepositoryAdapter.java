package jumelis.dev.projectbackend.infraestructure.repositories;

import jumelis.dev.projectbackend.domain.models.Article;
import jumelis.dev.projectbackend.domain.ports.out.ArticleRepositoryPort;
import jumelis.dev.projectbackend.infraestructure.entities.ArticleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// JpaArticleRepositoryAdapter is an implementation of the ArticleRepositoryPort port.
@Component
public class JpaArticleRepositoryAdapter implements ArticleRepositoryPort {
    // JpaArticleRepository is a Spring Data JPA repository that is used to access the database.
    private final JpaArticleRepository jpaArticleRepository;
    // JpaArticleRepositoryAdapter is an implementation of the ArticleRepositoryPort port.
    public JpaArticleRepositoryAdapter(JpaArticleRepository jpaArticleRepository) {
        this.jpaArticleRepository = jpaArticleRepository;
    }

    // getAll is a method that gets all articles.
    @Override
    public Article create(Article article) {
        ArticleEntity articleEntity = ArticleEntity.fromDomainModel(article);
        ArticleEntity savedArticleEntity = jpaArticleRepository.save(articleEntity);
        return savedArticleEntity.toDomainModel();
    }

    // getAll is a method that gets all articles.
    @Override
    public Optional<Article> update(Article article) {
        if (jpaArticleRepository.existsById(article.getId())) {
            ArticleEntity articleEntity = ArticleEntity.fromDomainModel(article);
            ArticleEntity updatedTaskEntity = jpaArticleRepository.save(articleEntity);
            return Optional.of(updatedTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    // getAll is a method that gets all articles.
    @Override
    public boolean delete(Long id) {
        if (jpaArticleRepository.existsById(id)) {
            jpaArticleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // getAll is a method that gets all articles.
    @Override
    public List<Article> getAll() {
        return jpaArticleRepository.findAll().stream().map(ArticleEntity::toDomainModel).collect(Collectors.toList());
    }

    // getById is a method that gets an article by id.
    @Override
    public Optional<Article> getById(Long id) {
        return jpaArticleRepository.findById(id).map(ArticleEntity::toDomainModel);
    }
}
