package jumelis.dev.projectbackend.infraestructure.config;

import jumelis.dev.projectbackend.application.services.ArticleService;
import jumelis.dev.projectbackend.application.usecases.*;
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
                new GetAllArticleUseCaseImpl(articleRepositoryPort),
                new GetArticleByIdUseCaseImpl(articleRepositoryPort)
        );
    }
}
