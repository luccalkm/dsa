package datastructures.trees.avl;


public class Node <T> {

    public T val;
    int height;
    public Node<T> left;
	public Node<T> right;

    public Node(T v) {
        val = v;
        height = 1;
    }
    
    public int getHeight() {
    	return height;
    }
}
