package ie.nuig.ct548.assignment3.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ie.nuig.ct548.assignment3.AvgScoreDisplay;
import ie.nuig.ct548.assignment3.CricketData;

class AvgScoreDisplayTests {

	// test constructor and display
	@Test
	public void createAndTest() {
		AvgScoreDisplay asd = new AvgScoreDisplay();
		assertNotNull(asd);
	}

	// test the update method
	@Test
	public void updateTest() {
		CricketData cd = new CricketData();
		AvgScoreDisplay asd = new AvgScoreDisplay();
		cd.setScore(45, 5, 2);
		cd.addObserver(asd);
		asd.update(cd, null);
		
		assertEquals(Float.valueOf(asd.getRpo().getText()), 10, 1);
		assertEquals(Float.valueOf(asd.getRpw().getText()), 22.5, 0);
		assertEquals(Double.valueOf(asd.getWpo().getText()), 0.4, 0);
		
		
	}

}
