import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Jogador extends Peca {

	/**
	 * Declaração do nome do jogador
	 */
	private String nome;

	/**
	 * Declarar vitória
	 */
	private int vitoria;

	/**
	 * 
	 */
	private int posicaoJogador = 0;

	/**
	 * Mão do jogador
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
	 * @return Recebe a mão atual do jogador
	 */
	public ArrayList<Carta> getMao() {
		return mao;
	}

	/**
	 * 
	 * @param Define a mão atual do jogador
	 */
	public void setMao(ArrayList<Carta> mao) {
		this.mao = mao;
	}

	/**
	 * 
	 * @param carta Carta
	 * @return Recebe uma carta da mão do jogador
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
	 * Define um valor para a vitória
	 * 
	 * @param vitoria Número de vitória(s)
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

	// Construtor - cópia
	/**
	 * Criar jogador Validação do nome
	 * 
	 * @param jogador Jogador
	 */
	public Jogador(Jogador jogador) {
		if (jogador.nome != "" || jogador.nome != null)
			this.nome = jogador.nome;
	}

	// Métodos Adicionais

	/**
	 * ToString do Jogador com as respetivas informações
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
