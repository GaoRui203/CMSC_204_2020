
/**
 * @author Gao Rui
 *
 */
public class DonationPackage {
	private String description = " ";
	private double weight = 0;

	/**
	 * @param d
	 * @param w
	 */
	public DonationPackage(String d, double w) {
		description = d;
		weight = w;
	}

	/**
	 * @param d
	 */
	public void setDescription(String d) {
		this.description = d;
	}

	/**
	 * @param w
	 */
	public void setWeight(double w) {
		this.weight = w;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 *
	 */
	public String toString() {
		String name = description;
		return name;
	}

	/**
	 * @return
	 */
	public boolean isHeavy() {

		return false;
	}
}
