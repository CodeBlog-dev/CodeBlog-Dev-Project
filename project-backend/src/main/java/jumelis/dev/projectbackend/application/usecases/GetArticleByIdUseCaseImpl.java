package jumelis.dev.projectbackend.application.usecases;

import jumelis.dev.projectbackend.domain.models.Article;
import jumelis.dev.projectbackend.domain.ports.in.GetArticleByIdUseCase;
import jumelis.dev.projectbackend.domain.ports.out.ArticleRepositoryPort;

import java.util.Optional;

public class GetArticleByIdUseCaseImpl implements GetArticleByIdUseCase {
    // ArticleRepositoryPort is an interface that is used by the application layer to get an article by id.
    private final ArticleRepositoryPort articleRepositoryPort;
    // GetArticleByIdUseCaseImpl is an implementation of the GetArticleByIdUseCase port.
    public GetArticleByIdUseCaseImpl(ArticleRepositoryPort articleRepositoryPort) {
        this.articleRepositoryPort = articleRepositoryPort;
    }
    // getById is a method that gets an article by id.
    public Optional<Article> getById(Long id) {
        return articleRepositoryPort.getById(id);
    }
}
