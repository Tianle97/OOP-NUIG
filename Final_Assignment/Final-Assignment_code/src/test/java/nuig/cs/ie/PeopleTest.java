package nuig.cs.ie;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nuig.oop.model.Container;
import nuig.oop.model.People;
import nuig.oop.model.Profiles;
import nuig.oop.runtime.Application;

public class PeopleTest {

	private static Container container;

	@BeforeClass
	public static void setUp() throws Exception {
		container = Application.jsonContainer("data.json");
	}

	// test pid exist in every people
	@Test
	public void profileGenreExist() throws Exception {
		for (People p : container.getPeople()) {
			Assert.assertNotNull(p.getPid());
		}
	}

	// name setter and getter test
	@Test
	public void nameSetterAndGetter() throws Exception {
		final Profiles p = new Profiles();
		p.setName("name setter");

		Assert.assertEquals("name setter", p.getName());
	}
}
