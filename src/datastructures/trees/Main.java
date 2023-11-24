package datastructures.trees;

import datastructures.trees.avl.AVLTree;

public class Main {

	public static void main(String[] args) {
		AVLTree<Integer> bst = new AVLTree<Integer>();
		
		bst.insert(12);
		bst.insert(40);
		bst.insert(88);
		bst.insert(3);
		bst.insert(77);
		bst.insert(55);
		bst.insert(2);
		bst.insert(1);
		bst.insert(66);
		
		System.out.println(bst.contains(77));
		
		System.out.println(bst.root.val);
		
		bst.print();
		
	}

}
