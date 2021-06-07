import java.util.Random;

public class Dado {

	// Atributos
	int numero;
	Random rand = new Random();

	// Construtor - default

	/**
	 * Cria��o do Dado
	 */
	public Dado() {
		super();

	}
	// Construtor - com argumentos

	// Construtor - c�pia

	// Acessores

	/**
	 * 
	 * @return Recebe o n�mero do dado
	 */
	public int getDado() {
		return numero;
	}

	// Comportamentos

	/**
	 * Lan�a o dado aleat�riamente e recebe o seu valor
	 * 
	 * @return Recebe o n�mero do Dado
	 */
	public int lancarDado() {
		numero = rand.nextInt(6) + 1;

		return numero;
	}

}
