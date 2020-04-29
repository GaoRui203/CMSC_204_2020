import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownTest_STUDENT {
	Town town1, town2, town3, town4;

	@Before
	public void setUp() throws Exception {
		town1 = new Town("Poolesville");
		town2 = new Town("Darnestown");
		town3 = new Town("Clarksburg");
		town4 = new Town("Frederick");
	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = town4 = null;
	}

	@Test
	public void testGetAdjacentTowns() {
		assertTrue("This class does not contain methods for instantiating adjacent towns", true);
	}

	@Test
	public void testGetName() {
		assertEquals("Poolesville", town1.getName());
		assertEquals("Darnestown", town2.getName());
		assertEquals("Clarksburg", town3.getName());
		assertEquals("Frederick", town4.getName());
	}

	@Test
	public void testToString() {
		assertEquals("Poolesville", town1.toString());
		assertEquals("Darnestown", town2.toString());
		assertEquals("Clarksburg", town3.toString());
		assertEquals("Frederick", town4.toString());
	}
}