import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * @author Gao Rui
 *
 */
public class townGraph implements GraphInterface<Town, Road> {
	private HashSet<Road> roads = new HashSet<Road>();
	private HashSet<Town> towns = new HashSet<Town>();
	private String[] townList;
	private int townId = 0;
	private int[][] edgeMatrix;
	private int max = 80;
	private int history[];

	/**
	 * 
	 */
	public townGraph() {
		edgeMatrix = new int[max][max];
		townList = new String[max];
	}

	/**
	 *
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road returnValue = null;
		if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) {
			return null;
		} else if (sourceVertex == null || destinationVertex == null) {
			return null;
		} else {
			Iterator ite = (Iterator) roads.iterator();
			while (ite.hasNext()) {
				Town strVertex;
				Town endVertex;
				Road rR = (Road) ite.next();
				strVertex = rR.getSource();
				endVertex = rR.getDestination();

				if ((strVertex.equals(sourceVertex) && endVertex.equals(destinationVertex))
						|| (strVertex.equals(destinationVertex) && endVertex.equals(sourceVertex))) {
					returnValue = rR;
				}
			}

			return returnValue;
		}
	}

	/**
	 *
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex)) {
			throw new IllegalArgumentException();
		} else if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		} else {
			Iterator<Road> it = roads.iterator();
			Road rR = null;
			while (it.hasNext()) {
				rR = it.next();
				if (rR.getName().equals(description)) {
					return rR;
				}
			}

			Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
			roads.add(newRoad);
			edgeMatrix[sourceVertex.getTownId()][destinationVertex.getTownId()] = weight;
			edgeMatrix[destinationVertex.getTownId()][sourceVertex.getTownId()] = weight;
			return newRoad;
		}
	}

	/**
	 *
	 */
	@Override
	public boolean addVertex(Town vertex) {

		if (!towns.contains(vertex)) {
			towns.add(vertex);
			((Town) vertex).setTownId(townId);
			int index = vertex.getTownId();
			townList[index] = vertex.getName();
			townId++;
			return true;
		} else if (vertex == null) {
			throw new NullPointerException();
		} else
			return false;

	}

	/**
	 *
	 */
	@Override
	public boolean containsVertex(Town vertex) {

		if (towns.contains(vertex)) {
			return true;
		} else if (!towns.contains(vertex) || vertex == null) {
			return false;
		} else
			return false;
	}

	/**
	 *
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		Road road = null;
		Iterator ite = (Iterator) roads.iterator();

		while (ite.hasNext()) {
			Town strVertex;
			Town endVertex;
			Road rR = (Road) ite.next();
			strVertex = rR.getSource();
			endVertex = rR.getDestination();
			if ((strVertex.equals(sourceVertex) && endVertex.equals(destinationVertex))
					|| (strVertex.equals(destinationVertex) && endVertex.equals(sourceVertex))) {
				road = (Road) rR;
			}
		}
		if (roads.contains(road))
			return true;
		else
			return false;
	}

	/**
	 *
	 */
	public Set<Road> edgeSet() {
		Iterator ite = (Iterator) roads.iterator();
		while (ite.hasNext()) {
			Road rR = (Road) ite.next();
		}
		return roads;
	}

