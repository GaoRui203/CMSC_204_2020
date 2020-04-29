import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Gao Rui
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {

	private townGraph graph = new townGraph();

	/**
	 *
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town newTown1 = null;
		Town newTown2 = null;

		HashSet<Town> towns = (HashSet<Town>) graph.vertexSet();
		Iterator itrTown = (Iterator) towns.iterator();

		while (itrTown.hasNext()) {
			Town t = (Town) itrTown.next();
			if (t.getName().equals(town1)) {
				newTown1 = t;
			}
			if (t.getName().equals(town2)) {
				newTown2 = t;
			}
		}

		if (graph.addEdge(newTown1, newTown2, weight, roadName) != null) {
			return true;
		} else
			return false;
	}

	/**
	 *
	 */
	@Override
	public String getRoad(String town1, String town2) {
		Town newTown1 = new Town(town1);
		Town newTown2 = new Town(town2);

		String road = (graph.getEdge(newTown1, newTown2)).getName();
		return road;
	}

	/**
	 *
	 */
	@Override
	public boolean addTown(String v) {
		Town newTown1 = new Town(v);
		boolean result = graph.addVertex(newTown1);

		return result;
	}

	/**
	 *
	 */
	@Override
	public boolean containsTown(String v) {
		Town newTown1 = new Town(v);
		boolean result = graph.containsVertex(newTown1);
		return result;
	}

	/**
	 *
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town newTown1 = new Town(town1);
		Town newTown2 = new Town(town2);
		boolean result = graph.containsEdge(newTown1, newTown2);
		return result;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> allRoads = new ArrayList<String>();

		Set<Road> roadSet = graph.edgeSet();
		TreeSet<Road> myTreeSet = new TreeSet<Road>(new MyNameComp());
		myTreeSet.addAll(roadSet);
		Iterator itr = (Iterator) myTreeSet.iterator();
		while (itr.hasNext()) {
			Road rR = (Road) itr.next();
			allRoads.add(rR.getName());
		}
		return allRoads;
	}

	/**
	 *
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town newTown1 = new Town(town1);
		Town newTown2 = new Town(town2);
		Road road1 = graph.getEdge(newTown1, newTown2);
		int weight = road1.getWeight();
		if (graph.removeEdge(newTown1, newTown2, weight, road) != null) {
			return true;
		} else
			return false;
	}

	/**
	 *
	 */
	@Override
	public boolean deleteTown(String v) {
		Town newTown1 = new Town(v);
		boolean result = graph.removeVertex(newTown1);
		return result;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> allTowns = new ArrayList<String>();
		Set<Town> townSet = graph.vertexSet();
		TreeSet<Town> myTreeSet = new TreeSet<Town>(new MyNameCompa());
		myTreeSet.addAll(townSet);
		Iterator itr = (Iterator) myTreeSet.iterator();
		while (itr.hasNext()) {

			allTowns.add(((Town) itr.next()).getName());
		}
		return allTowns;
	}

	// @Override
	/**
	 * @param town1
	 * @param town2
	 * @return
	 */
	public ArrayList<String> getPath1(String town1, String town2) {
		Town town11 = null, town22 = null;
		Set<Town> townSet = graph.vertexSet();
		Iterator itrTown = (Iterator) townSet.iterator();
		while (itrTown.hasNext()) {
			Town t = (Town) itrTown.next();
			if (t.getName().equals(town1)) {
				town11 = t;
			}
			if (t.getName().equals(town2)) {
				town22 = t;
			}
		}
		return graph.shortestPath(town11, town22);
	}

	/**
	 *
	 */
	public ArrayList<String> getPath(String town1, String town2) {
		String beginTown = town1, endTown = town2;
		Town beginIndex = null, endIndex = null;
		Set<Town> towns = graph.vertexSet();
		Iterator<Town> iterator = towns.iterator();
		while (iterator.hasNext()) {
			Town town = iterator.next();
			if (town.getName().equals(beginTown))
				beginIndex = town;
			if (town.getName().equals(endTown))
				endIndex = town;
		}
		ArrayList<String> rl = null;
		if (beginIndex != null && endIndex != null) {
			rl = graph.shortestPath(beginIndex, endIndex);
		}
		return rl;

	}

	/**
	 *
	 */
	@Override
	public Town getTown(String name) {

		return null;
	}

	/**
	 * @param string
	 * @param string2
	 * @return
	 */
	public ArrayList<String> getPathSets(String string, String string2) {

		return null;
	}
}

/**
 * @author Gao Rui
 *
 */
class MyNameComp implements Comparator<Road> {
	@Override
	public int compare(Road a, Road b) {
		return a.getName().compareTo(b.getName());
	}
}

/**
 * @author Gao Rui
 *
 */
class MyNameCompa implements Comparator<Town> {
	@Override
	public int compare(Town a, Town b) {
		return a.getName().compareTo(b.getName());
	}
}
