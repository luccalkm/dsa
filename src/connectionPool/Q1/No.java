package connectionPool.Q1;

public class No <T> {
	No<T> posterior;
	No<T> anterior;
	T val;
	
	public No(T v) {
		val = v;
	}
	
	public T getValue() {
		return val;
	}
}
