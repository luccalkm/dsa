package datastructures.arraylist;

import algorithms.sorting.QuickSort;

public class DynamicArray <T extends Comparable<T>> {
	private T[] array;
	private int countElements;
	private final int INITIAL_SIZE = 5;
	private final int DEFAULT_INCREMENT = 10;
	
	public DynamicArray() {
		this.countElements = 0;
		this.array = (T[]) new Comparable[INITIAL_SIZE];
	}

	public DynamicArray<T> subList(int start) {
		if(!isWithinRange(start)) {
			throw new IndexOutOfBoundsException("Can't return sublist from invalid index.");
		}
		
		DynamicArray<T> newList = new DynamicArray<>();
		
		for(int i = start; i < countElements; i++) {
			newList.add(this.array[i]);
		}
		
		return newList;
	}
	
	public DynamicArray<T> subList(int start, int end) {
		if(!isWithinRange(start) || !isWithinRange(end)) {
			throw new IndexOutOfBoundsException("Can't return sublist from invalid index.");
		}
		
		DynamicArray<T> newList = new DynamicArray<>();
		
		for(int i = start; i < end; i++) {
			newList.add(this.array[i]);
		}
		
		return newList;
	}
	
	public int lastIndexOf(T element) {
		for(int i = countElements; i >= 0; i++) {
			if(this.array[i].equals(element)) return i;
		}
		return -1;
	}
	
	public int indexOf(T element) {
		for(int i = 0; i < countElements; i++) {
			if(this.array[i].equals(element)) return i;
		}
		return -1;
	}
	
	public void add(T element) {
		if(countElements == array.length) {
			ensureCapacity(countElements + 1);
		}
		this.array[countElements] = element;
		countElements++;
	}
	
	public void insertAt(int index, T element) {
		if(index < 0 || index > countElements) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for " + countElements + "." );
		}
		if(countElements == array.length) ensureCapacity(countElements + 1);
		
		for(int i = countElements; i > index; i--) {
			this.array[i] = this.array[i-1];
		}
		this.array[index] = element;
		countElements++;
	}
	
	public T get(int index) {
		if(!isWithinRange(index)) return null;
		return this.array[index];
	}
	
	public void set(int index, T element) {
		if(!isWithinRange(index)) return;
		this.array[index] = element;
	}
	
	public void removeLast() {
		int lastIndex = countElements - 1;
		if(!isWithinRange(lastIndex)) {
			throw new IndexOutOfBoundsException("Can't remove from an empty list.");
		}
		
		this.array[countElements - 1] = null;
		countElements--;
	}
	
	public void remove(int index) {
		if(!isWithinRange(index)) return;
		
		for(int i = index; i < this.array.length - 1; i++) {
			this.array[i] = this.array[i + 1];
		}
		countElements--;
	}
	
	public int size() {
		return countElements;
	}
	
	public boolean isEmpty() {
		return countElements == 0;
	}
	
	public boolean contains(T element) {
		int found = indexOf(element);
		return found != -1;
	}
	
	public void clear() {
		this.array = (T[]) new Object[INITIAL_SIZE];
		this.countElements = 0;
	}
	
	private boolean isWithinRange(int index) {
		return (index >= 0 && index < this.array.length);
	}
	
	private void ensureCapacity(int requiredCapacity) {
		int capacity = this.array.length;
		if(requiredCapacity > capacity) {
			int newLength = capacity + DEFAULT_INCREMENT;
			T[] newArray = (T[]) new Comparable[newLength];
			for(int i = 0; i < countElements; i++) {
				newArray[i] = this.array[i];
			}
			this.array = newArray;
		}
	}
	
	public void sort() {
		QuickSort<T> qs = new QuickSort<T>();
		qs.quickSort(array, 0, countElements - 1);
	}
	
	public void printList() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i = 0; i < countElements; i++) {
			if(this.array[i] != null) {
				sb.append(this.array[i]);
				sb.append(',');
			}
		}
	    if (countElements > 0) {
	        sb.setLength(sb.length() - 1);
	    }
		sb.append(']');
		System.out.println(sb.toString());
	}

	public void teest() {
		System.out.println("Length: " + this.array.length);
		System.out.println("countElements: " + this.countElements);
	}
}
