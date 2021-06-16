package Elemental_Battle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * A classe Jogador é o participante e o elemento que participa no jogo e
 * participa no tabuleiro através da posição da sua Peca e das cartas que lhe
 * são atribuidas.
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
	 * Devolve a posição do jogador.
	 * 
	 * @return posicaoJogador Posição do jogador.
	 */
	public int getPosicaoJogador() {
		return posicaoJogador;
	}

	/**
	 * Define a posição do jogador.
	 * 
	 * @param posicaoJogador Posição do jogador.
	 */
	public void setPosicaoJogador(int posicaoJogador) {
		this.posicaoJogador = posicaoJogador;
	}

	/**
	 * Devolve a mão atual do jogador.
	 * 
	 * @return mao do jogador.
	 */
	public ArrayList<Carta> getMao() {
		return mao;
	}

	/**
	 * Define a mão atual do jogador.
	 * 
	 * @param mao do jogador.
	 */
	public void setMao(ArrayList<Carta> mao) {
		this.mao = mao;
	}

	/**
	 * Devolve uma carta da mão do jogador.
	 * 
	 * @param carta Número da carta para se ir buscar.
	 * @return A carta passada como parâmetro.
	 */
	public Carta getCarta(int carta) {
		return mao.get(carta);
	}

	/**
	 * Devolve o número de vitórias que o jogador tem.
	 * 
	 * @return As vitórias do jogador.
	 */
	public int getVitoria() {
		return vitoria;
	}

	/**
	 * Define o número de vitórias do jogador.
	 * 
	 * @param vitoria Número de vitórias com que o jogador vai ficar.
	 */
	public void setVitoria(int vitoria) {
		this.vitoria = vitoria;
	}

	/**
	 * Devolve o nome do jogador.
	 * 
	 * @return Nome do Jogador.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Construtor por defeito.
	 * 
	 */
	public Jogador() {
		String nome = "";
		// Inserir o nome do jogador,
		do {
			nome = (String) JOptionPane.showInputDialog(null, "Nome do jogador", "Jogador", JOptionPane.PLAIN_MESSAGE,
					null, null, "jogador");

		} while (nome.length() < 1);
		this.nome = nome;
	}

	// Construtor - cópia
	/**
	 * Criar jogador com validação no nome.
	 * 
	 * @param jogador Jogador.
	 */
	public Jogador(Jogador jogador) {
		// O jogador é obrigado a escrever um nome
		if (jogador.nome != "" || jogador.nome != null)
			this.nome = jogador.nome;
	}

	// Métodos Adicionais

	@Override
	/**
	 * ToString do Jogador com as respetivas informações.
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
	 * Permite saber se os jogadores são iguais.
	 * 
	 * @param jogador Jogador que vai ser verificado.
	 * @return Recebe True ou False de acordo com resultado da validação.
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
