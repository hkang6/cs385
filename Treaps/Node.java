package Treaps;

public class Node<E> {

		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;

		public Node(E data, int priority) {
			this.data = data;
			this.priority = priority;
			left = null;
			right = null;
		}

		public Node<E> rotateRight() {
			if (this.left == null)
				return this;
			Node<E> leftNode = this.left;
			this.left = leftNode.right;
			leftNode.right = this;
			return leftNode;
		}

		public Node<E> rotateLeft() {
			if (this.right == null)
				return this;
			Node<E> rightNode = this.right;
			this.right = rightNode.left;
			rightNode.left = this;
			return rightNode;
		}

		public String toString() {
			return "(key=" + data + ", priority=" + priority + ")";
		}
	}