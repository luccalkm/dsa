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
	
	public void insertAt(int index, T value) {
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
	
	public T get(int index) {
		if(!isWithinRange(index)) return null;
		return this.array[index];
	}
	
	public void set(int index, T value) {
		if(!isWithinRange(index)) return;
		this.array[index] = value;
	}
	
	public void remove(int index) {
		if(!isWithinRange(index)) return;
		
		for(int i = index; i < this.array.length - 1; i++) {
			this.array[i] = this.array[i + 1];
		}
		elements--;
	}
	
	public int size() {
		return elements;
	}
	
	public boolean isEmpty() {
		return elements == 0;
	}
	
	public boolean contains(T value) {
		return false;
	}
	
	public void clear() {
		this.array = (T[]) new Object[INITIAL_SIZE];
		this.elements = 0;
	}
	
	private boolean isWithinRange(int index) {
		return (index >= 0 && index < this.array.length);
	}
	
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
			if(this.array[i] != null) {
				sb.append(this.array[i]);
				sb.append(',');
			}
		}
	    if (elements > 0) {
	        sb.setLength(sb.length() - 1);
	    }
		sb.append(']');
		System.out.println(sb.toString());
	}
}
