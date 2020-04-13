package ie.nuig.ct548.assignment3.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ie.nuig.ct548.assignment3.CricketData;

class CricketDataTests {

	@Test
	public void createAndTest() {
		CricketData cd = new CricketData();
		assertNotNull(cd);
	}

	@Test
	public void setScoreTest() {
		CricketData cd = new CricketData();
		cd.setScore(45, 7, 2);

		assertEquals(cd.getRuns(),45,0);
		assertEquals(cd.getOvers(), 7, 0);
		assertEquals(cd.getWickets(), 3, 1);
		
	}

}
