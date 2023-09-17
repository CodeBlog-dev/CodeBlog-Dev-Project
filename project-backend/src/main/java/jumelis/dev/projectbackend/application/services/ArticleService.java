package jumelis.dev.projectbackend.application.services;

import jumelis.dev.projectbackend.domain.models.Article;
import jumelis.dev.projectbackend.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class ArticleService implements CreateArticleUseCase, UpdateArticleUseCase, DeleteArticleUseCase, GetAllArticleUseCase, GetArticleByIdUseCase {

    private final CreateArticleUseCase createArticleUseCase;
    private final UpdateArticleUseCase updateArticleUseCase;
    private final DeleteArticleUseCase deleteArticleUseCase;

    private final GetAllArticleUseCase getAllArticleUseCase;
    private final GetArticleByIdUseCase getArticleByIdUseCase;

    public ArticleService(CreateArticleUseCase createArticleUseCase,
                          UpdateArticleUseCase updateArticleUseCase,
                          DeleteArticleUseCase deleteArticleUseCase,
                          GetAllArticleUseCase getAllArticleUseCase,
                          GetArticleByIdUseCase getArticleByIdUseCase) {
        this.createArticleUseCase = createArticleUseCase;
        this.updateArticleUseCase = updateArticleUseCase;
        this.deleteArticleUseCase = deleteArticleUseCase;
        this.getAllArticleUseCase = getAllArticleUseCase;
        this.getArticleByIdUseCase = getArticleByIdUseCase;

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

    @Override
    public Optional<Article> getById(Long id) {
        return getArticleByIdUseCase.getById(id);
    }
}
