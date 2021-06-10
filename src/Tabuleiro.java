import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tabuleiro {

	// Atributos

	ArrayList<Jogador> jogadores = new ArrayList<Jogador>(); // criação dos jogadores
	private ArrayList<Casa> tabuleiro; // criação do tabuleiro
	Casa casaBonus = new Bonus(); // criação da casa bonus
	Casa casaDuelo = new Duelo(); // criação da casa duelo

	/**
	 * Escolher a quantidade de jogadores que vão participar no jogo, havendo
	 * restrição, minimo 2 jogadores e um máximo de 6 jogadores
	 */
	// Construtor Default
	public Tabuleiro() {
		int numeroJogadores;
		// Inserir a quantidade de jogadores que vão participar, de 2 a 6 jogadores
		// inclusive
		do {
			numeroJogadores = Integer
					.parseInt(JOptionPane.showInputDialog("Insira a quantidade de jogadores que vão participar "));
		} while (numeroJogadores < 2 || numeroJogadores > 6);

		// Adicionar jogadores ao jogo de acordo com a quantidade de participantes
		for (int i = 0; i < numeroJogadores; i++) {
			Jogador jogador = new Jogador();
			jogadores.add(jogador);
		}

		// Inserir as casas ao tabuleiro
		this.tabuleiro = new ArrayList<Casa>(criarTabuleiro());
	}

	// Construtor - cópia
	/**
	 * Cópia do tabuleiro
	 * 
	 * @param tabuleiro Tabuleiro
	 */
	public Tabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro.tabuleiro;
		this.jogadores = tabuleiro.jogadores;
	}

	// Acessores

	/**
	 * Recebe a quantidade de jogadores
	 * 
	 * @return Jogadores
	 */
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	/**
	 * Recebe o tamanho do tabuleiro (número de casas)
	 *
	 * @return tabuleiro
	 */
	public int getTabuleiroSize() {
		return tabuleiro.size();

	}

	/**
	 * Recebe o tabuleiro
	 * 
	 * @return tabuleiro
	 */
	public ArrayList<Casa> getTabuleiro() {
		return tabuleiro;
	}

	// Comportamentos

	/**
	 * Cria 25 casas para o tabuleiro
	 * 
	 * @return casas do tabuleiro
	 */
	public static ArrayList<Casa> criarTabuleiro() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 24; i++) {
			casas.add(new Casa() {

				@Override
				public void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores) {
					// TODO Auto-generated method stub

				}
			});
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
