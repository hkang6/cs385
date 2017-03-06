package Treaps;
import java.util.Random;

public class Treap<E extends Comparable<E>> {

	private Random priorityGenerator;
	private Node<E> root;

	public Treap() {
		priorityGenerator = new Random();
		root = null;
	}

	public Treap(long seed) {
		priorityGenerator = new Random(seed);
		root = null;
	}

	public boolean add(E key) {
		boolean ret;
		if(!find(key))
			ret = true;
		else
			ret = false;
		
		root = add(key, root, priorityGenerator.nextInt());
		return ret;
	}

	public boolean add(E key, int p) {
		boolean ret;
		if(!find(key))
			ret = true;
		else
			ret = false;
		root = add(key, root, p);
		return ret;
	}

	private Node<E> add(E x, Node<E> t, int p) {
		if (t == null)
			return new Node<E>(x, p);

		if (x.compareTo(t.data) == 0)
			return t;

		if (x.compareTo(t.data) < 0) {
			t.left = add(x, t.left, p);
			if (t.left.priority < t.priority)
				t = t.rotateRight();
		} else {
			t.right = add(x, t.right, p);
			if (t.right.priority < t.priority)
				t = t.rotateLeft();
		}
		return t;
	}

	public boolean delete(E key) {
		boolean ret;
		if(find(key))
			ret = true;
		else
			ret = false;
		root = delete(key, root);
		return ret;
			
	}

	private Node<E> delete(E x, Node<E> t) {
		if (t != null) {

			if (x.compareTo(t.data) < 0) {
				t.left = delete(x, t.left);
			}

			else if (x.compareTo(t.data) > 0) {
				t.right = delete(x, t.right);
			}

			else {
				if (t.left == null) {
					return t.right;
				} else if (t.right == null) {
					return t.left;
				} else {
					t.data = leftMost(t.right);
					t.right = delete(t.data, t.right);
				}
			}
		}
		return t;
	}

	private E leftMost(Node<E> p) {
		while (p.left != null)
			p = p.left;

		return p.data;
	}

	public boolean find(E key) {
		Node<E> current = root;

		while (current != null) {
			if (key.compareTo(current.data) < 0)
				current = current.left;
			else if (key.compareTo(current.data) > 0)
				current = current.right;
			else
				return true;
		}
		return false;
	}

	private E find(Node<E> root, E key) {
		Node<E> current = root;

		if (current == null)
			return null;
		else if (key.compareTo(current.data) == 0)
			return current.data;
		else if (key.compareTo(current.data) < 0)
			return find(current.right, key);
		else
			return find(current.left, key);
	}

	public String toString() {
		
		if(root == null)
			return "Empty Treap";
		StringBuilder sb = new StringBuilder();
		print(root, 1, sb);
		return sb.toString();
	}

	private void print(Node<E> n, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append("   ");
		}
		if (n == null) {
			sb.append("null\n");
		} else if (n != null) {

			sb.append(n.toString());
			sb.append("\n");
			print(n.left, depth + 1, sb);
			print(n.right, depth + 1, sb);

		}

	}

	// Test program
	public static void main(String[] args) {
		Treap<Integer> t = new Treap<Integer>(1000);
		
		System.out.println(t.add(1));
		System.out.println(t.add(4));
		System.out.println(t.add(2));
		System.out.println(t.add(6));
		System.out.println(t.add(3));
		System.out.println(t.add(5));
		System.out.println(t.add(7));

		System.out.println(t);
		
		System.out.println(t.delete(1));
		System.out.println(t.delete(4));
		System.out.println(t.delete(2));
		System.out.println(t.delete(6));
		System.out.println(t.delete(3));
		System.out.println(t.delete(5));
		System.out.println(t.delete(7));
	
		System.out.println(t);
	}
}

