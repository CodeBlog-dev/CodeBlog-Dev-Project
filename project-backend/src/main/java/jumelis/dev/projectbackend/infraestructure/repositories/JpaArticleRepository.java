package jumelis.dev.projectbackend.infraestructure.repositories;

import jumelis.dev.projectbackend.infraestructure.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
