package jumelis.dev.proyectbackend.domain.ports.in;

public interface DeleteArticleUseCase {

    // delete is a method that deletes an article.
    boolean delete(Long id);
}