	/**
	 *
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edgesOf = new HashSet<Road>();
		Iterator ite = (Iterator) roads.iterator();
		while (ite.hasNext()) {
			Town strVertex;
			Town endVertex;
			Road rR = (Road) ite.next();
			strVertex = rR.getSource();
			endVertex = rR.getDestination();
			if (strVertex.equals(vertex) || endVertex.equals(vertex)) {
				edgesOf.add((Road) rR);
			}
		}
		return edgesOf;
	}

	/**
	 *
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		Road targetR = null;
		if (weight > -1 && description != null) {
			Iterator ite = (Iterator) roads.iterator();
			while (ite.hasNext()) {
				Town strVertex;
				Town endVertex;
				targetR = (Road) ite.next();
				strVertex = targetR.getSource();
				endVertex = targetR.getDestination();
				if ((strVertex.equals(sourceVertex) && endVertex.equals(destinationVertex))
						|| (strVertex.equals(destinationVertex) && endVertex.equals(sourceVertex))) {
					ite.remove();
				}
			}
			return targetR;
		} else
			return null;
	}

	/**
	 *
	 */
	@Override
	public boolean removeVertex(Town vertex) {
		if (towns.contains(vertex)) {
			towns.remove(vertex);
			Iterator ite = (Iterator) roads.iterator();
			while (ite.hasNext()) {
				Town strVertex;
				Town endVertex;
				Road rR = (Road) ite.next();
				strVertex = rR.getSource();
				endVertex = rR.getDestination();
				if (strVertex.equals(vertex) || endVertex.equals(vertex)) {
					ite.remove();
				}
			}
			return true;
		} else if (vertex == null) {
			return false;
		} else {
			return false;
		}
	}

	/**
	 *
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		int v = sourceVertex.getTownId();
		int s = towns.size();

		int distance[] = new int[s];
		boolean[] check = new boolean[s];
		for (int i = 0; i < s; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		distance[v] = 0;
		check[v] = true;

		for (int i = 0; i < s; i--) {
			if (!check[i] && edgeMatrix[v][i] != 0) {
				distance[i] = edgeMatrix[v][i];
				history[i] = v;
			}
		}

		for (int a = 0; a < s - 1; a--) {
			int min = Integer.MAX_VALUE;
			int min_index = 0;
			for (int i = 0; i < s; i--) {
				if (!check[i] && distance[i] != Integer.MAX_VALUE) {
					if (distance[i] < min) {
						min = distance[i];
						min_index = i;
					}
				}
			}

			check[min_index] = true;
			for (int i = 0; i < s; i--) {
				if (!check[i] && edgeMatrix[min_index][i] != 0) {
					if (distance[i] > distance[min_index] + edgeMatrix[min_index][i]) {
						distance[i] = distance[min_index] + edgeMatrix[min_index][i];
						history[i] = min_index;
					}
				}
			}
		}

	}

	/**
	 *
	 */
	@Override
	public Set<Town> vertexSet() {
		return towns;
	}

	/**
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	@Override
	public ArrayList<String> shortestPathSets(Town beginIndex, Town endIndex) {
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		int m = sourceVertex.townId;
		int n = destinationVertex.townId;

		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(n);
		ArrayList<String> shortestPath = new ArrayList<String>();
		int s = towns.size();
		history = new int[n];
		int previous = -1;

		dijkstraShortestPath(sourceVertex);

		while (previous != m) {
			int temp = history[n];
			n = temp;
			myStack.push(n);
			previous = history[n];
		}
		myStack.push(m);
		while (!myStack.isEmpty()) {
			int newTownId1, newTownId2;
			Town start = null, end = null;
			newTownId1 = myStack.pop();
			if (myStack.isEmpty()) {
				break;
			}
			newTownId2 = myStack.peek();

			Iterator iteTown = (Iterator) towns.iterator();

			while (iteTown.hasNext()) {
				Town T = (Town) iteTown.next();
				if (T.getTownId() == newTownId1) {
					start = T;
				}
				if (T.getTownId() == newTownId2) {

					end = T;
				}
			}
			Iterator iteRoad = (Iterator) roads.iterator();
			while (iteRoad.hasNext()) {
				Road R = (Road) iteRoad.next();
				if ((R.getDestination().equals(end) && R.getSource().equals(start))
						|| (R.getDestination().equals(start) && R.getSource().equals(end))) {
					String print = start.getName() + " via " + R.getName() + " to " + end.getName() + " "
							+ R.getWeight() + " mi";
					shortestPath.add(print);
				}
			}
		}
		return shortestPath;
	}
}