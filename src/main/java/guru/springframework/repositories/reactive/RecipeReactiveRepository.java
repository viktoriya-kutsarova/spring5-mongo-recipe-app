package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by Viktoriya on 15-Dec-20
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
