package connectionPool.Q1;

public class ListaDuplamenteCircular<T extends Comparable<T>> {
	No<T> atual;
	No<T> anterior;
	No<T> primeiro;
	int numElementos;

	public ListaDuplamenteCircular() {
		primeiro = null;
		atual = null;
		anterior = null;
		numElementos = 0;
	}

	public ListaDuplamenteCircular(T v) {
		No<T> no = new No<T>(v);
		primeiro = no;
		atual = no;
		anterior = atual.anterior;
		numElementos = 1;
	}
	
	public T obterElemento() {
		if(vazio()) return null;
		
		anterior = atual;
		
		if(atual.proximo == null)
			atual = primeiro;
		else
			atual = atual.proximo;
		
		return anterior.val;
	}

	public void adicionar(T elemento) {
		No<T> novoNo = new No<T>(elemento);

		// Lista vazia será criada com um nó
		if (vazio()) {
			atual = novoNo;
			atual.anterior = null;
			primeiro = novoNo;
		} else {
			// Se tiver somente um nó, o nó adicionado será o primeiro
			if (numElementos == 1) {
				primeiro = novoNo;
			// Se tiverem 2 ou mais nós, iremos adicionar anterior ao atual
			} else {
				// Se o atual for o primeiro, o nó adicionado será o novo "primeiro"
				if (atual == primeiro) {
					primeiro = novoNo;
				}
				novoNo.anterior = anterior;
				anterior.proximo = novoNo;
			}
			atual.anterior = novoNo;
			novoNo.proximo = atual;
			anterior = novoNo;
		}

		numElementos++;
	}

	public boolean remover(T elemento) {
	    if (vazio()) {
	        // A lista está vazia, não há nada para remover
	    	System.out.println("A lista está vazia.");
	        return false;
	    }

	    No<T> x = primeiro;

	    do {
	        if (x.val.equals(elemento)) {
	            if (numElementos == 1) {
	                // Se há apenas um elemento na lista
	                primeiro = null;
	                atual = null;
	                anterior = null;
	            } else if (x == primeiro) {
	                // Se o elemento a ser removido é o primeiro
	                primeiro = x.proximo;
	            }

	            // Remove as associações em fila do nó "x"
	            if (x.proximo != null) {
	                x.proximo.anterior = x.anterior;
	            }
	            if (x.anterior != null) {
	                x.anterior.proximo = x.proximo;
	            }

	            numElementos--;
	            return true;
	        }
	        x = x.proximo;
	    } while (x != primeiro);

	    // O elemento não foi encontrado na lista
	    return false;
	}

	// helpers
	public boolean vazio() {
		return numElementos == 0;
	}

    public void print() {
        if (vazio()) {
            System.out.println("Lista vazia.");
            return;
        }

        No<T> noAtual = primeiro;
        
        while(noAtual != null) {
            System.out.print(noAtual.val + " <-> ");
            noAtual = noAtual.proximo;
        }
        System.out.println();
    }
}
