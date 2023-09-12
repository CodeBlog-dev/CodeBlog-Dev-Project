package jumelis.dev.projectbackend.application.services;

import jumelis.dev.projectbackend.domain.models.Article;
import jumelis.dev.projectbackend.domain.ports.in.CreateArticleUseCase;
import jumelis.dev.projectbackend.domain.ports.in.DeleteArticleUseCase;
import jumelis.dev.projectbackend.domain.ports.in.GetAllArticleUseCase;
import jumelis.dev.projectbackend.domain.ports.in.UpdateArticleUseCase;

import java.util.List;
import java.util.Optional;

public class ArticleService implements CreateArticleUseCase, UpdateArticleUseCase, DeleteArticleUseCase, GetAllArticleUseCase {

    private final CreateArticleUseCase createArticleUseCase;
    private final UpdateArticleUseCase updateArticleUseCase;
    private final DeleteArticleUseCase deleteArticleUseCase;

    private final GetAllArticleUseCase getAllArticleUseCase;

    public ArticleService(CreateArticleUseCase createArticleUseCase,
                          UpdateArticleUseCase updateArticleUseCase,
                          DeleteArticleUseCase deleteArticleUseCase,
                          GetAllArticleUseCase getAllArticleUseCase) {
        this.createArticleUseCase = createArticleUseCase;
        this.updateArticleUseCase = updateArticleUseCase;
        this.deleteArticleUseCase = deleteArticleUseCase;
        this.getAllArticleUseCase = getAllArticleUseCase;
    }

    @Override
    public Article create(Article article) {
        return createArticleUseCase.create(article);
    }

    @Override
    public Optional<Article> update(Article article) {
        return updateArticleUseCase.update(article);
    }

    @Override
    public boolean delete(Long id) {
        return deleteArticleUseCase.delete(id);
    }

    @Override
    public List<Article> getAll() {
        return getAllArticleUseCase.getAll();
    }
}
