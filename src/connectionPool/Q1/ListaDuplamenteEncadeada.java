package connectionPool.Q1;

public class ListaDuplamenteEncadeada <T extends Comparable<T>> {
	No<T> atual;
	No<T> anterior;
	int numElements;
	
	public ListaDuplamenteEncadeada(T v) {
		No<T> no = new No<T>(v);
		atual = no;
		anterior = atual.anterior;
		numElements = 1;
	}
	
	public void adicionar(T v) {
		No<T> novoNo = new No<T>(v);
		
		if(vazio()) {
			atual = novoNo;
		} 
		else if (numElements == 1){
			novoNo.posterior = atual;
			atual.anterior = novoNo;
		}
		else {
			
		}
		
		anterior = atual.anterior;
		numElements++;
	}
	
	// helpers
	public boolean vazio() {
		return numElements == 0;
	}
}
