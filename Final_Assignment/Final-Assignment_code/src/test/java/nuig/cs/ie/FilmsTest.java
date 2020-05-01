package nuig.cs.ie;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nuig.oop.factory.Factory;
import nuig.oop.factory.FilmFactory;
import nuig.oop.model.Container;
import nuig.oop.model.Films;
import nuig.oop.model.People;
import nuig.oop.runtime.Application;

public class FilmsTest {

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

	//title setter test
	@Test
	public void titleSetter() throws Exception {
		final Factory film = new FilmFactory();
		Films f = (Films) film.getInstance();
		f.setTitle("ABC");
		
		Assert.assertEquals("ABC", f.getTitle());
	}

	//test the director match
	@Test
	public void directorMatch() throws Exception {
		for (Films f : container.getFilms()) {
			String director = f.getDirector();
			for (People p : container.getPeople()) {
				if (p.getPid() == (Integer.parseInt(director))) {
					// System.out.println(city.getName());
					// Assert.assertEquals(country.getCapital().hashCode(), city.hashCode());
					Assert.assertEquals(Integer.parseInt(f.getDirector()), p.getPid());
				}
			}
		}
	}
}
