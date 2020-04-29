import java.util.Set;

/**
 * @author Gao Rui
 *
 */
public class Road implements Comparable<Road> {

	private String roadName;
	private Town source;
	private Town destination;
	private int weight;

	/**
	 * @param begin
	 * @param finish
	 * @param distance
	 * @param name
	 */
	public Road(Town begin, Town finish, int distance, String name) {
		roadName = name;
		source = begin;
		destination = finish;
		weight = distance;
	}

	/**
	 * @param begin
	 * @param finish
	 * @param name
	 */
	public Road(Town begin, Town finish, String name) {
		roadName = name;
		source = begin;
		destination = finish;
		weight = 1;
	}

	/**
	 * @param town
	 * @return
	 */
	public boolean contains(Town town) {
		if (source.equals(town) || destination.equals(town))
			return true;
		else
			return false;
	}

	/**
	 *
	 */
	public java.lang.String toString() {
		return source.getName() + " via " + roadName + " to " + destination.getName() + " " + weight + " mi";
	}

	/**
	 * @return
	 */
	public java.lang.String getName() {
		return roadName;
	}

	/**
	 * @return
	 */
	public Town getDestination() {
		return destination;
	}

	/**
	 * @return
	 */
	public Town getSource() {
		return source;
	}

	/**
	 *
	 */
	@Override
	public int compareTo(Road edge) {

		if (roadName.equals(edge.getName()))
			return 0;
		else
			return 1;
	}

	/**
	 * @return
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 *
	 */
	public boolean equals(java.lang.Object r) {
		Road edge = (Road) r;

		if (source.equals(edge.destination) && destination.equals(edge.source))
			return true;
		else if (source.equals(edge.source) && destination.equals(edge.destination))
			return true;
		else
			return false;
	}

	/**
	 * @param town3
	 */
	public void setDestination(Town town3) {

	}

	/**
	 * @param string
	 */
	public void setName(String string) {

	}

	/**
	 * @param town3
	 */
	public void setSource(Town town3) {

	}

	/**
	 * @param i
	 */
	public void setWeight(int i) {

	}
}