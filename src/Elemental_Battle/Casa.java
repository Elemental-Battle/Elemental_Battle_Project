package Elemental_Battle;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A classe Casa tem o objetivo de ser uma classe padrão e abstrata do
 * tabuleiro, servindo como base para subclasses
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

	/**
	 * Dá cartas ao jogador.
	 * 
	 * @param jogador    Jogador que vai receber a carta.
	 * @param baralho    Baralho de cartas da partida.
	 * @param quantidade Quantidade de cartas que vão ser recebidas
	 */
	protected void recebeCarta(Jogador jogador, ArrayList<Carta> baralho, int quantidade) {

		for (int j = 0; j < quantidade; j++) {

			jogador.getMao().add(baralho.get(j));
		}

	}

	/**
	 * Desafio abstrato para as classes Bonus e Duelo poderem implementar o seu
	 * respetivo desafio.
	 * 
	 * @param jogador   Jogador que iniciou o desafio.
	 * @param baralho   Baralho de cartas da partida.
	 * @param jogadores Todos os jogadores que participam na partida.
	 */
	public abstract void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores);

}
