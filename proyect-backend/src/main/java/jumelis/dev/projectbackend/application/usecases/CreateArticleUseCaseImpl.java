package jumelis.dev.projectbackend.application.usecases;

import jumelis.dev.projectbackend.domain.ports.in.CreateArticleUseCase;
import jumelis.dev.projectbackend.domain.ports.out.ArticleRepositoryPort;
import jumelis.dev.projectbackend.domain.models.Article;

// CreateArticleUseCaseImpl is an implementation of CreateArticleUseCase.
public class CreateArticleUseCaseImpl implements CreateArticleUseCase {

    // ArticleRepositoryPort is a port that is used by the application layer to access the article repository.
    private final ArticleRepositoryPort articleRepositoryPort;

    // CreateArticleUseCaseImpl is a constructor for CreateArticleUseCaseImpl.
    public CreateArticleUseCaseImpl(ArticleRepositoryPort articleRepositoryPort) {
        this.articleRepositoryPort = articleRepositoryPort;
    }

    // create creates an article.
    @Override
    public Article create(Article article) {
        return articleRepositoryPort.create(article);
    }


}
