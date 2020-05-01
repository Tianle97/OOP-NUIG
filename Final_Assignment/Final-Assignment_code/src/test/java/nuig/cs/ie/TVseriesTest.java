package nuig.cs.ie;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nuig.oop.factory.Factory;
import nuig.oop.factory.TVFactory;
import nuig.oop.model.Container;
import nuig.oop.model.Films;
import nuig.oop.model.TVseries;
import nuig.oop.runtime.Application;

public class TVseriesTest {

	private static Container container;

	@BeforeClass
	public static void setUp() throws Exception {
		container = Application.jsonContainer("data.json");
	}

	// test title exist in every films
	@Test
	public void titleExist() throws Exception {
		for (Films f : container.getFilms()) {
			Assert.assertNotNull(f.getTitle());
		}
	}

	// describe setter test
	@Test
	public void describeSetter() throws Exception {
		final Factory tvF = new TVFactory();
		TVseries tv = (TVseries) tvF.getInstance();
		tv.setDescription("describe tv");

		Assert.assertEquals("describe tv", tv.getDescription());
	}
}
