package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Viktoriya on 15-Dec-20
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactiveRepositoryTest {

	public static final String YUMMY = "Yummy";

	@Autowired
	RecipeReactiveRepository recipeReactiveRepository;

	@Before
	public void setUp() {
		recipeReactiveRepository.deleteAll().block();
	}

	@Test
	public void testRecipeSave() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setDescription(YUMMY);

		recipeReactiveRepository.save(recipe).block();

		Long count = recipeReactiveRepository.count().block();

		assertEquals(Long.valueOf(1), count);
	}
}
