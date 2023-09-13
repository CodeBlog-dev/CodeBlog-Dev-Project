package jumelis.dev.projectbackend.domain.ports.in;
import jumelis.dev.projectbackend.domain.models.Article;
import java.util.List;

public interface GetAllArticleUseCase {
    List<Article> getAll();
}
