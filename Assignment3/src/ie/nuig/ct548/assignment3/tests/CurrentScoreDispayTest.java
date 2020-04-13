package ie.nuig.ct548.assignment3.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ie.nuig.ct548.assignment3.CricketData;
import ie.nuig.ct548.assignment3.CurentScoreDisplay;

class CurrentScoreDispayTest {

	// test constructor and display
	@Test
	public void createAndTest() {
		CurentScoreDisplay csd = new CurentScoreDisplay();
		assertNotNull(csd);
	}

	// test the update method
	@Test
	public void updateTest() {
		CricketData cd = new CricketData();
		CurentScoreDisplay csd = new CurentScoreDisplay();
		cd.setScore(45, 7, 2);
		cd.addObserver(csd);
		csd.update(cd, null);

		// two assertEquals methods to test
		assertEquals(Integer.valueOf(csd.getRuns().getText()), 45, 0);
		assertEquals(Float.valueOf(csd.getOvers().getText()), 7, 0);
		assertEquals(Integer.valueOf(csd.getWickets().getText()), 2, 0);

	}

}
