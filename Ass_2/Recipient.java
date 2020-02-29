
/**
 * @author Gao Rui
 *
 */
public class Recipient {
	private String recipient = "";

	/**
	 * @param r
	 */
	public Recipient(String r) {
		recipient = r;
	}

	/**
	 * @return
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param r
	 */
	public void setRecipient(String r) {
		recipient = r;
	}

	/**
	 *
	 */
	public String toString() {
		return " " + recipient;
	}
}