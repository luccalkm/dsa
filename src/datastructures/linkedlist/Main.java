package datastructures.linkedlist;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>(5);
		ll.printList();

		ll.append(new Node<>(6));
		
		ll.printList();
		
		ll.append(new Node<>(36));
		
		ll.printList();
	}

}
