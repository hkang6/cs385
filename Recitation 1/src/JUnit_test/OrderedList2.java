/*
 * Demonstrating a single linked-list implementation preserving the order of
 * its elements. The order is determined by the "compareTo()" method which
 * "E" implements.
 * 
 * @ author NeVErMiNd
 * 
 * @param E
 * 			the type of data this list holds. Must implement the Comparable interface.
 * */

public class OrderedList2<E extends Comparable<E>> {
	private Node<E> head;
	private int size;

	/*
	 * An "inner" class, Node
	 * 
	 * keyword "static" indicates that Node<E> class isn't going to refer to its
	 * outer class; anyway it cannot refer to anything outside of it since the
	 * only method(s) it has are constructors.
	 * 
	 * qualifier "private" is applied to data fields as well as the
	 * constructors.
	 * 
	 * A default constructor isn't defined because it is not needed.
	 */

	private static class Node<E> {
		// Data fields.
		private E data;
		private Node<E> next;

		/**
		 * Creates a new mode with a null next field.
		 * 
		 * @param dataItem
		 *            The data stored
		 */
		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}

		/**
		 * Creates a new node that references another node.
		 * 
		 * @param dataItem
		 *            The data stored
		 * @param nodeRef
		 *            The node referenced by new node
		 */
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

	/*
	 * Creates an empty list.
	 */
	// Constructor.
	public OrderedList2() {
		head = null;
		size = 0;
	}

	/**
	 * Returns the size of this list
	 * 
	 * @return the size of this list
	 */

	public int size() {
		return size;
	}

	/**
	 * Returns whether this list is empty.
	 * 
	 * @return true if this list is empty. Otherwise,
	 * @return false is returned.
	 */

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds the given element at the corresponding position in this list. This
	 * list must be ordered according to the compareTo method of E.
	 * 
	 * @param elem
	 *            the element to add to this list.
	 * @return true in any case to preserve compatibility with the List
	 *         interface.
	 */

	// IMPLEMENT IT.
	public boolean add(E elem) {
		if (elem == null){
			throw new IllegalArgumentException();
		}
		Node<E> newNode = new Node<E>(elem);
		Node<E> prev = null;
		Node<E> current = head;
		
		while (current != null){
			if (elem.compareTo(current.data) > 0) {
				prev = current;
				current = current.next;
			} else {
				break;
			}
		}
		if (prev == null){
			Node<E> oldHead = head;
			head = newNode;
		}else{
			prev.next = newNode;
			newNode.next = current;
		}
		size++;
		
		// you can check for a null possibility.

		/**
		 * If not, move ahead by creating a new node and calling out proper
		 * constructor
		 * 
		 * then you might want to intialize more objects like "prev" and
		 * "current"
		 */

		/**
		 * "while" you're sure, say about "current", that it's not null, then,
		 * use the compareTo() to compare current's data and do necessary
		 * updation depending upon the possible values (+, 0 or, -)
		 */

		/**
		 * You might have to insert before head or at some specific position,
		 * i.e. between, say, "prev" and "current".
		 * 
		 * So basically what should happen is if we assume there is a queue of
		 * students for some event's registration, namely, A-C-D-E-F-G-.... such
		 * that each letter denotes a student and once a student is done with
		 * their registration they're supposed to call another student, so if B
		 * cuts the line, A is going to call B instead of C.
		 * 
		 * Also, each student knows 2 things here: 1) who is ahead of them 2)
		 * who is behind them
		 * 
		 * So, if someone cuts in or leaves out, appropriate changes are to be
		 * made.
		 */

		/**
		 * once the process is done, since the length is increased by 1, we
		 * should remember to do any necessary change(s).
		 */
		return true;
	}

	/**
	 * Retrieves the element at the given index in this list.
	 * 
	 * @param index
	 *            the zeroÂ­based index of the element to retrieve.
	 * @return the element at the given index in this list.
	 */

	// IMPLEMENT IT.
	public E get(int index) {
		// you can do boundary verifications

		/**
		 * You can simply try to loop ahead until you reach the index of
		 * interest.
		 */

		/**
		 * finally, you might want to do a null assertion on the data. Make sure
		 * you take care of the return type.
		 */

		// Sample return: "return SomeNodeObject.data;"
	}

	// IMPLEMENTED FOR YOU.
	/**
	 * Returns the head of this list.
	 * 
	 * @return the head of this list.
	 */
	public E get() {
		return isEmpty() ? null : head.data;
	}

	/**
	 * Returns the tail of this list.
	 * 
	 * @return the tail of this list.
	 */
	// IMPLEMENTED FOR YOU.
	public E getLast() {
		return isEmpty() ? null : get(size - 1);
	}

	// public E remove(int index) {
	//
	// }
	//
	// public E remove() {
	//
	// }
	//
	// public E removeLast() {
	//
	// }
	//
	// public boolean remove(E elem) {
	//
	// }

	/**
	 * Returns a string representation of this list
	 * 
	 * @return this list represented as a string.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Node<E> current = head;
		while (current != null) {
			sb.append(current.data.toString());
			sb.append(" ");
			current = current.next;
		}
		// We access O(size) list elements.
		// Using get(i) for all i such that 0 <= i < size in a loop would
		// require accessing O(size^2) elements, since 1 + 2 + ... + size =
		// = size * (size + 1) / 2.
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Tests the functionality of this list by inserting at different positions
	 * and calling the different methods.
	 * 
	 * @param args
	 *            ignored.
	 */

	public static void main(String[] args) {
		OrderedList2<Integer> orderedList = new OrderedList2<Integer>();
		orderedList.add(3);
		orderedList.add(1);
		orderedList.add(2);
		orderedList.add(4);
		System.out.println("orderedList.toString() :: " + orderedList.toString());
		System.out.println("orderedList.get() :: " + orderedList.get());
		System.out.println("orderedList.getLast() :: " + orderedList.getLast());
		System.out.print("for loop - orderedList.get(i).toString() :: ");
		for (int i = 0; i < orderedList.size(); i++) {
			System.out.print(orderedList.get(i).toString());
		}
	}
}

/*
 * SAMPLE OUTPUT:
 * 
 * orderedList.toString() :: [ 1 2 3 4 ] orderedList.get() :: 1
 * orderedList.getLast() :: 4 for loop - orderedList.get(i).toString() :: 1234
 */