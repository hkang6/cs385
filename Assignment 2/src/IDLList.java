//Harkirat Kang
//I pledge my honor that I have abided by the Stevens honor system



import java.util.ArrayList;

public class IDLList<E>{	
	public class Node<E>{
		
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		private Node (E elem){
			data = elem;
		}
		
		private Node (E elem, Node<E> prev, Node<E> next){
			data = elem;
			this.prev = prev;
			this.next = next;
		}	
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices; 
	
	//creates an empty double linked list
	public IDLList (){
		head = null;
		tail = null;
		size = 0;
		indices = null;

	}
	
	//adds elem at position index. Uses index for fast access
	public boolean add (int index, E elem){
		Node newNode = new Node<E>(elem);
		if (index > size-1){
			return false;
		}
		if (index < 0){
			return false;
		}
		if (size < 0){
			return false;
			
		}
		if (size == 0){
			tail = newNode;
			head = newNode;
			indices.add(0, newNode);
			size++;
		}
		if (index == 0){
			return add( elem);
			
		}
		if (index == size-1){
			return append(elem);
		}
		
			Node tempA = indices.get(index);
			Node tempB = indices.get(index-1);
			
			tempA.prev = newNode;
			tempB.next = newNode;
			indices.add(index, newNode);
			newNode.prev = tempA;
			newNode.next = tempB;
			size++;
			return true;
			

		
	}
	
	//adds elem at the head
	public boolean add (E elem){
		Node newNode = new Node<E>(elem);
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		indices.add(0, newNode);
		size++;
		return true;
		
	}
	//adds elem as the new last element of the list
	public boolean append (E elem){
		Node newNode = new Node<E>(elem);
		newNode.prev = tail;
		tail.next = newNode;
		tail = newNode;
		indices.add(size-1, newNode);
		size++;
		return false;
		
	}
	//returns the object at position index from the head. Uses index. 
	public E get (int index){
		return indices.get(index).data;
		
	}
	//returns the object at the head
	public E getHead (){
		return head.data;
		
		
	}
	//returns the object at the tail
	public E getLast (){
		return tail.data;
		
	}
	//return the list size
	public int size(){
		return size;
		
	}
	//removes and returns the element at the head
	public E remove (){
		E temp = head.data;
		head = head.next;
		if (head != null){
			head.prev = null;
			size--;
			indices.remove(0);
			return temp;
		}
		if( size == 1){
			tail = null;
		}
		return null;
	
	}
	//removes and returns the element at the tail
	public E removeLast (){
		E temp = tail.data;
		tail = tail.prev;
		if (tail != null){
			tail.next = null;
			size--;
			indices.remove(0);
			return temp;
		}
		if (size == 1){
			head = null;
		}
		return null;
	}
	//removes and returns the element at the index index
	public E remove (int index){
		E temp = indices.get(index).data;
		
		if (size == 0 ){
			return null;
		}
		if (index < 0){
			return null;
		}
		if (index >size){
			return null;
		}
		if (index == 0){
			return remove();
		}
		if (index == size -1){
			return removeLast();
		}
		indices.get(index).prev.next = indices.get(index).next;
		indices.get(index).next.prev = indices.get(index).prev;
		size--;
		indices.remove(index);
		return temp;
		
		
	}
	//removes the first occurrence of elem in the list and returns true. False if not found in list
	public boolean remove (E elem){
		for (int i = 0; i < size; i++){
			if (elem == indices.get(i).data){
				remove(i); 
				return true;
			}
			
		}
		return false;
	}
	//presents a string representation of the list
	public String toString(){
		return null;
		
	}
		
	}


