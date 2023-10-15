package datastructures.queue;

public class Queue <T> {
	private Node<T> first;
	private Node<T> last;
	private int length;
	
	public Queue() {
		this.first = null;
		this.last = null;
		this.length = 0;
	}
	
	public Queue(T element) {
		Node<T> newNode = new Node<>(element);
		this.first = newNode;
		this.last = newNode;
		this.length = 1;
	}
	
	public void enqueue(T element) {
		Node<T> newNode = new Node<>(element);
		if(length == 0) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		length++;
	}
	
	public Node<T> dequeue() {
		if(length == 0) return null;
		Node<T> node = first;
		if(length == 1) {
			first = null;
			last = null;
		}
	}
}
