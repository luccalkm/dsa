package datastructures.arraylist;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(54);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(3);
		list.printList();

		list.add(12);
		list.printList();

		list.insertAt(3, 3);
		list.printList();

		list.remove(0);
		list.printList();
		list.add(7);
		list.clear();

		list.add(7);
		list.printList();
	}
}
