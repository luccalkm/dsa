package datastructures.linkedlist;

public class LinkedList <T> {
	private Node<T> head;
	private Node<T> tail;
	private int elements;
	
	public LinkedList(T value) {
		Node<T> newNode = new Node<T>(value);
		head = newNode;
		tail = newNode;
		elements = 1;
	}
	
	public void removeLast() {
		Node<T> currentNode = head;
		while(!currentNode.next.equals(tail)) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
		tail = currentNode;
		
	}
	
	public void append(Node<T> newNode) {
		tail.next = newNode;
		tail = newNode;
		elements++;
	}
	
	public void printList() {
		Node<T> currentNode = head;
		StringBuilder sb = new StringBuilder();
		while(currentNode != null) {
			sb.append(currentNode.value);
			sb.append(" -> ");
			currentNode = currentNode.next;
		}
		sb.append("null");
		String str = sb.toString();
		System.out.println(str);
	}
	
}
