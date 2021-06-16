package Elemental_Battle;
import java.util.Random;

/**
 *  A classe Dado � onde � feito o lancamento de um dado de 1 a 6
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */


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
