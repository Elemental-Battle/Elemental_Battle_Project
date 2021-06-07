import java.util.ArrayList;

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
	 * M�o do jogador
	 */
	private ArrayList<Carta> mao = new ArrayList<Carta>();

	// Acessores

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
	 * @return Recebe uma vitoria
	 */
	public int getVitoria() {
		return vitoria;
	}

	/**
	 * 
	 * @param Decide uma vitoria
	 */
	public void setVitoria(int vitoria) {
		this.vitoria = vitoria;
	}

	// Construtor - default
	/**
	 * 
	 * @param nome Nome do jogador
	 */
	public Jogador(String nome) {
		this.nome = nome;
	}

	// Construtor - com argumentos
	/**
	 * Criar jogador Validar nome e maoJogador
	 * 
	 * @param nome       Nome do jogador
	 * @param maoJogador Mao do jogador
	 */
	public Jogador(String nome, ArrayList<Carta> maoJogador) {
		if (nome != "" || nome != null)
			this.nome = nome;
		else if (maoJogador != null)
			mao = maoJogador;
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

	// Acessores
	/**
	 * 
	 * @return Recebe o Nome
	 */
	public String getNome() {
		return nome;
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
