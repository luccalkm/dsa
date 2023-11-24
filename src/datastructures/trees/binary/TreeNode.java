package datastructures.trees.binary;

public class TreeNode <T extends Comparable<T>>{
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode (T v) {
		this.val = v;
		left = null;
		right = null;
	}
}
