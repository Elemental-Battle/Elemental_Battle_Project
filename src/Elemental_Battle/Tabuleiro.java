package Elemental_Battle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * A classe tabuleiro tem o respetivo tabuleiro com casas neutras, duelo e
 * surpresa, tamb�m tem os jogadores.
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 */

public class Tabuleiro {

	// Atributos

	public ArrayList<Jogador> jogadores = new ArrayList<Jogador>(); // cria��o dos jogadores
	private ArrayList<Casa> tabuleiro; // cria��o do tabuleiro
	Casa casaBonus = new Surpresa(); // cria��o da casa bonus
	Casa casaDuelo = new Duelo(); // cria��o da casa duelo

	/**
	 * Construtor Default, escolher a quantidade de jogadores que v�o participar no jogo, havendo
	 * restri��o, minimo 2 jogadores e um m�ximo de 6 jogadores.
	 */
	// Construtor Default
	public Tabuleiro() {
		int numeroJogadores;
		// Inserir a quantidade de jogadores que v�o participar, de 2 a 6 jogadores
		// inclusive
		do {
			numeroJogadores = Integer.parseInt((String) JOptionPane.showInputDialog(null, "N�mero de jogadores",
					"Jogadores", JOptionPane.PLAIN_MESSAGE, null, null, "2"));
		} while (numeroJogadores < 2 || numeroJogadores > 6);

		// Adicionar jogadores ao jogo de acordo com a quantidade de participantes
		for (int i = 0; i < numeroJogadores; i++) {
			Jogador jogador = new Jogador();
			jogadores.add(jogador);
		}

		// Inserir as casas ao tabuleiro
		this.tabuleiro = new ArrayList<Casa>(criarTabuleiro());
	}

	// Construtor - c�pia
	/**
	 * C�pia do tabuleiro.
	 * 
	 * @param tabuleiro Tabuleiro para o qual se quer copiar o existente.
	 */
	public Tabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro.tabuleiro;
		this.jogadores = tabuleiro.jogadores;
	}

	// Acessores

	/**
	 * Recebe a quantidade de jogadores.
	 * 
	 * @return Jogadores.
	 */
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	/**
	 * Define os jogadores que v�o jogar.
	 * 
	 * @param jogadores Arraylist de jogadores da classe Jogador.
	 */
	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	/**
	 * Devolve o tamanho do tabuleiro (n�mero de casas).
	 *
	 * @return O tamanho do tabuleiro.
	 */
	public int getTabuleiroSize() {
		return tabuleiro.size();

	}

	/**
	 * Devolve o tabuleiro.
	 * 
	 * @return tabuleiro
	 */
	public ArrayList<Casa> getTabuleiro() {
		return tabuleiro;
	}

	// Comportamentos

	/**
	 * Cria 25 casas do tabuleiro.
	 * 
	 * @return casas criadas.
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
	 * Clona o tabuleiro.
	 */
	public Tabuleiro clone() {
		return new Tabuleiro(this);
	}

}
