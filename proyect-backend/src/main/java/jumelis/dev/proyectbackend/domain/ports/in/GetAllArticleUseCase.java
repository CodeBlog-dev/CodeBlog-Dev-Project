package jumelis.dev.proyectbackend.domain.ports.in;
import jumelis.dev.proyectbackend.domain.models.Article;
import java.util.List;

public interface GetAllArticleUseCase {
    List<Article> getAll();
}
