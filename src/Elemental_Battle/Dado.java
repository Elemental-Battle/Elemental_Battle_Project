package Elemental_Battle;
import java.util.Random;

/**
 *  A classe Dado é onde é feito o lancamento de um dado de 1 a 6
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
	 * Criação do Dado
	 */
	// Construtor - default
	public Dado() {
		super();

	}

	// Acessores

	/**
	 * Recebe o número do dado
	 * @return numero
	 */
	public int getDado() {
		return numero;
	}

	// Comportamentos

	/**
	 * Recebe o número do dado lançado
	 * 
	 * @return numero
	 */
	public int lancarDado() {
		numero = rand.nextInt(5) + 1;

		return numero;
	}

}
