import java.util.NoSuchElementException;

/**
 * @author Gao Rui
 *
 */
public class RecipientLine implements RecipientLineInterface {

	private MyQueue<Recipient> recipientLine = new MyQueue<Recipient>();

	/**
	 *
	 */
	public boolean addNewRecipient(Recipient rc) {
		if (recipientLine.size() < 5) {
			recipientLine.enqueue(rc);
			return true;

		} else {
			return false;

		}
	}

	/**
	 *
	 */
	public Recipient recipientTurn() throws NoSuchElementException {
		if (recipientLineEmpty() == true) {
			throw new NoSuchElementException();
		} else {
			return (Recipient) recipientLine.dequeue();
		}
	}

	/**
	 *
	 */
	public boolean recipientLineEmpty() {
		if (recipientLine.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 *
	 */
	public Recipient[] toArrayRecipient() {
		Recipient[] v = new Recipient[recipientLine.size()];
		for (int i = 0; i < recipientLine.size(); i++) {
			v[i] = (Recipient) recipientLine.data.get(i);
		}
		return v;
	}

	/**
	 * @param rc
	 * @return
	 * @throws RecipientException
	 */
	public boolean addNewRecepient(Recipient rc) throws RecipientException {
		return false;
	}

}
