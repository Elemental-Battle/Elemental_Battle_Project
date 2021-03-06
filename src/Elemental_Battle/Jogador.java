package Elemental_Battle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * A classe Jogador ? o participante e o elemento que participa no jogo e
 * participa no tabuleiro atrav?s da posi??o da sua Peca e das cartas que lhe
 * s?o atribuidas.
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

public class Jogador extends Peca {

	// Atributos

	private String nome; // Nome do jogador
	private int vitoria; // vit?ria de um duelo
	private int posicaoJogador = 0; // posi??o da pe?a do jogador
	private ArrayList<Carta> mao = new ArrayList<Carta>(); // M?o do jogador

	// Acessores
	/**
	 * Devolve a posi??o do jogador.
	 * 
	 * @return posicaoJogador Posi??o do jogador.
	 */
	public int getPosicaoJogador() {
		return posicaoJogador;
	}

	/**
	 * Define a posi??o do jogador.
	 * 
	 * @param posicaoJogador Posi??o do jogador.
	 */
	public void setPosicaoJogador(int posicaoJogador) {
		this.posicaoJogador = posicaoJogador;
	}

	/**
	 * Devolve a m?o atual do jogador.
	 * 
	 * @return mao do jogador.
	 */
	public ArrayList<Carta> getMao() {
		return mao;
	}

	/**
	 * Define a m?o atual do jogador.
	 * 
	 * @param mao do jogador.
	 */
	public void setMao(ArrayList<Carta> mao) {
		this.mao = mao;
	}

	/**
	 * Devolve uma carta da m?o do jogador.
	 * 
	 * @param carta N?mero da carta para se ir buscar.
	 * @return A carta passada como par?metro.
	 */
	public Carta getCarta(int carta) {
		return mao.get(carta);
	}

	/**
	 * Devolve o n?mero de vit?rias que o jogador tem.
	 * 
	 * @return As vit?rias do jogador.
	 */
	public int getVitoria() {
		return vitoria;
	}

	/**
	 * Define o n?mero de vit?rias do jogador.
	 * 
	 * @param vitoria N?mero de vit?rias com que o jogador vai ficar.
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

	// Construtor - c?pia
	/**
	 * Criar jogador com valida??o no nome.
	 * 
	 * @param jogador Jogador.
	 */
	public Jogador(Jogador jogador) {
		// O jogador ? obrigado a escrever um nome
		if (jogador.nome != "" || jogador.nome != null)
			this.nome = jogador.nome;
	}

	// M?todos Adicionais

	@Override
	/**
	 * ToString do Jogador com as respetivas informa??es.
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
	 * Permite saber se os jogadores s?o iguais.
	 * 
	 * @param jogador Jogador que vai ser verificado.
	 * @return Recebe True ou False de acordo com resultado da valida??o.
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
