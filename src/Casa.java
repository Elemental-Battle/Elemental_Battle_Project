import java.util.ArrayList;
import java.util.Iterator;

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
