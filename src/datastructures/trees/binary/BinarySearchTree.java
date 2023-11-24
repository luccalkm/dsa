package datastructures.trees.binary;

public class BinarySearchTree <T extends Comparable<T>> {
	public TreeNode<T> root;
	
	public BinarySearchTree (T val)  {
		TreeNode<T> node = new TreeNode<T>(val);
		root = node;
	}
	
	public BinarySearchTree () {
		root = null;
	}
	
	// CALL METHODS
	public TreeNode<T> insert(T val) {
		if(isEmpty()) root = new TreeNode<T>(val);
		return insert(root, val);
	}
	
	public boolean contains(T val) {
		return contains(root, val);
	}

	public TreeNode<T> delete(T val){
		return delete(root, val);
	}	
	
	// PRIVATE RECURSIVE LOGIC
	private boolean contains(TreeNode<T> node, T val) {
		if(node == null) return false;
		
		if(node.val == val) return true;
		
		if(val.compareTo(node.val) < 0) 
			return contains(node.left, val);
		else
			return contains(node.right, val);
	}
	
	private TreeNode<T> insert(TreeNode<T> temp, T val) {
		if(temp == null) return new TreeNode<T>(val);
		
		if(val.compareTo(temp.val) < 0)
			temp.left = insert(temp.left, val);
		
		else if(val.compareTo(temp.val) > 0)
			temp.right = insert(temp.right, val);
		
		return temp;
	}
	
    private TreeNode<T> delete(TreeNode<T> node, T val) {
        if (node == null) return node;
        
        // Valor a ser achado é menor que valor atual de nó
        if (val.compareTo(node.val) < 0) { 
        	node.left = delete(node.left, val);
        }
        // Valor a ser achado é menor que valor atual de nó
        else if (val.compareTo(node.val) > 0) {
        	node.right = delete(node.right, val);
        }
        // Valor encontrado
        else {
        	/*
        	 * Casos:
        	 * 1. Não tem filhos
        	 * 2. Tem filho na esquerda
        	 * 3. Tem filho na direita
        	 * 4. Tem dois filhos 
        	 */
        	if(node.left == null && node.right == null) 
        		return null;
        	else if (node.left == null)
        		return node.right;
        	else if (node.right == null)
        		return node.left;
        	else {
        		T subTreeMin = findMinValueInSubtree(node.right);
        		node.val = subTreeMin;
        		node.right = delete(node.right, subTreeMin);
        	}
        }
        return node;
    }

    // HELPERS
    private T findMinValueInSubtree(TreeNode<T> node) {
        T minValue = node.val;
        while (node.left != null) {
            minValue = node.left.val;
            node = node.left;
        }
        return minValue;
    }

	public boolean isEmpty() {
		return root == null;
	}
}
