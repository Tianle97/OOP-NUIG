package nuig.cs.ie;

import org.junit.Assert;
import org.junit.Test;

import nuig.oop.model.Profiles;

public class ProfileTest {

	// name setter and getter test
	@Test
	public void nameSetterGetter() throws Exception {
		final Profiles p = new Profiles();
		p.setName("name setter");

		Assert.assertEquals("name setter", p.getName());
	}
}
