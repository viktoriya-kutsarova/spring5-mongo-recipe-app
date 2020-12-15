package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by Viktoriya on 15-Dec-20
 */
public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String> {

	Mono<UnitOfMeasure> findByDescription(String description);
}
