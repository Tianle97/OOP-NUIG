package nuig.cs.ie;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nuig.oop.model.Container;
import nuig.oop.model.Genre;
import nuig.oop.runtime.Application;

public class GenreTest {

	private static Container container;

	@BeforeClass
	public static void setUp() throws Exception {
		container = Application.jsonContainer("data.json");
	}

	// test gid exist in every genre
	@Test
	public void profileGenreExist() throws Exception {
		for (Genre g : container.getGenres()) {
			Assert.assertNotNull(g.getGid());
		}
	}

	// genre setter and getter test
	@Test
	public void genreSetterAndGetter() throws Exception {
		Genre g = new Genre();
		g.setGenre("Action");
		Assert.assertEquals("Action", g.getGenre());
	}
}
