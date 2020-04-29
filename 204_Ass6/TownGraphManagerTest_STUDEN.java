
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManagerTest_STUDENT {
	private TownGraphManagerInterface graph;
	private String[] town;

	@Before
	public void setUp() throws Exception {
		graph = new TownGraphManager();
		town = new String[12];

		for (int i = 1; i < 12; i++) {
			town[i] = "Town_" + i;
			graph.addTown(town[i]);
		}
		graph.addRoad(town[3], town[7], 1, "Road_4");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_4", roads.get(0));
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_4", graph.getRoad(town[7], town[3]));
	}

}