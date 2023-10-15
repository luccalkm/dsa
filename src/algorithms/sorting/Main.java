package algorithms.sorting;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(); // não precisa indicar tamanho
		String[] array = new String[5]; // precisa indicar tamanho
		
		// ADICIONANDO ITENS NA LISTA
		list.add("Laura");    		// 1
		list.add("Lucca");			// 2
		list.add("Carlos");			// 3
		list.add("Cirurgião");		// 4
		list.add("Pocahontas");		// 5
		
		// ADICIONANDO ITENS NO ARRAY
		array[0] = "Laura";			// 1
		array[1] = "Lucca";			// 2
		array[2] = "Carlos";		// 3
		array[3] = "Cirurgião";		// 4
		array[4] = "Pocahontas";	// 5
		
		// PROBLEMA PARA ADICIONAR MAIS ITENS
		list.add("Férias"); 	// AQUI É TRANQUILO
		array[5] = "Férias";	// AQUI FUDEU MESMO
		
		System.out.println(list.toString()); // Imprimindo lista
		
		
		
	}

}
