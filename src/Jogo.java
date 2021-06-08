import java.util.ArrayList;
import java.util.Collections;

public class Jogo {

	/**
	 * Gerar o tabuleiro
	 */
	Tabuleiro tabuleiro = new Tabuleiro();

	/**
	 * Gerar um dado
	 */
	Dado dado = new Dado();

	/**
	 * Gerar um baralho
	 */
	Baralho baralho = new Baralho();

	/**
	 * Gerar Pe�a
	 */
	ArrayList<Peca> pecas = new ArrayList<Peca>();

	// Construtor - com argumentos
	/**
	 * Cria��o do jogo
	 * 
	 * @param tabuleiro Tabuleiro
	 */
	public Jogo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	// Comportamentos

	/**
	 * Cria��o de um tabuleiro com 21 casas
	 * 
	 * @return Tabuleiro gerado
	 */
//	public static ArrayList<Casa> tabuleiro6x6() {
//		ArrayList<Casa> casas = new ArrayList<Casa>();
//		for (int i = 0; i < 20; i++) {
//			casas.add(new Casa());
//		}
//
//		return casas;
//	}

	/**
	 * Vai mostrar as cartas
	 * 
	 * @param cartas Cartas
	 */
	public void mostrarCartas(ArrayList<Carta> cartas) {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println("Carta " + (1 + i) + ": " + cartas.get(i));
		}

	}

	/**
	 * D� cartas ao jogador
	 * 
	 * @param jogador Jogador
	 */
	public void receberCarta(Jogador jogador) {

		Collections.shuffle(baralho.getElementals());
		jogador.getMao().add(baralho.getElementals().get(1));
	}

	/**
	 * Baralha o baralho, e depois divide por 2
	 * 
	 * @param baralho     Baralho de cartas
	 * @param primeiraMao Mao do jogador 1
	 * @param segundaMao  Mao do jogador 2
	 */
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

	/**
	 * Cria��o do sistema de turnos, o jogo come�a no turno 1 com a distribui��o de
	 * um baralho de cartas para a m�o de cada jogador, os turnos s�o jogados
	 * alternadamente entre os jogadores, come�ando pelo jogador 1, o turno chega ao
	 * fim ap�s concluir a sua jogada, lan�a o dado, move a pe�a, verifica as
	 * escolhas de acordo com a localiza��o da pe�a, por fim, ap�s as escolhas, o
	 * turno acaba e come�a o pr�ximo jogador.
	 * 
	 * 
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

			// Para o Jogador 1, Mostra as cartas que tem no seu baralho, move a pe�a dele
			// no tabuleiro, e, se calhar numa casa duelo, surpresa faz o respetivo desafio,
			// caso contr�rio, passa o turno

			System.out.println("Turno " + turno);
			for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
				
				System.out.println("Jogadores: " + tabuleiro.getJogadores().size());
				System.out.println("Turno do jogador " + tabuleiro.getJogadores().get(i).getNome());
				// Mostra as cartas que tem no seu baralho
				mostrarCartas(tabuleiro.jogadores.get(i).getMao());
				andarJogador(dado, i);
				System.out.println(tabuleiro.getJogadores().get(i).getPosicaoJogador());
				System.out.println();
				// Avan�a o turno
				turno++;
			}

			System.out.println("Jogador 1 Vit�rias: " + tabuleiro.getJogadores().get(0).getVitoria());
			System.out.println("Jogador 2 Vit�rias: " + tabuleiro.getJogadores().get(1).getVitoria());

		} while (tabuleiro.getJogadores().get(0).getVitoria() < 5 && tabuleiro.getJogadores().get(1).getVitoria() < 5);

		System.out.println("Fim dos turnos");
		System.out.println("O jogo durou " + turno + " turnos");
		if (tabuleiro.getJogadores().get(0).getVitoria() == 5) {
			System.out.println("Ganhou o Jogador " + tabuleiro.getJogadores().get(1).getNome());
		} else
			System.out.println("Ganhou o Jogador " + tabuleiro.getJogadores().get(1).getNome());
	}

	/**
	 * Lan�a um dado, utiliza a posi��o atual do jogador, e depois anda o valor do
	 * dado no tabuleiro.
	 * 
	 * O dado n�o pode ser nulo e a posi��o do jogador n�o pode ser inferior a 0 nem
	 * superior a 20
	 * 
	 * @param dado           Dado
	 * @param posicaoJogador Posicao do Jogador
	 * 
	 * @throws IllegalArgumentException se a posi��o do jogador for inferior a 0 ou
	 *                                  superior a 20
	 * @throws NullPointerException     se o dado for nulo
	 */
	public void andarJogador(Dado dado, int jogador) {

//		 if (dado == null) { throw new NullPointerException("O dado inserido � nulo");
//		 } else if (posicaoJogador < 0 || posicaoJogador > 20) { throw new
//		 IllegalArgumentException("A posi��o do jogador � superior a 20 ou inferior a 0"
//		 ); } else {
//		 

		int lancarDado = dado.lancarDado();

		System.out.println("Valor do dado: " + lancarDado);

//		 Declarar o n�mero de casas que o jogador vai andar com base na posi��o atual + o valor do dado lan�ado
		int andarCasas = tabuleiro.getJogadores().get(jogador).getPosicaoJogador() + lancarDado;
		System.out.println("Andar para a casa: " + andarCasas);
		// Se o n�mero de casas a andar for maior que o n�mero do tabuleiro
		if (andarCasas > tabuleiro.getTabuleiroSize()) {

//				 Subtrai ao n� de casas a andar o tamanho do tabuleiro + 1. Ex: andarCasas =
//				 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) = posicao 2

			tabuleiro.getJogadores().get(jogador).setPosicaoJogador((andarCasas - (tabuleiro.getTabuleiroSize() + 1)));
			receberCarta(tabuleiro.getJogadores().get(jogador));
		} else
			// Caso contr�rio, anda o n� de casas
			tabuleiro.getJogadores().get(jogador).setPosicaoJogador(andarCasas);

		verificarCasa(jogador);
	}

	

	/**
	 * Verifica se o jogador est� numa casa duelo ou surpresa e tamb�m se est� na
	 * mesma casa que outro jogador, cada acontecimento resultar� de uma a��o, caso
	 * o jogador esteja numa casa surpresa, ir� receber b�nus, caso esteja numa casa
	 * duelo, ir� duelar com outro jogador, caso esteja na mesma casa que outro
	 * jogador, ir� duelar com esse jogador.
	 * 
	 * @param posicaoJogador Posicao do Jogador
	 * 
	 */
	
	
	public void verificarCasa(int jogador) {
		int posicaoJogador = tabuleiro.getJogadores().get(jogador).getPosicaoJogador();

		if (tabuleiro.getJogadores().get(0).getPosicaoJogador() == tabuleiro.getJogadores().get(1).getPosicaoJogador()) {
			
			//Se os jogadores calharem na mesma casa, ent�o fazem um duelo
			tabuleiro.casaDuelo.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());
		} else if (posicaoJogador == 3 | posicaoJogador == 8 | posicaoJogador == 13 | posicaoJogador == 18) {
			
			//Faz Bonus
			tabuleiro.casaBonus.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());
		} else if (posicaoJogador == 1 | posicaoJogador == 4 | posicaoJogador == 6 | posicaoJogador == 9
				| posicaoJogador == 11 | posicaoJogador == 14 | posicaoJogador == 16 | posicaoJogador == 19) {
			
			//Duelo
			tabuleiro.casaDuelo.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());
		}
	}

}
