import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Jogador extends Peca {

	/**
	 * Declara��o do nome do jogador
	 */
	private String nome;

	/**
	 * Declarar vit�ria
	 */
	private int vitoria;

	/**
	 * 
	 */
	private int posicaoJogador = 0;

	/**
	 * M�o do jogador
	 */
	private ArrayList<Carta> mao = new ArrayList<Carta>();

	// Acessores
	/**
	 * 
	 * @return
	 */
	public int getPosicaoJogador() {
		return posicaoJogador;
	}

	/**
	 * 
	 * @param posicaoJogador
	 */
	public void setPosicaoJogador(int posicaoJogador) {
		this.posicaoJogador = posicaoJogador;
	}

	/**
	 * 
	 * @return Recebe a m�o atual do jogador
	 */
	public ArrayList<Carta> getMao() {
		return mao;
	}

	/**
	 * 
	 * @param Define a m�o atual do jogador
	 */
	public void setMao(ArrayList<Carta> mao) {
		this.mao = mao;
	}

	/**
	 * 
	 * @param carta Carta
	 * @return Recebe uma carta da m�o do jogador
	 */
	public Carta getCarta(int carta) {
		return mao.get(carta);
	}

	/**
	 * 
	 * @return Valor da vitoria
	 */
	public int getVitoria() {
		return vitoria;
	}

	/**
	 * Define um valor para a vit�ria
	 * 
	 * @param vitoria N�mero de vit�ria(s)
	 */
	public void setVitoria(int vitoria) {
		this.vitoria = vitoria;
	}

	/**
	 * 
	 * @return Nome do Jogador
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Construtor por defeito
	 * 
	 * @param nome Nome do jogador
	 */
	public Jogador() {
		String nome = "";
		do {
			nome = JOptionPane.showInputDialog("Insira o nome do jogador");

		} while (nome.length() < 1);
		this.nome = nome;
	}

	// Construtor - c�pia
	/**
	 * Criar jogador Valida��o do nome
	 * 
	 * @param jogador Jogador
	 */
	public Jogador(Jogador jogador) {
		if (jogador.nome != "" || jogador.nome != null)
			this.nome = jogador.nome;
	}

	// M�todos Adicionais

	/**
	 * ToString do Jogador com as respetivas informa��es
	 */
	@Override
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
	 * Permite saber se os jogadores s�o iguais
	 * 
	 * @param jogador Jogador
	 * @return Recebe True ou False de acordo com resultado da valida��o
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
