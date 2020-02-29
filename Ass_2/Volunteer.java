
/**
 * @author Gao Rui
 *
 */
public class Volunteer {

	String volunteer = "";

	/**
	 * @param v
	 */
	public Volunteer(String v) {
		setVolunteer(v);
	}

	/**
	 * @return
	 */
	public String getVolunteer() {
		return volunteer;
	}

	/**
	 * @param v
	 */
	public void setVolunteer(String v) {
		volunteer = v;
	}

	/**
	 *
	 */
	public String toString() {
		return " " + volunteer;
	}
}