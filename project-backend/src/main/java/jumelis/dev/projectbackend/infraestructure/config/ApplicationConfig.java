package jumelis.dev.projectbackend.infraestructure.config;

import jumelis.dev.projectbackend.application.services.ArticleService;
import jumelis.dev.projectbackend.application.usecases.CreateArticleUseCaseImpl;
import jumelis.dev.projectbackend.application.usecases.DeleteArticleUseCaseImpl;
import jumelis.dev.projectbackend.application.usecases.GetAllArticleUseCaseImpl;
import jumelis.dev.projectbackend.application.usecases.UpdateArticleUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jumelis.dev.projectbackend.domain.ports.out.ArticleRepositoryPort;
@Configuration
public class ApplicationConfig {
    @Bean
    public ArticleService articleService(ArticleRepositoryPort articleRepositoryPort) {
        return new ArticleService(
                new CreateArticleUseCaseImpl(articleRepositoryPort),
                new UpdateArticleUseCaseImpl(articleRepositoryPort),
                new DeleteArticleUseCaseImpl(articleRepositoryPort),
                new GetAllArticleUseCaseImpl(articleRepositoryPort)
        );
    }
}
