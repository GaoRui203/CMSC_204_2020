import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * @author Gao Rui
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements java.lang.Iterable<T> {
	protected class Node {
		protected T item;
		protected Node next, previous;

		protected Node(T item, Node next, Node previous) {
			this.item = item;
			this.next = next;
			this.previous = previous;
		}
	}

	protected int size;
	protected Node header, tail;

	/**
	 * 
	 */
	public BasicDoubleLinkedList() {
		// Initialize node size
		size = 0;
		header = tail = null;
	}

	/**
	 * Adds an element to the end of the list
	 * 
	 * @param elem - the elem for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T elem) {
		// Create new node
		Node tmp = new Node(elem, null, tail);
		if (tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if (header == null) {
			header = tmp;
		}
		size++;
		return this;
	}

	/**
	 * Adds an element to the front of the list
	 * 
	 * @param elem- the elem for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T elem) {
		// Create new node
		Node tmp = new Node(elem, header, null);
		if (header != null) {
			header.previous = tmp;
		}
		header = tmp;
		if (tail == null) {
			tail = tmp;
		}
		size++;
		return this;
	}

	/**
	 * This method just returns the value of the instance variable you use to keep
	 * track of size
	 * 
	 * @return the size of the linked list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns but does not remove the last element from the list.
	 * 
	 * @return the data element or null
	 */
	public T getLast() {
		return tail.item;
	}

	/**
	 * Returns but does not remove the first element from the list.
	 * 
	 * @return the data element or null
	 */
	public T getFirst() {
		return header.item;
	}

	/**
	 * Removes the first instance of the targetData from the list.
	 * 
	 * @param elem       - the element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T elem, java.util.Comparator<T> comparator) {
		Node prev = null, curr = header;
		while (curr != null) {
			if (comparator.compare(curr.item, elem) == 0) {
				if (curr == header) {
					header = header.next;
					curr = header;
				} else if (curr == tail) {
					curr = null;
					tail = prev;
					prev.next = null;
				} else {
					prev.next = curr.next;
					curr = curr.next;
				}
				size--;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return this;
	}

	/**
	 * Removes and returns the first element from the list. If there are no elements
	 * the method returns null.
	 * 
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		// Check if node list is not empty
		if (size == 0) {
			throw new NoSuchElementException("Linked list is empty");
		}
		Node tmp = header;
//Update new header node
		header = header.next;
		header.previous = null;
//Decrement size variable
		size--;
//Return node data
		return tmp.item;
	}

	/**
	 * Removes and returns the last element from the list. If there are no elements
	 * the method returns null.
	 * 
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		if (header == null) {
			throw new NoSuchElementException("Linked list is empty");
		}
		Node currentNode = header;
		Node previousNode = null;
		while (currentNode != null) {
			if (currentNode.equals(tail)) {
				tail = previousNode;
				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		size--;
		return currentNode.item;
	}

	/**
	 * Returns an arraylist of the items in the list from head of list to tail of
	 * list
	 * 
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList() {
		// Initialize array list
		ArrayList<T> tmp = new ArrayList<T>();
//Iterate through node list
		ListIterator<T> iterator1 = new iter();
		while (iterator1.hasNext()) {
			// Add node to array list
			tmp.add(iterator1.next());
		}
// Return array list
		return tmp;
	}


	public class iter implements ListIterator<T> {
		private Node current;
		private Node last;

		public iter() {
			current = header;
			last = null;
		}

		/**
		 *
		 */
		public T next() {
			if (current != null) {
				T returnData = current.item;
				last = current;
				current = current.next;
				if (current != null) {
					current.previous = last;
				}
				return returnData;
			} else
				throw new NoSuchElementException();
		}

		/**
		 *
		 */
		public boolean hasNext() {
			return current != null;
		}

		/**
		 *
		 */
		public T previous() {
			if (last != null) {
				current = last;
				last = current.previous;
				T returnData = current.item;
				return returnData;
			} else
				throw new NoSuchElementException();
		}

		/**
		 *
		 */
		public boolean hasPrevious() {
			return last != null;
		}

		/**
		 *
		 */
		public void set(T data) throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			current.item = data;
		}

		/**
		 *
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			// return 0;
			throw new UnsupportedOperationException();
		}

		/**
		 *
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			// return 0;
			throw new UnsupportedOperationException();
		}

		/**
		 *
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		/**
		 *
		 */
		@Override
		public void add(T e) throws UnsupportedOperationException {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}

	/**
	 *
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
// Return new list iterator
		return new iter();
	}
}
