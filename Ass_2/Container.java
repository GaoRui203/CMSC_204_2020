import java.util.EmptyStackException;

/**
 * @author Gao Rui
 *
 */
public class Container implements ContainerInterface {

	private MyStack<DonationPackage> containerLine = new MyStack<DonationPackage>();

	/**
	 *
	 */
	public boolean loadContainer(DonationPackage dPackage) {

		if (containerLine.size() < 5) {
			containerLine.push(dPackage);

			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 */
	public DonationPackage removePackageFromContainer() throws EmptyStackException {
		if (ContainerEmpty() == false) {
			return (DonationPackage) containerLine.pop();
		} else {
			throw new EmptyStackException();
		}
	}

	/**
	 * @return
	 */
	public boolean ContainerEmpty() {
		if (containerLine.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 *
	 */
	public DonationPackage[] toArrayPackage() {

		DonationPackage[] v = new DonationPackage[containerLine.size()];
		for (int i = 0; i < containerLine.size(); i++) {
			v[i] = (DonationPackage) containerLine.data.get(i);
		}

		return v;

	}
}