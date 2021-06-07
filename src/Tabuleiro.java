import java.util.ArrayList;

public class Tabuleiro {

	// Criação dos jogadores
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	private int posicaoJogador1 = 0;
	private int posicaoJogador2 = 0;

	/**
	 * Criação do tabuleiro
	 */
	private ArrayList<Casa> tabuleiro = new ArrayList<Casa>();

	// Construtor - default
	/**
	 * ??
	 */
	public Tabuleiro() {
	}

	// Construtor - com argumentos
	/**
	 * ??
	 * 
	 * @param jogadores Jogadores
	 */
	public Tabuleiro(ArrayList<Jogador> jogadores) {
		// Se o tabuleiro for null, então lança um erro.
		if (jogadores == null)
			new NullPointerException("Jogadores não são válidos");
		else
			this.jogadores = jogadores;
	}

	// Construtor - cópia
	/**
	 * ??
	 * 
	 * @param tabuleiro Tabuleiro
	 */
	public Tabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro.tabuleiro;
		this.jogadores = tabuleiro.jogadores;
	}

	// Acessores

	/**
	 * 
	 * @return Recebe os Jogadores
	 */
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	/*
	 * public ArrayList<Jogador> getJogador(int jogador) { return
	 * jogadores.indexOf(jogador); }
	 */

	/**
	 * 
	 * @return Recebe o tamanho do tabuleiro
	 */
	public int getTabuleiroSize() {
		return tabuleiro.size();

	}

	/**
	 * 
	 * @return Recebe a posição do jogador 1
	 */
	public int getPosicaoJogador1() {
		return posicaoJogador1;
	}

	/**
	 * 
	 * @return Recebe a posição do jogador 2
	 */
	public int getPosicaoJogador2() {
		return posicaoJogador2;
	}

	/**
	 * 
	 * @param posicaoJogador1 Define a posição do jogador 1
	 */
	public void setPosicaoJogador1(int posicaoJogador1) {
		this.posicaoJogador1 = posicaoJogador1;
	}

	/**
	 * 
	 * @param posicaoJogador2 Define a posição do jogador 2
	 */
	public void setPosicaoJogador2(int posicaoJogador2) {
		this.posicaoJogador2 = posicaoJogador2;
	}

	/**
	 * 
	 * @return Recebe o tabuleiro
	 */
	public ArrayList<Casa> getTabuleiro() {
		return tabuleiro;
	}

	// Comportamentos

	/**
	 * O jogador na casa 0 recebe uma carta O jogador na casa 1,4,6,9,11,14,16,19
	 * vai duelar O jogador na casa 3,8,13,18 vai receber uma surpresa
	 * 
	 * @param jogador1 posição do jogador 1
	 * @param jogador2 posição do jogador 2
	 */
//	Duelo duelo = new Duelo();
//	public void verificarCasa(int posicaoJogador) {
//		System.out.println("Verifica");
//
//		if (getPosicaoJogador1()== getPosicaoJogador2()) {
//			duelo.duelo(jogadores);
//		} else if (posicaoJogador == 3 |posicaoJogador == 8 | posicaoJogador == 13
//				| posicaoJogador == 18) {
//			// faz surpresa
//		} else if (posicaoJogador == 0) {
//			if(posicaoJogador == getPosicaoJogador1()) {
//				
//			}else if(posicaoJogador == getPosicaoJogador2()) {
//				// recebe carta
//			}
//		} else if (posicaoJogador == 1 | posicaoJogador == 4 | posicaoJogador == 6
//				| posicaoJogador == 9 | posicaoJogador == 11 | posicaoJogador == 14
//				| posicaoJogador == 16 | posicaoJogador == 19) {
//			System.out.println("Duelo");
//			duelo.duelo(jogadores);
//
//			// Como fazer?
//		}

	/**
	 * 
	 * @return Criar casas para o tabuleiro
	 */
	public static ArrayList<Casa> criarTabuleiro() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa(i));
		}

		return casas;
	}

	/**
	 * Clonar o tabuleiro
	 */
	public Tabuleiro clone() {
		return new Tabuleiro(this);
	}

}
