package datastructures.arraylist;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		DynamicArray<Integer> list = new DynamicArray<>();
		Random r = new Random();
		
		for(int i = 0; i < 10; i++) {
			list.add(r.nextInt(0, 100));
		}
		
		System.out.println("Before: ");
		list.printList();
		System.out.println("\nAfter: ");
		list.sort();
		list.printList();
	}
}
