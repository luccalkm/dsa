package datastructures.linkedlist;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int elements;

	public LinkedList() {
		head = null;
		tail = null;
		elements = 0;
	}

	private void isFirstElement(Node<T> firstNode) {
		if (elements == 0) {
			head = firstNode;
			tail = firstNode; 
		}
	}

	public LinkedList(T value) {
		Node<T> newNode = new Node<T>(value);
		head = newNode;
		tail = newNode;
		elements = 1;
	}

	public Node<T> indexOf(Node<T> node) {
		if (elements == 0)
			return null;

		Node<T> currentNode = head;
		while (currentNode != null) {
			if (currentNode.equals(node)) {
				return currentNode;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	public void set(T value, int index) {
		if (index < 0 || index >= elements)
			return;

		Node<T> temp = this.get(index);
		temp.value = value;
	}

	public Node<T> get(int index) {
		if (index < 0 || index >= elements)
			return null;

		Node<T> currentNode = head;
		int currentIndex = 0;
		while (currentIndex < index) {
			currentNode = currentNode.next;
			currentIndex++;
		}

		return currentNode;
	}

	public void append(T element) {
		Node<T> newNode = new Node<T>(element);
		this.isFirstElement(newNode);

		tail.next = newNode;
		tail = newNode;
		elements++;
	}

	public void prepend(T element) {
		Node<T> newNode = new Node<>(element);
		this.isFirstElement(newNode);

		newNode.next = head;
		head = newNode;
		elements++;
	}

	public void insertAt(T element, int index) {
		if (index < 0 || index > elements) {
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}

		if (index == 0) {
			this.prepend(element);
			return;
		}

		if (index == elements) {
			this.append(element);
			return;
		}

		Node<T> newNode = new Node<>(element);
		Node<T> currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}

		newNode.next = currentNode.next;
		currentNode.next = newNode;
		elements++;
	}

	public void removeAt(int index) {
		if (index < 0 || index > elements) {
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		
		if (index == 0) {

			head = head.next;
		} else {
			Node<T> currentNode = head;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
		elements--;
	}

	public void removeLast() {
		Node<T> currentNode = head;
		while (!currentNode.next.equals(tail)) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
		tail = currentNode;
		elements--;
	}

	public void removeFirst() {
		if (elements == 0)
			return;

		head = head.next;
		elements--;
	}

	public void printList() {
		Node<T> currentNode = head;
		StringBuilder sb = new StringBuilder();
		while (currentNode != null) {
			sb.append(currentNode.value);
			sb.append(" -> ");
			currentNode = currentNode.next;
		}
		sb.append("null");
		String str = sb.toString();
		System.out.println(str);
	}

}
