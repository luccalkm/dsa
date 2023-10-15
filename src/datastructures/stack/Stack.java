package datastructures.stack;

public class Stack <T> {
	Node<T> top;
	int height;
	
	public Stack() {
		top = null;
		height = 0;
	}
	
	public Stack(Node<T> node) {
		this.top = node;
		height = 1;
	}
	
	public void push(T element) {
		Node<T> newNode = new Node<T>(element);
		if (height == 0) {
			top = newNode;
		}
		else {
			newNode.next = top;
			top = newNode;
		}
		height++;
	}
	
	public T pop() {
		Node<T> temp = top;
		
		top = top.next;
		temp.next = null;
		height--;
		
		return temp.element;
	}
	
	public T peek() {
		return top.element;
	}
	
	public boolean isEmpty() {
		return height == 0;
	}
	
	public int size() {
		return height;
	}

	public void print() {
		Node<T> temp = top;
		StringBuilder sb = new StringBuilder();
		sb.append("(top) [");
		for(int i = 0; i < height; i++) {
			sb.append(temp.element);
			sb.append(" -> ");
			temp = temp.next;
		}
		sb.append("null]");
		System.out.println(sb.toString());
	}
}
