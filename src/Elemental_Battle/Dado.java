package Elemental_Battle;

import java.util.Random;

/**
 * A classe Dado é onde é feito o lancamento de um dado de 1 a 6.
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
	 * Construtor default do Dado.
	 */
	// Construtor - default
	public Dado() {
		super();

	}

	// Acessores

	/**
	 * Devolve o número do dado.
	 * 
	 * @return numero do dado.
	 */
	public int getDado() {
		return numero;
	}

	// Comportamentos

	/**
	 * Efetua o lançamento de um dado de 1-6.
	 * 
	 * @return numero do dado.
	 */
	public int lancarDado() {
		numero = rand.nextInt(5) + 1;

		return numero;
	}

}
