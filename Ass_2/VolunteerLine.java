import java.util.NoSuchElementException;

/**
 * @author Gao Rui
 *
 */
public class VolunteerLine implements VolunteerLineInterface {

	private MyQueue<Volunteer> volunteerLine = new MyQueue<Volunteer>();

	/**
	 *
	 */
	public boolean addNewVolunteer(Volunteer v) {
		if (volunteerLine.size() < 5) {
			volunteerLine.enqueue(v);
			return true;
		} else {
			return false;

		}
	}

	/**
	 *
	 */
	public Volunteer volunteerTurn() throws NoSuchElementException {
		if (volunteerLineEmpty() == true) {
			throw new NoSuchElementException();
		} else {
			return volunteerLine.dequeue();
		}
	}

	/**
	 *
	 */
	public boolean volunteerLineEmpty() {
		if (volunteerLine.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 *
	 */
	public Volunteer[] toArrayVolunteer() {

		Volunteer[] v = new Volunteer[volunteerLine.size()];
		for (int i = 0; i < volunteerLine.size(); i++) {
			v[i] = (Volunteer) volunteerLine.data.get(i);
		}
		return v;
	}

	/**
	 * @param v
	 * @return
	 * @throws VolunteerException
	 */
	public boolean addNewVoluneer(Volunteer v) throws VolunteerException {

		return false;
	}
}
