package algorithms.sorting;

public class QuickSort <T extends Comparable<T>> {
	public void sort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public void quickSort(T[] arr, int low, int high) {
		if(low >= high) return;
		
		T pivot = arr[high];
		int left = low;
		int right = high;
		
		while(left < right) {
			
			while(arr[left].compareTo(pivot) <= 0 && left < right) {
				left++;
			}
			
			while(arr[right].compareTo(pivot) >= 0 && left < right) {
				right--;
			}
			
			swap(arr, left, right);
		}
		
		swap(arr, left, high);
		
		quickSort(arr, low, left - 1);
		quickSort(arr, right + 1, high);
	}
	
	public void swap(T[] arr, int index1, int index2) {
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
}
