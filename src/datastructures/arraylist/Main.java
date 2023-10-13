package datastructures.arraylist;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(54);
		list.add(54);
		list.add(54);
		list.add(54);
		list.add(54);
		list.printList();

		list.add(12);
		list.printList();

		list.insertAt(3, 3);
		list.printList();
	}
}
