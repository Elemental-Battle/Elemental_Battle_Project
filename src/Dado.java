import java.util.Random;

public class Dado {

	//Atributos
		int numero;
		Random rand = new Random();
	
	//Construtor - default
		
		public Dado() {
			super();
	
		}
	// Construtor - com argumentos

	// Construtor - cópia
	
	
	// Acessores
	
	
	// Comportamentos
		public int lancarDado() {
			numero = rand.nextInt(6) + 1;
			
			return numero;
		}
	
	
	// Métodos Adicionais
	
}
