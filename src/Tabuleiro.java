import java.util.ArrayList;

public class Tabuleiro {

	// Atributos

	// posi��o do jogador
	int posicao;

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
	public Tabuleiro(ArrayList<Casa> casas, ArrayList<Jogador> jogadores) {
		// Se as casas n�o forem nulas, ent�o o array casas � igual ao passado por
		// par�metro
		if (casas != null)
			this.tabuleiro = casas;
		// Verificar se o jogador 1 � v�lido
//		else if (jogador1.getNome() != "" && jogador1.getNome() != null)
//			this.jogador1 = jogador1;
//		// Verificar se o jogador 2 � v�lido
//		else if (jogador2.getNome() == "" || jogador1.getNome() == null)
//			System.out.println("Nome inv�lido");
//		// Verificar se o jogador 2 tem o nome diferente do jogador 1
//		else if (jogador2.getNome() == jogador1.getNome())
//			System.out.println("Nome em uso, por favor escolha outro");
//		else
//			this.jogador2 = jogador2;
		this.jogadores = jogadores;
	}

	// Construtor - c�pia
	public Tabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro.tabuleiro;
		this.jogadores = tabuleiro.jogadores;
	}
	// Acessores

	// Get casas do tabuleiro
	public ArrayList<Casa> getCasas() {
		return tabuleiro;
	}

	// Comportamentos
	public void andarJogador(Dado dado, int posicaoJogador) {

		int lancarDado = dado.lancarDado();

		System.out.println("Valor do dado: " + lancarDado);

//		// Declarar o n�mero de casas que o jogador vai andar com base na posi��o atual
//		// + o valor do dado lan�ado
//		int andarCasas = posicaoJogador.getPosicao() + lancarDado;
//
//		// Se o n�mero de casas a andar for maior que o n�mero do tabuleiro
//		if (andarCasas > tabuleiro.size()) {
//
//			// Subtrai ao n� de casas a andar o tamanho do tabuleiro + 1.
//			// Ex: andarCasas = 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) =
//			// posicao 2
//			posicaoJogador.setPosicao(andarCasas - (tabuleiro.size() + 1));
//		} else
//			// Caso contr�rio, anda o n� de casas
//			posicaoJogador.setPosicao(andarCasas);

	}

	public static ArrayList<Casa> criarCasas() {
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
