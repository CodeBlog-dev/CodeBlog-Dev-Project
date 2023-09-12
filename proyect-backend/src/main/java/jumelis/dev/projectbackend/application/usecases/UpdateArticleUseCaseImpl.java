package jumelis.dev.projectbackend.application.usecases;

import jumelis.dev.projectbackend.domain.models.Article;
import jumelis.dev.projectbackend.domain.ports.in.UpdateArticleUseCase;
import jumelis.dev.projectbackend.domain.ports.out.ArticleRepositoryPort;

import java.util.Optional;

// UpdateArticleUseCaseImpl is an implementation of the UpdateArticleUseCase port.
public class UpdateArticleUseCaseImpl implements UpdateArticleUseCase {

    // ArticleRepositoryPort is an interface that is used by the application layer to update an article.
    private final ArticleRepositoryPort articleRepositoryPort;
    // UpdateArticleUseCaseImpl is an implementation of the UpdateArticleUseCase port.
    public UpdateArticleUseCaseImpl(ArticleRepositoryPort articleRepositoryPort) {
        this.articleRepositoryPort = articleRepositoryPort;
    }
    // update is a method that updates an article.
    @Override
    public Optional<Article> update(Article article) {
        return articleRepositoryPort.update(article);
    }

}
