import java.util.ArrayList;
import java.util.Collections;

public class Jogo {
	// Atributos
	// Gerar o tabuleiro
	Tabuleiro tabuleiro = new Tabuleiro();
	// Gerar um dado
	Dado dado = new Dado();
	// Gerar um baralho
	Baralho baralho = new Baralho();
	// Gerar Pe�a
	// Peca peca = new Peca();
	ArrayList<Peca> pecas = new ArrayList<Peca>();

	// Construtor - com argumentos

	public Jogo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	// Construtor - c�pia

	// Acessores

	// Comportamentos

	public static ArrayList<Casa> tabuleiro6x6() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa(i));
		}

		return casas;
	}

	public void mostrarCartas(ArrayList<Carta> cartas) {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println("Carta " + (1 + i) + ": " + cartas.get(i));
		}

	}

	public void receberCarta(Jogador jogador) {

		Collections.shuffle(baralho.getElementals());
		jogador.getMao().add(baralho.getElementals().get(1));
	}

	public static void distribuirBaralho(ArrayList<Carta> baralho, ArrayList<Carta> primeiraMao,
			ArrayList<Carta> segundaMao) {

		Collections.shuffle(baralho);

		for (int i = 0; i < 7; i++) {
			Collections.shuffle(baralho);
			primeiraMao.add(baralho.get(i));
		}

		for (int i = 0; i < 7; i++) {
			Collections.shuffle(baralho);
			segundaMao.add(baralho.get(i));
		}

	}

	// Turno ( while, for dentro, vai trocando de jogadores, dando lhes a ordem de
	// andar, dentro da ordem andar, verficar se calhou numa casa especial e faz a
	// respetiva
	// a��o, caso contrario, passa de turno.
	/**
	 * � o cora��o do jogo, divide o baralho, d� as cartas a cada jogador. Nos
	 * turnos pares o jogador 2 v� as cartas que tem em sua posse, e depois chama o
	 * comportamento andarJogador. Caso seja turno impar, � o jogador 1 a jogar.
	 * 
	 * Quando o primeiro jogador chegar �s 5 vit�rias, o jogo acaba.
	 */

	public void turno() {
		int turno = 1;
		// Baralha e distribui o baralho
		distribuirBaralho(baralho.getElementals(), tabuleiro.jogadores.get(0).getMao(),
				tabuleiro.jogadores.get(1).getMao());
		System.out.println("O baralho foi distribuido");

		// Conta os turnos,
		do {
			System.out.println("Cora��o do turno");

			/*
			 * Para o Jogador 1, Mostra as cartas que tem no seu baralho, move a pe�a dele
			 * no tabuleiro, e, se calhar numa casa duelo, surpresa faz o respetivo desafio,
			 * caso contr�rio, passa o turno
			 */
			System.out.println("Turno " + turno);
			if (turno % 2 == 0) {

				System.out.println("");
				System.out.println("Turno do Jogador 2");
				// Mostra as cartas que tem no seu baralho
				mostrarCartas(tabuleiro.jogadores.get(1).getMao());
				// Move a pe�a do jogador
				andarJogador(dado, tabuleiro.getPosicaoJogador2());
				System.out.println(tabuleiro.getPosicaoJogador2());
				// Avan�a o turno
				turno++;
			} else {
				System.out.println("");
				System.out.println("Turno do Jogador 1");
				// Mostra as cartas que tem no seu baralho
				mostrarCartas(tabuleiro.jogadores.get(0).getMao());
				// Move a pe�a do jogador
				andarJogador(dado, tabuleiro.getPosicaoJogador1());
				System.out.println(tabuleiro.getPosicaoJogador1());
				// Avan�a o turno
				turno++;
			}

			System.out.println("Jogador 1 Vit�rias: " + tabuleiro.getJogadores().get(0).getVitoria());
			System.out.println("Jogador 2 Vit�rias: " + tabuleiro.getJogadores().get(1).getVitoria());

		} while (tabuleiro.getJogadores().get(0).getVitoria() < 5 && tabuleiro.getJogadores().get(1).getVitoria() < 5);

		System.out.println("Fim dos turnos");
		System.out.println("O jogo durou " + turno + " turnos");
		if (tabuleiro.getJogadores().get(0).getVitoria() == 5) {
			System.out.println("Ganhou o Jogador 1");
		} else
			System.out.println("Ganhou o Jogador 2");
	}

	/**
	 * Lan�a um dado, utiliza a posi��o atual do jogador, e depois anda o valor do
	 * dado no tabuleiro.
	 * 
	 * O dado n�o pode ser nulo e a posi��o do jogador n�o pode ser inferior a 0 nem
	 * superior a 20
	 * 
	 * @param dado
	 * @param posicaoJogador
	 * 
	 * @throws IllegalArgumentException se a posi��o do jogador for inferior a 0 ou
	 *                                  superior a 20
	 * @throws NullPointerException     se o dado for nulo
	 */
	public void andarJogador(Dado dado, int posicaoJogador) {

		/*
		 * if (dado == null) { throw new NullPointerException("O dado inserido � nulo");
		 * } else if (posicaoJogador < 0 || posicaoJogador > 20) { throw new
		 * IllegalArgumentException("A posi��o do jogador � superior a 20 ou inferior a 0"
		 * ); } else {
		 */

		int lancarDado = dado.lancarDado();

		System.out.println("Valor do dado: " + lancarDado);

//		 Declarar o n�mero de casas que o jogador vai andar com base na posi��o atual + o valor do dado lan�ado
		int andarCasas = posicaoJogador + lancarDado;
		System.out.println("Andar para a casa: " + andarCasas);
		// Se o n�mero de casas a andar for maior que o n�mero do tabuleiro
		if (posicaoJogador == tabuleiro.getPosicaoJogador2()) {
			if (andarCasas > tabuleiro.getTabuleiroSize()) {

				/*
				 * Subtrai ao n� de casas a andar o tamanho do tabuleiro + 1. Ex: andarCasas =
				 * 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) = posicao 2
				 */
				tabuleiro.setPosicaoJogador2(andarCasas - (tabuleiro.getTabuleiroSize() + 1));
				receberCarta(tabuleiro.getJogadores().get(1));
			} else
				// Caso contr�rio, anda o n� de casas
				tabuleiro.setPosicaoJogador2(andarCasas);
		} else if (posicaoJogador == tabuleiro.getPosicaoJogador1()) {
			if (andarCasas > tabuleiro.getTabuleiroSize()) {

				/*
				 * Subtrai ao n� de casas a andar o tamanho do tabuleiro + 1. Ex: andarCasas =
				 * 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) = posicao 2
				 */
				tabuleiro.setPosicaoJogador1(andarCasas - (tabuleiro.getTabuleiroSize() + 1));
				receberCarta(tabuleiro.getJogadores().get(0));
			} else
				// Caso contr�rio, anda o n� de casas
				tabuleiro.setPosicaoJogador1(andarCasas);
		}
		verificarCasa(posicaoJogador);
		// }
	}

	Duelo duelo = new Duelo();

	public void verificarCasa(int posicaoJogador) {

		if (tabuleiro.getPosicaoJogador1() == tabuleiro.getPosicaoJogador2()) {
			duelo.duelo(tabuleiro.getJogadores());
		} else if (posicaoJogador == 3 | posicaoJogador == 8 | posicaoJogador == 13 | posicaoJogador == 18) {
			// faz surpresa

		} else if (posicaoJogador == 1 | posicaoJogador == 4 | posicaoJogador == 6 | posicaoJogador == 9
				| posicaoJogador == 11 | posicaoJogador == 14 | posicaoJogador == 16 | posicaoJogador == 19) {
			duelo.duelo(tabuleiro.getJogadores());

			// Como fazer?
		}
	}
	// M�todos Adicionais

}
