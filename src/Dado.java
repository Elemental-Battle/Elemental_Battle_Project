import java.util.Random;


public class Dado {

	// Atributos
	int numero;
	Random rand = new Random();



	/**
	 * Cria��o do Dado
	 */
	// Construtor - default
	public Dado() {
		super();

	}

	// Acessores

	/**
	 * Recebe o n�mero do dado
	 * @return numero
	 */
	public int getDado() {
		return numero;
	}

	// Comportamentos

	/**
	 * Recebe o n�mero do dado lan�ado
	 * 
	 * @return numero
	 */
	public int lancarDado() {
		numero = rand.nextInt(5) + 1;

		return numero;
	}

}
