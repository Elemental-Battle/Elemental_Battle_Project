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
	 * Gerar Peça
	 */
	ArrayList<Peca> pecas = new ArrayList<Peca>();

	// Construtor - com argumentos
	/**
	 * Criação do jogo
	 * 
	 * @param tabuleiro Tabuleiro
	 */
	public Jogo(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	// Comportamentos

	/**
	 * Criação de um tabuleiro com 21 casas
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
	 * Dá cartas ao jogador
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
	 * Criação do sistema de turnos, o jogo começa no turno 1 com a distribuição de
	 * um baralho de cartas para a mão de cada jogador, os turnos são jogados
	 * alternadamente entre os jogadores, começando pelo jogador 1, o turno chega ao
	 * fim após concluir a sua jogada, lança o dado, move a peça, verifica as
	 * escolhas de acordo com a localização da peça, por fim, após as escolhas, o
	 * turno acaba e começa o próximo jogador.
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
			System.out.println("Coração do turno");

			// Para o Jogador 1, Mostra as cartas que tem no seu baralho, move a peça dele
			// no tabuleiro, e, se calhar numa casa duelo, surpresa faz o respetivo desafio,
			// caso contrário, passa o turno

			System.out.println("Turno " + turno);
			for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
				
				System.out.println("Jogadores: " + tabuleiro.getJogadores().size());
				System.out.println("Turno do jogador " + tabuleiro.getJogadores().get(i).getNome());
				// Mostra as cartas que tem no seu baralho
				mostrarCartas(tabuleiro.jogadores.get(i).getMao());
				andarJogador(dado, i);
				System.out.println(tabuleiro.getJogadores().get(i).getPosicaoJogador());
				System.out.println();
				// Avança o turno
				turno++;
			}

			System.out.println("Jogador 1 Vitórias: " + tabuleiro.getJogadores().get(0).getVitoria());
			System.out.println("Jogador 2 Vitórias: " + tabuleiro.getJogadores().get(1).getVitoria());

		} while (tabuleiro.getJogadores().get(0).getVitoria() < 5 && tabuleiro.getJogadores().get(1).getVitoria() < 5);

		System.out.println("Fim dos turnos");
		System.out.println("O jogo durou " + turno + " turnos");
		if (tabuleiro.getJogadores().get(0).getVitoria() == 5) {
			System.out.println("Ganhou o Jogador " + tabuleiro.getJogadores().get(1).getNome());
		} else
			System.out.println("Ganhou o Jogador " + tabuleiro.getJogadores().get(1).getNome());
	}

	/**
	 * Lança um dado, utiliza a posição atual do jogador, e depois anda o valor do
	 * dado no tabuleiro.
	 * 
	 * O dado não pode ser nulo e a posição do jogador não pode ser inferior a 0 nem
	 * superior a 20
	 * 
	 * @param dado           Dado
	 * @param posicaoJogador Posicao do Jogador
	 * 
	 * @throws IllegalArgumentException se a posição do jogador for inferior a 0 ou
	 *                                  superior a 20
	 * @throws NullPointerException     se o dado for nulo
	 */
	public void andarJogador(Dado dado, int jogador) {

//		 if (dado == null) { throw new NullPointerException("O dado inserido é nulo");
//		 } else if (posicaoJogador < 0 || posicaoJogador > 20) { throw new
//		 IllegalArgumentException("A posição do jogador é superior a 20 ou inferior a 0"
//		 ); } else {
//		 

		int lancarDado = dado.lancarDado();

		System.out.println("Valor do dado: " + lancarDado);

//		 Declarar o número de casas que o jogador vai andar com base na posição atual + o valor do dado lançado
		int andarCasas = tabuleiro.getJogadores().get(jogador).getPosicaoJogador() + lancarDado;
		System.out.println("Andar para a casa: " + andarCasas);
		// Se o número de casas a andar for maior que o número do tabuleiro
		if (andarCasas > tabuleiro.getTabuleiroSize()) {

//				 Subtrai ao nº de casas a andar o tamanho do tabuleiro + 1. Ex: andarCasas =
//				 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) = posicao 2

			tabuleiro.getJogadores().get(jogador).setPosicaoJogador((andarCasas - (tabuleiro.getTabuleiroSize() + 1)));
			receberCarta(tabuleiro.getJogadores().get(jogador));
		} else
			// Caso contrário, anda o nº de casas
			tabuleiro.getJogadores().get(jogador).setPosicaoJogador(andarCasas);

		verificarCasa(jogador);
	}

	

	/**
	 * Verifica se o jogador está numa casa duelo ou surpresa e também se está na
	 * mesma casa que outro jogador, cada acontecimento resultará de uma ação, caso
	 * o jogador esteja numa casa surpresa, irá receber bónus, caso esteja numa casa
	 * duelo, irá duelar com outro jogador, caso esteja na mesma casa que outro
	 * jogador, irá duelar com esse jogador.
	 * 
	 * @param posicaoJogador Posicao do Jogador
	 * 
	 */
	
	
	public void verificarCasa(int jogador) {
		int posicaoJogador = tabuleiro.getJogadores().get(jogador).getPosicaoJogador();

		if (tabuleiro.getJogadores().get(0).getPosicaoJogador() == tabuleiro.getJogadores().get(1).getPosicaoJogador()) {
			
			//Se os jogadores calharem na mesma casa, então fazem um duelo
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
