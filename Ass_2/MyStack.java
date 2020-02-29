import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gao Rui
 *
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T> {

	ArrayList<Object> data = new ArrayList<Object>();

	/**
	 *
	 */
	public boolean isEmpty() {
		if (data.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 */
	public boolean isFull() {
		if (data.size() == 5) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 */
	public T pop() {
		T element = (T) data.get(data.size() - 1);
		data.remove(element);
		return element;
	}

	/**
	 *
	 */
	public int size() {
		return data.size();
	}

	/**
	 *
	 */
	public boolean push(T e) {
		return data.add(e);
	}

	/**
	 *
	 */
	public T[] toArray() {

		T[] a = (T[]) data.toArray(new DonationManager[data.size()]);
		return a;
	}
}
