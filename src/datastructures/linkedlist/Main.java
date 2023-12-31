package datastructures.linkedlist;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>(5);
		ll.printList();

		ll.append(6);
		
		ll.printList();
		
		ll.prepend(36);
		
		ll.printList();

		ll.removeLast();
		
		ll.printList();
		
		ll.insertAt(55, 0);
		ll.insertAt(101, 3);
		
		ll.printList();
		
		ll.set(66, 2);
		
		ll.printList();
	}

}
