import java.util.ArrayList;

public  abstract class  Casa {



/**
 * Construtor Default
 */
	public Casa() {
		
	}

	/**
	 * 
	 * 
	 * @param jogador Jogador
	 * @param baralho Baralho de cartas
	 * @param jogadores Jogadores
	 */
	public abstract void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores);
	
}
