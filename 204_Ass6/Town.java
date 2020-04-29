import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Gao Rui
 *
 */
public class Town implements Comparable<Town> {

	private String townName;
	private String[] townsList;
	int townId;

	/**
	 * @param name
	 */
	public Town(String name) {
		townName = name;
	}

	/**
	 * @param templateTown
	 */
	public Town(Town templateTown) {
		townName = templateTown.getName();
	}

	/**
	 * @return
	 */
	public String getName() {
		return townName;
	}

	/**
	 *
	 */
	public String toString() {
		return townName;
	}

	/**
	 *
	 */
	public int hashCode() {
		return townName.hashCode();
	}

	/**
	 *
	 */
	public boolean equals(Object obj) { 
		Town town = (Town) obj;

		if (townName.equals(town.townName)) {

			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param m3
	 */
	public void setTownId(int m3) {
		townId = m3;
	}

	/**
	 * @return
	 */
	public int getTownId() {
		return townId;
	}

	/**
	 *
	 */
	@Override
	public int compareTo(Town town) throws ClassCastException {

		if (townName.equals(town.townName)) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * @param town2
	 */
	public void setLastTown(Town town2) {

	}

	/**
	 * @return
	 */
	public Object getLastTown() {
		return null;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {

	}
}