package datastructures.arraylist;

public class ArrayList <T> {
	private T[] array;
	private int elements;
	private final int INITIAL_SIZE = 5;
	private final int DEFAULT_INCREMENT = 10;
	
	public ArrayList() {
		elements = 0;
		array = (T[]) new Object[INITIAL_SIZE];
	}
	
	public void add(T value) {
		if(elements == array.length) {
			ensureCapacity(elements + 1);
		}
		this.array[elements] = value;
		elements++;
	}
	
	public void insertAt(T value, int index) {
		if(index < 0 || index > elements) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for " + elements + "." );
		}
		if(elements == array.length) ensureCapacity(elements + 1);
		
		for(int i = elements; i > index; i--) {
			this.array[i] = this.array[i-1];
		}
		this.array[index] = value;
		elements++;
	}
	/*
	 * HELPERS 
	 */
	private void ensureCapacity(int requiredCapacity) {
		int capacity = this.array.length;
		if(requiredCapacity > capacity) {
			int newLength = capacity + DEFAULT_INCREMENT;
			T[] newArray = (T[]) new Object[newLength];
			for(int i = 0; i < this.array.length; i++) {
				newArray[i] = this.array[i];
			}
			this.array = newArray;
		}
	}
	
	public void printList() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i = 0; i < elements; i++) {
			sb.append(this.array[i]);
			sb.append(',');
		}
	    if (elements > 0) {
	        sb.setLength(sb.length() - 1);
	    }
		sb.append(']');
		System.out.println(sb.toString());
	}
}
