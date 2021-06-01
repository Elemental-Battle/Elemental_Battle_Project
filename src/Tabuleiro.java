import java.util.ArrayList;

public class Tabuleiro {

	// Atributos

	// posi��o do jogador

	// Cria��o dos jogadores
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	private int posicaoJogador1 = 0;
	private int posicaoJogador2 = 0;

	// Cria��o do tabuleiro
	private ArrayList<Casa> tabuleiro = new ArrayList<Casa>();

	// Construtor - default
	public Tabuleiro() {

	}

	// Construtor - com argumentos
	public Tabuleiro(ArrayList<Casa> tabuleiro, ArrayList<Jogador> jogadores) {
		// Se o tabuleiro for null, ent�o lan�a um erro.
		if (tabuleiro == null)
			new NullPointerException("O tabuleiro est� inv�lido");
		// Se os jogadores for null, ent�o lan�a um erro.
		else if (jogadores == null)
			new NullPointerException("Jogadores n�o s�o v�lidos");
		else
			this.jogadores = jogadores;
		this.tabuleiro = tabuleiro;
	}

	// Construtor - c�pia
	public Tabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro.tabuleiro;
		this.jogadores = tabuleiro.jogadores;
	}
	// Acessores

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	/*
	 * public ArrayList<Jogador> getJogador(int jogador) { return
	 * jogadores.indexOf(jogador); }
	 */
	// Get tamanho do tabuleiro
	public int getTabuleiroSize() {
		return tabuleiro.size();

	}

	//Get posi��o do jogador 1
	public int getPosicaoJogador1() {
		return posicaoJogador1;
	}

	//Get posi��o do jogador 2
	public int getPosicaoJogador2() {
		return posicaoJogador2;
	}

	//Set posi��o do jogador 1
	public void setPosicaoJogador1(int posicaoJogador1) {
		this.posicaoJogador1 = posicaoJogador1;
	}
	//Set posi��o do jogador 2
	public void setPosicaoJogador2(int posicaoJogador2) {
		this.posicaoJogador2 = posicaoJogador2;
	}
	
	// Get tabuleiro
	public ArrayList<Casa> getTabuleiro() {
		return tabuleiro;
	}

	// Comportamentos

	/**
	 * O jogador na casa 0 recebe uma carta O jogador na casa 1,4,6,9,11,14,16,19
	 * vai duelar O jogador na casa 3,8,13,18 vai receber uma surpresa
	 * 
	 * @param jogador1 posi��o do jogador 1
	 * @param jogador2 posi��o do jogador 2
	 */
	public void verificarCasa(int posicaoJogador) {
		Duelo duelo = new Duelo();

		if (getPosicaoJogador1()== getPosicaoJogador2()) {
			// duelo
		} else if (posicaoJogador == 3 |posicaoJogador == 8 | posicaoJogador == 13
				| posicaoJogador == 18) {
			// faz surpresa
		} else if (posicaoJogador == 0) {
			// recebe carta
		} else if (posicaoJogador == 1 | posicaoJogador == 4 | posicaoJogador == 6
				| posicaoJogador == 9 | posicaoJogador == 11 | posicaoJogador == 14
				| posicaoJogador == 16 | posicaoJogador == 19) {
			// Duelo

			// Como fazer?
		}

	}

	

	public static ArrayList<Casa> criarTabuleiro() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa(i));
		}

		return casas;
	}

	// M�todos Adicionais

	// ToString do tabuleiro com as respetivas informa��es

	// Clonar o tabuleiro
	public Tabuleiro clone() {
		return new Tabuleiro(this);
	}

	// Permite saber se os tabuleiros s�o iguais
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
