package datastructures.trees.avl;

import java.util.ArrayList;

public class AVLTree<T extends Comparable<T>> {
	
    public Node<T> root;

    private int height(Node<T> node) {
        if (node == null) return 0;
        return node.height;
    }

    private Node<T> rightRotate(Node<T> node) {
        Node<T> leftNode = node.left;
        Node<T> tempRightSon = leftNode.right;

        // Rotação
        leftNode.right = node;
        node.left = tempRightSon;

        // Atualiza alturas
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        leftNode.height = Math.max(height(leftNode.left), height(leftNode.right)) + 1;

        // Retorna a nova raiz
        return leftNode;
    }

    private Node<T> leftRotate(Node<T> node) {
        Node<T> rightNode = node.right;
        Node<T> tempLeftSon = rightNode.left;

        // Rotação
        rightNode.left = node;
        node.right = tempLeftSon;

        // Atualiza alturas
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rightNode.height = Math.max(height(rightNode.left), height(rightNode.right)) + 1;

        // Retorna a nova raiz
        return rightNode;
    }

    private int getBalance(Node<T> node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private Node<T> balanceNode(Node<T> node) {
        // Atualiza a altura do nó atual
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Verifica se este nó se tornou desbalanceado
        int balance = getBalance(node);

        // Caso esquerda-esquerda
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // Caso esquerda-direita
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Caso direita-direita
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // Caso direita-esquerda
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void insert(T val) {
        root = insert(root, val);
    }

    private Node<T> insert(Node<T> node, T val) {
        if (node == null) return (new Node<T>(val));

        if (val.compareTo(node.val) < 0)
            node.left = insert(node.left, val);
        else if (val.compareTo(node.val) > 0)
            node.right = insert(node.right, val);
        else return node;

        return balanceNode(node);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T val) {
        return contains(root, val);
    }

    private boolean contains(Node<T> node, T val) {
        if (node == null) {
            return false;
        }
        if (val.compareTo(node.val) < 0) {
            return contains(node.left, val);
        } else if (val.compareTo(node.val) > 0) {
            return contains(node.right, val);
        } else {
            return true;
        }
    }

    public void delete(T val) {
        root = delete(root, val);
    }

    private Node<T> delete(Node<T> node, T val) {
        if (node == null) return node;

        if (val.compareTo(node.val) < 0)
        	node.left = delete(node.left, val);

        else if (val.compareTo(node.val) > 0)
        	node.right = delete(node.right, val);

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

        return balanceNode(node);
    }

    private T findMinValueInSubtree(Node<T> node) {
        Node<T> current = node;
        while (current.left != null)
           current = current.left;

        return current.val;
    }
    
    public void print() {
        if (root == null) {
            System.out.println("Árvore está vazia.");
            return;
        }
        
        ArrayList<Node<T>> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            ArrayList<Node<T>> nextLevel = new ArrayList<>();
            for (Node<T> currentNode : currentLevel) {
                System.out.print(currentNode.val + " ");
                if (currentNode.left != null) nextLevel.add(currentNode.left);
                if (currentNode.right != null) nextLevel.add(currentNode.right);
            }
            System.out.println();
            currentLevel = nextLevel;
        }
    }
}
