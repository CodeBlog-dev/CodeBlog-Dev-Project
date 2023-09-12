package jumelis.dev.proyectbackend.application.usecases;

import jumelis.dev.proyectbackend.domain.models.Article;
import jumelis.dev.proyectbackend.domain.ports.in.GetAllArticleUseCase;
import jumelis.dev.proyectbackend.domain.ports.out.ArticleRepositoryPort;

import java.util.List;

public class GetAllArticleUseCaseImpl implements GetAllArticleUseCase {
    // ArticleRepositoryPort is an interface that is used by the application layer to get all articles.
    private final ArticleRepositoryPort articleRepositoryPort;
    // GetAllArticleUseCaseImpl is an implementation of the GetAllArticleUseCase port.
    public GetAllArticleUseCaseImpl(ArticleRepositoryPort articleRepositoryPort) {
        this.articleRepositoryPort = articleRepositoryPort;
    }
    // getAll is a method that gets all articles.
    public List<Article> getAll() {
        return articleRepositoryPort.getAll();
    }
}
