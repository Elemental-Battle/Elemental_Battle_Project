package Elemental_Battle;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *  A classe Jogador é o participante e o elemento que participa no jogo e participa
 *  no tabuleiro através da posição da sua Peca e das cartas que lhe são atribuidas
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

public class Jogador extends Peca {

	// Atributos

	private String nome; // Nome do jogador
	private int vitoria; // vitória de um duelo
	private int posicaoJogador = 0; // posição da peça do jogador
	private ArrayList<Carta> mao = new ArrayList<Carta>(); // Mão do jogador

	// Acessores
	/**
	 * Recebe a posição do jogador
	 * 
	 * @return posicaoJogador Posição do jogador
	 */
	public int getPosicaoJogador() {
		return posicaoJogador;
	}

	/**
	 * Define a posição do jogador
	 * 
	 * @param posicaoJogador Posição do jogador
	 */
	public void setPosicaoJogador(int posicaoJogador) {
		this.posicaoJogador = posicaoJogador;
	}

	/**
	 * Recebe a mão atual do jogador
	 * 
	 * @return mao do jogador
	 */
	public ArrayList<Carta> getMao() {
		return mao;
	}

	/**
	 * Define a mão atual do jogador
	 * 
	 * @param mao do jogador
	 */
	public void setMao(ArrayList<Carta> mao) {
		this.mao = mao;
	}

	/**
	 * Recebe uma carta da mão do jogador
	 * 
	 * @param carta Carta
	 * @return mao Uma carta
	 */
	public Carta getCarta(int carta) {
		return mao.get(carta);
	}

	/**
	 * Recebe uma vitoria
	 * 
	 * @return vitoria
	 */
	public int getVitoria() {
		return vitoria;
	}

	/**
	 * Define o número de vitórias de um jogador
	 * 
	 * @param vitoria Vitória do duelo
	 */
	public void setVitoria(int vitoria) {
		this.vitoria = vitoria;
	}

	/**
	 * Recebe o nome do jogador
	 * 
	 * @return Nome do Jogador
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Construtor por defeito
	 * 
	 */
	public Jogador() {
		String nome = "";
		// Inserir o nome do jogador,
		do {
			nome = (String) JOptionPane.showInputDialog(null, "Nome do jogador", "Jogador", JOptionPane.PLAIN_MESSAGE, null, null, "jogador");

		} while (nome.length() < 1);
		this.nome = nome;
	}

	// Construtor - cópia
	/**
	 * Criar jogador com validação no nome
	 * 
	 * @param jogador Jogador
	 */
	public Jogador(Jogador jogador) {
		// O jogador é obrigado a escrever um nome
		if (jogador.nome != "" || jogador.nome != null)
			this.nome = jogador.nome;
	}

	// Métodos Adicionais

	@Override
	/**
	 * ToString do Jogador com as respetivas informações
	 */
	public String toString() {
		return "Jogador " + getNome();
	}

	/**
	 * Clonar o Jogador
	 */
	public Jogador clone() {
		return new Jogador(this);
	}

	/**
	 * Permite saber se os jogadores são iguais
	 * 
	 * @param jogador Jogador
	 * @return Recebe True ou False de acordo com resultado da validação
	 */
	public boolean equals(Jogador jogador) {
		if (jogador == null)
			return false;
		else if (nome.equals(jogador.getNome()))
			return true;
		else
			return false;
	}
}
