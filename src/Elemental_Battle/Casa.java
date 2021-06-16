package Elemental_Battle;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *  A classe Casa tem o objetivo de ser uma classe padrão e abstrata do tabuleiro, servindo
 *  como base para subclasses
 *  
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */


public abstract class Casa {

	/**
	 * Construtor Default
	 */
	public Casa() {

	}

	protected void recebeCarta(Jogador jogador, ArrayList<Carta> baralho, int quantidade) {

		for (int j = 0; j < quantidade; j++) {

			jogador.getMao().add(baralho.get(j));
		}

	}

	/**
	 * 
	 * 
	 * @param jogador   Jogador
	 * @param baralho   Baralho de cartas
	 * @param jogadores Jogadores
	 */
	public abstract void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores);

}
