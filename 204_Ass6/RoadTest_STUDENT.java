import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoadTest_STUDENT {
	Road road1, road2, road3, road4;
	Town town1 = new Town("Town 1");
	Town town2 = new Town("Town 2");
	Town town3 = new Town("Town 3");
	Town town4 = new Town("Town 4");
	Town town5 = new Town("Town 5");
	Town town7 = new Town("Town 7");
	Town town8 = new Town("Town 8");

	@Before
	public void setUp() throws Exception {
		road1 = new Road(town1, town2, 2, "Road 1");
		road2 = new Road(town1, town3, 4, "Road 2");
		road3 = new Road(town1, town5, 6, "Road 3");
		road4 = new Road(town4, town8, 3, "Road 4");
	}

	@After
	public void tearDown() throws Exception {
		road1 = road2 = road3 = road4 = null;
	}

	@Test
	public void testContains() {
		assertTrue(road1.contains(town1));
		assertTrue(road2.contains(town3));
		assertFalse(road3.contains(town2));

	}

	@Test
	public void testGetDestination() {
		assertEquals(town2, road1.getDestination());
		assertEquals(town3, road2.getDestination());
		assertEquals(town5, road3.getDestination());
	}

	@Test
	public void testGetName() {
		assertEquals("Road 1", road1.getName());
		assertEquals("Road 2", road2.getName());
		assertEquals("Road 3", road3.getName());

	}

	@Test
	public void testGetSource() {
		assertEquals(town1, road1.getSource());
	}

	@Test
	public void testGetWeight() {
		assertEquals(2, road1.getWeight());
		assertEquals(4, road2.getWeight());
		assertEquals(6, road3.getWeight());
		assertEquals(3, road4.getWeight());
	}

}