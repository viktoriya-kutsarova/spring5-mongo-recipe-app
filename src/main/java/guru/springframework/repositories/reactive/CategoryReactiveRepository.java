package guru.springframework.repositories.reactive;

import java.util.Optional;

import guru.springframework.domain.Category;
import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by Viktoriya on 15-Dec-20
 */
public interface CategoryReactiveRepository extends ReactiveMongoRepository<Category, String> {

	Mono<Category> findByDescription(String description);
}
