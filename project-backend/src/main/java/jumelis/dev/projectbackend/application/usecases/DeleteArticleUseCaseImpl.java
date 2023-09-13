package jumelis.dev.projectbackend.application.usecases;

import jumelis.dev.projectbackend.domain.ports.in.DeleteArticleUseCase;
import jumelis.dev.projectbackend.domain.ports.out.ArticleRepositoryPort;


// DeleteArticleUseCaseImpl is an implementation of DeleteArticleUseCase port.
public class DeleteArticleUseCaseImpl implements DeleteArticleUseCase {
    // ArticleRepositoryPort is an interface that is used by the application layer to
    private final ArticleRepositoryPort articleRepositoryPort;
    // delete an article.
    public DeleteArticleUseCaseImpl(ArticleRepositoryPort articleRepositoryPort) {
        this.articleRepositoryPort = articleRepositoryPort;
    }
    // delete is a method that deletes an article.
    @Override
    public boolean delete(Long id) {
        return articleRepositoryPort.delete(id);
    }
}
