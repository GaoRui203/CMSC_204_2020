import java.util.ListIterator;

//It extends BasicDoubleLinkedList class.
/**
 * @author Gao Rui
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	java.util.Comparator<T> comp = null;

	/** Creates an empty list that is associated with the specified comparator.
	 * 
	 * @param comparator2 - Comparator to compare data elements
	 */ 
	public SortedDoubleLinkedList(java.util.Comparator<T> comparator2) {
		// Initialize comparator
		comp = comparator2;
	}

	/** Inserts the specified element at the correct position in the sorted list.
	 * 
	 * @param data - the data to be added to the list
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		if (data == null) {
			return this;
		}
		Node newnode = new Node(data, null, null);
		if (header == null) {
			header = tail = new Node(data, null, null);
		} else {
			if (comp.compare(data, header.item) <= 0) {
				newnode.next = header;
				header = newnode;
			} else if (comp.compare(data, tail.item) >= 0) {
				tail.next = newnode;
				tail = newnode;
			} else {
				Node next = header.next;
				Node prev = header;
				while (comp.compare(data, next.item) > 0) {
					prev = next;
					next = next.next;
				}
				prev.next = newnode;
				newnode.next = next;
			}
		}
		// Increment list size
		size++;
		// Return current node list
		return this;
	}
	

	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		// Throw exception
        throw new UnsupportedOperationException("addToEnd() is unsupported for a sorted list");
	}

	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) {
		// Throw exception
        throw new UnsupportedOperationException("addToFront() is unsupported for a sorted list");
	}

	/**
	 * @param data       - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return data element or null
	 */
// Implements the remove operation by calling the super class remove method.
	public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator) {
		Node next = header;
		Node prev = null;
		while (next != null) {
			if (comparator.compare(next.item, data) == 0) {
				size--;
				if (prev != null) {
					prev.next = next.next;
				} else {
					header = next.next;
				}
				if (next == tail) {
					tail = prev;
				}
			}
			prev = next;
			next = next.next;
		}
		return this;
	}
	
/**
 * @return an iterator positioned at the head of the list
 */
//Implements the iterator by calling the super class iterator method.
	public ListIterator<T> iterator() {
		// Call parent method
        return super.iterator();
	}
}
