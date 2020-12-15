package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Viktoriya on 15-Dec-20
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryTest {

	public static final String TEACUP = "Teacup";

	public static final String MY_DESCR = "MyDescr";

	@Autowired
	UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

	@Before
	public void setUp() {
		unitOfMeasureReactiveRepository.deleteAll().block();
	}

	@Test
	public void saveUnitOfMeasure() throws Exception {
		UnitOfMeasure newUnitOfMeasure = new UnitOfMeasure();

		newUnitOfMeasure.setDescription(TEACUP);
		UnitOfMeasure savedUnitOfMeasure = unitOfMeasureReactiveRepository.save(newUnitOfMeasure).block();

		assertNotNull(savedUnitOfMeasure.getId());
		assertEquals(TEACUP, savedUnitOfMeasure.getDescription());
	}

	@Test
	public void findByDescription() throws Exception {
		UnitOfMeasure newUnitOfMeasure = new UnitOfMeasure();
		newUnitOfMeasure.setDescription(MY_DESCR);
		UnitOfMeasure savedUnitOfMeasure = unitOfMeasureReactiveRepository.save(newUnitOfMeasure).block();

		UnitOfMeasure fetchedUnitOfMeasure = unitOfMeasureReactiveRepository.findByDescription(MY_DESCR).block();
		assertNotNull(fetchedUnitOfMeasure.getId());
		assertEquals(MY_DESCR, fetchedUnitOfMeasure.getDescription());
	}
}
