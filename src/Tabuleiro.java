import java.util.ArrayList;

public class Tabuleiro {

	// Atributos

	// posição do jogador

	// Criação dos jogadores
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	private int posicaoJogador1 = 0;
	private int posicaoJogador2 = 0;

	// Criação do tabuleiro
	private ArrayList<Casa> tabuleiro = new ArrayList<Casa>();

	// Construtor - default
	public Tabuleiro() {

	}

	// Construtor - com argumentos
	public Tabuleiro(ArrayList<Casa> tabuleiro, ArrayList<Jogador> jogadores) {
		// Se o tabuleiro for null, então lança um erro.
		if (tabuleiro == null)
			new NullPointerException("O tabuleiro está inválido");
		// Se os jogadores for null, então lança um erro.
		else if (jogadores == null)
			new NullPointerException("Jogadores não são válidos");
		else
			this.jogadores = jogadores;
		this.tabuleiro = tabuleiro;
	}

	// Construtor - cópia
	public Tabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro.tabuleiro;
		this.jogadores = tabuleiro.jogadores;
	}
	// Acessores

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	/*public ArrayList<Jogador> getJogador(int jogador) {
		return jogadores.indexOf(jogador);
	}
*/
	// Get tamanho do tabuleiro
	public int getTabuleiroSize() {
		return tabuleiro.size();

	}

	// Get tabuleiro
	public ArrayList<Casa> getTabuleiro() {
		return tabuleiro;
	}

	// Comportamentos

	/**
	 * O jogador na casa 0 recebe uma carta 
	 * O jogador na casa 1,4,6,9,11,14,16,19 vai duelar 
	 * O jogador na casa 3,8,13,18 vai receber uma surpresa
	 * @param jogador1 posição do jogador 1
	 * @param jogador2 posição do jogador 2
	 */
	public void verificarCasa(Peca jogador1, Peca jogador2) {
		Duelo duelo = new Duelo();
		
		if (jogador1.getPosicao() == jogador2.getPosicao()) {
			// duelo
		} else if (jogador1.getPosicao() == 3 | jogador1.getPosicao() == 8 | jogador1.getPosicao() == 13
				| jogador1.getPosicao() == 18) {
			// faz surpresa
		} else if (jogador1.getPosicao() == 0) {
			// recebe carta
		} else if (jogador1.getPosicao() == 1 | jogador1.getPosicao() == 4 | jogador1.getPosicao() == 6
				| jogador1.getPosicao() == 9 | jogador1.getPosicao() == 11 | jogador1.getPosicao() == 14
				| jogador1.getPosicao() == 16 | jogador1.getPosicao() == 19) {
			// Duelo
			
			//Como fazer?
		}

	}

	public static ArrayList<Casa> criarTabuleiro() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa(i));
		}

		return casas;
	}

	// Métodos Adicionais

	// ToString do tabuleiro com as respetivas informações

	// Clonar o tabuleiro
	public Tabuleiro clone() {
		return new Tabuleiro(this);
	}

	// Permite saber se os tabuleiros são iguais
//	public boolean equals(Tabuleiro tabuleiro) {
//		if (tabuleiro == null)
//			return false;
//		else if (jogador1.equals(tabuleiro.getJogador1()) || jogador2.equals(tabuleiro.getJogador2()))
//			return true;
//		else if (tabuleiro.equals(tabuleiro.getCasas()))
//			return true;
//		else
//			return false;
//	}

}
