package nuig.cs.ie;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nuig.oop.model.Container;
import nuig.oop.model.Films;
import nuig.oop.model.Genre;
import nuig.oop.model.People;
import nuig.oop.runtime.Application;

public class ContainerTest {

	private static Container container;

	@BeforeClass
	public static void setUp() throws Exception {
		container = Application.jsonContainer("data.json");
	}

	// test film title exist in every hashset
	@Test
	public void filmTitleExist() throws Exception {
		for (Films f : container.getFilms()) {
			Assert.assertNotNull(f.getTitle());
		}
	}

	//test film genre match
	@Test
	public void genreLooseMatch() throws Exception {
		Genre g1 = new Genre();
		g1.setGid(3);
		g1.setGenre("abc");
		
		Genre g2 = new Genre();
		g2.setGid(3);
		g2.setGenre("abcd");
		
		Assert.assertNotEquals(g1, g2);
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
