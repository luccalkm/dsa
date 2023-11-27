package connectionPool.Q1;

public class Main {

	public static void main(String[] args) {
		ListaDuplamenteCircular<String> dll = new ListaDuplamenteCircular<String>();
		
		dll.adicionar("Python");
		dll.adicionar("C#");
		dll.adicionar("Java");
		dll.adicionar("C++");
		dll.adicionar("Rust");
		dll.adicionar("Elixir");

		dll.print();
		
		dll.remover("Elixir");
		
		dll.print();
		
		for(int i = 0; i < 12; i++) {
			System.out.println(dll.obterElemento());
		}
		
	}
}
