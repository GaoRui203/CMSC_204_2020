import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Gao Rui
 *
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T> {

	LinkedList<Object> data = new LinkedList<Object>();

	/**
	 *
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/**
	 *
	 */
	public T dequeue() {
		T t = null;
		if (data.isEmpty() == false) {
			t = (T) data.removeFirst();
		}
		return t;
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
	public boolean enqueue(T e) {
		if (data.size() <= 5) {
			data.addLast(e);
			return true;
		} else {
			return false;
		}

	}

	/**
	 *
	 */
	public T[] toArray() {

		T[] a = (T[]) data.toArray(new Object[data.size()]);

		return a;
	}

	/**
	 *
	 */
	public boolean isFull() {

		return false;
	}
}
