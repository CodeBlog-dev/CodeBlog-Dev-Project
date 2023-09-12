package jumelis.dev.projectbackend.infraestructure.controllers;

import jumelis.dev.projectbackend.application.services.ArticleService;
import jumelis.dev.projectbackend.domain.models.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ArticleController {
    private final ArticleService articleService;
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // createArticle method that receives an Article object in the request body and returns a ResponseEntity
    // with a Map in the response body
    @PostMapping("/articles")
    public ResponseEntity<Map<String, Object>> createArticle(@RequestBody Article article) {
        Map<String, Object> response = new HashMap<>();
        try {
            Article articleCreated = articleService.create(article);
            response.put("success", true);
            response.put("message", "Article created successfully");
            response.put("data", articleCreated);
            return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201 Created
        } catch (Exception e) { // If an error occurred, return a JSON with HTTP status 500 INTERNAL SERVER ERROR
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }

    // updateArticle method that receives an Article object in the request body
    // and returns a ResponseEntity with an Article object in the response body
    @PutMapping("/articles")
    public ResponseEntity<Object> updateArticle(@RequestBody Article updatedArticle) {
        Optional<Article> optionalArticle = articleService.update(updatedArticle);

        if (optionalArticle.isPresent()) {
            // Return a JSON with the updated article and HTTP status 200 OK
            return ResponseEntity.ok(optionalArticle.get());
        } else {
            // Return a JSON with an error message and HTTP status 404 NOT FOUND
            String errorMessage = "Article with id " + updatedArticle.getId() + " was not found";
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Article not found");
            errorResponse.put("message", errorMessage);
            errorResponse.put("data", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Map<String, Object>> deleteArticle(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        // Try to delete the article and return a JSON with the result
        try {
            // If the article was deleted successfully, return a JSON with HTTP status 200 OK
            if (articleService.delete(id)) {
                response.put("success", true);
                response.put("message", "Article with id " + id + " was deleted");
                return ResponseEntity.ok(response); // 200 OK
            } else { // If the article was not found, return a JSON with HTTP status 404 NOT FOUND
                response.put("success", false);
                response.put("error", "Article not found");
                response.put("message", "Article with id " + id + " was not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // 404 Not Found
            }
        } catch (Exception e) { // If an error occurred, return a JSON with HTTP status 500 INTERNAL SERVER ERROR
            response.put("success", false);
            response.put("error", "Internal Server Error");
            response.put("message", "An error occurred while processing the request.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 Internal Server Error
        }
    }
    @GetMapping("/articles")
    public ResponseEntity<Map<String, Object>> getArticles() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Articles retrieved successfully");
        response.put("data", articleService.getAll());
        return ResponseEntity.ok(response);
    }
}
