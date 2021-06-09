import java.util.ArrayList;
import java.util.Collections;

public class Jogo {

	/**
	 * Gerar o tabuleiro
	 */
	static Tabuleiro tabuleiro = new Tabuleiro();

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

	// Comportamentos
	
	public Jogo() {
		turno();
	}

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
	public static void distribuirBaralho(ArrayList<Carta> baralho) {

		Collections.shuffle(baralho);
		
		for (int jogador = 0; jogador < tabuleiro.getJogadores().size(); jogador++) {
			for (int carta = 0; carta < 7; carta++) {
				Collections.shuffle(baralho);
				tabuleiro.getJogadores().get(jogador).getMao().add(baralho.get(carta));
			}
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
		System.out.println( "-------------------- Participantes --------------------");
		for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
			System.out.println("Jogador: " + tabuleiro.getJogadores().get(i).getNome());
		}
			System.out.println("");
		// Baralha e distribui o baralho
		distribuirBaralho(baralho.getElementals());


		// Conta os turnos,
		do {

			// Para o Jogador 1, Mostra as cartas que tem no seu baralho, move a peça dele
			// no tabuleiro, e, se calhar numa casa duelo, surpresa faz o respetivo desafio,
			// caso contrário, passa o turno

			System.err.println("------------------- Turno " + turno + " --------------------");
			System.out.println("");
			for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
				System.out.println("");
				System.out.println("-------------------- Turno do jogador " + tabuleiro.getJogadores().get(i).getNome() + " --------------------");
				System.out.println("");
				// Mostra as cartas que tem no seu baralho
				System.out.println("Mão do jogador:");
				mostrarCartas(tabuleiro.jogadores.get(i).getMao());
				// 	System.out.println("");
				andarJogador(dado, i);
				System.out.println("O jogador está na posição : " + tabuleiro.getJogadores().get(i).getPosicaoJogador());
				System.out.println();
				// Avança o turno
				
				for (int j = 0; j < tabuleiro.getJogadores().size(); j++) {
					
					System.out.println("O jogador " + tabuleiro.getJogadores().get(j).getNome() + " tem  " + tabuleiro.getJogadores().get(j).getVitoria() + " vitórias");
				}
				System.out.println("");
			}
			turno++;
			// anunciamento de vitórias
			

		} while (verificaVitoria() == false);

		System.out.println("Fim do jogo");
		System.out.println("");
		System.out.println("O jogo durou " + turno + " turnos");
		System.out.println("");
		for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
			if(tabuleiro.getJogadores().get(i).getVitoria() == 5)
				System.out.println("Ganhou o Jogador " + tabuleiro.getJogadores().get(i).getNome());
		}
		System.out.println("");

	}
	
	public Boolean verificaVitoria() {
		for (int j = 0; j < tabuleiro.getJogadores().size(); j++) {
			if(tabuleiro.getJogadores().get(j).getVitoria() >= 5) {
				return true;
			}
		}
		return false;
		
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

		// Se o número de casas a andar for maior que o número do tabuleiro
		if (andarCasas > tabuleiro.getTabuleiro().size()) {

//				 Subtrai ao nº de casas a andar com tamanho do tabuleiro + 1. Ex: andarCasas =
//				 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) = posicao 2

			tabuleiro.getJogadores().get(jogador).setPosicaoJogador((andarCasas - tabuleiro.getTabuleiro().size()));
			receberCarta(tabuleiro.getJogadores().get(jogador));
		} else {
			// Caso contrário, anda o nº de casas
			tabuleiro.getJogadores().get(jogador).setPosicaoJogador(andarCasas);
		System.out.println("Posição do jogador " + tabuleiro.getJogadores().get(jogador).getNome() + " é: " + tabuleiro.getJogadores().get(jogador).getPosicaoJogador());
		}
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

		if (tabuleiro.getJogadores().get(0).getPosicaoJogador() == tabuleiro.getJogadores().get(1)
				.getPosicaoJogador()) {

			// Se os jogadores calharem na mesma casa, então fazem um duelo
			tabuleiro.casaDuelo.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());
		} else if (posicaoJogador == 3 | posicaoJogador == 8 | posicaoJogador == 13 | posicaoJogador == 18) {

			// Faz Bonus
			tabuleiro.casaBonus.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());
		} else if (posicaoJogador == 1 | posicaoJogador == 4 | posicaoJogador == 6 | posicaoJogador == 9
				| posicaoJogador == 11 | posicaoJogador == 14 | posicaoJogador == 16 | posicaoJogador == 19) {

			// Duelo
			tabuleiro.casaDuelo.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());
		}
	}

}
