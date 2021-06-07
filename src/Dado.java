import java.util.Random;

public class Dado {

	// Atributos
	int numero;
	Random rand = new Random();

	// Construtor - default

	/**
	 * Criação do Dado
	 */
	public Dado() {
		super();

	}
	// Construtor - com argumentos

	// Construtor - cópia

	// Acessores

	/**
	 * 
	 * @return Recebe o número do dado
	 */
	public int getDado() {
		return numero;
	}

	// Comportamentos

	/**
	 * Lança o dado aleatóriamente e recebe o seu valor
	 * 
	 * @return Recebe o número do Dado
	 */
	public int lancarDado() {
		numero = rand.nextInt(6) + 1;

		return numero;
	}

}
