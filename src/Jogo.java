import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;


/**
 * A classe jogo é o coração da aplicação, mostrando a descição, as cartas,
 * verificar casas, a mão do jogador, voitória e andar com o jogador. Tabém tem
 * as peças disponíveis para jogar
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

public class Jogo {

	// Atributos

	static Tabuleiro tabuleiro; // Gerar um tabuleiro
	Dado dado = new Dado(); // Gerar um dado
	Baralho baralho = new Baralho(); // Gerar um baralho
	ArrayList<Peca> pecas = new ArrayList<Peca>(); // Gerar uma peça

	// Comportamentos

	/**
	 * Criação do jogo de tabuleiro
	 */
	public Jogo() {
		jogoDescricao();
		this.tabuleiro = new Tabuleiro();
		turno();

	}

	/**
	 * Mostrar as cartas do jogador
	 * 
	 * @param cartas Um baralho de cartas da calsse Cartas
	 */
	public void mostrarCartas(ArrayList<Carta> cartas) {
		if (cartas == null) {
			throw new NullPointerException("O baralho não é válido");

		} else {
			for (int i = 0; i < cartas.size(); i++) {
				System.out.println("Carta " + (1 + i) + ": " + cartas.get(i));
			}
		}
	}

	/**
	 * Dá cartas ao jogador
	 * 
	 * @param jogador Um jogador da classe Jogador
	 */
	public void receberCarta(Jogador jogador) {
		if (jogador == null) {
			throw new NullPointerException("O jogador não é válido");

		} else {

			Collections.shuffle(baralho.getElementals());
			jogador.getMao().add(baralho.getElementals().get(1));
		}
	}

	/**
	 * Baralha o baralho e distribui as cartas para os jogadores
	 * 
	 * @param baralho Baralho de cartas
	 */
	public static void distribuirBaralho(ArrayList<Carta> baralho) {
		if (baralho == null) {
			throw new NullPointerException("O baralho não é válido");
		} else {

			Collections.shuffle(baralho);

			// Baralha o baralho e distribui 10 cartas à mão de cada jogador
			for (int jogador = 0; jogador < tabuleiro.getJogadores().size(); jogador++) {
				for (int carta = 0; carta < 10; carta++) {
					Collections.shuffle(baralho);
					tabuleiro.getJogadores().get(jogador).getMao().add(baralho.get(carta));
				}
			}
		}

	}

	/**
	 * Criação do sistema de turnos, o jogo começa no turno 1 com a distribuição de
	 * um baralho de cartas para a mão de cada jogador, os jogadores jogam
	 * alternadamente, começando pelo jogador 1, sendo que cada jogador cumpre o
	 * ciclo, sendo ele, lançar o dado, mover a peça e verificar as escolhas
	 * disponiveis de acordo com a localização da peça, por fim o turno acaba e
	 * começa tudo novamente mas no turno a seguir.
	 * 
	 */
	public void turno() {
		int turno = 1;
		System.out.println("-------------------- Participantes --------------------");
		// Demonstrar os participantes do jogo atual
		for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
			System.out.println("Jogador: " + tabuleiro.getJogadores().get(i).getNome());
		}
		System.out.println("");
		// Baralha e distribui o baralho
		distribuirBaralho(baralho.getElementals());

		// Conta os turnos,
		do {

			System.out.println("------------------- Turno " + turno + " --------------------");
			System.out.println("");

			// O jogador mostra as cartas que tem no seu baralho, move a peça dele
			// no tabuleiro, e, se calhar numa casa duelo ou surpresa faz o respetivo
			// desafio,
			// caso contrário, passa o turno
			// Demonstra o nome do jogador que deve fazer a sua jogada
			for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
				System.out.println("");
				System.out.println("-------------------- Vez do " + tabuleiro.getJogadores().get(i).getNome()
						+ " --------------------");
				System.out.println("");

				// Move a peça do jogador
				andarJogador(dado, i);

				System.out.println();

				// Anuncia a quantidade de duelos ganhos de cada jogador
				for (int j = 0; j < tabuleiro.getJogadores().size(); j++) {

					System.out.println(tabuleiro.getJogadores().get(j).getNome() + " tem  "
							+ tabuleiro.getJogadores().get(j).getVitoria() + " vitórias");
				}
				System.out.println("");
				System.out.println("Fim Turno");
				System.out.println("");
				if (verificaVitoria() == true)
					break;
			}
			turno++;
			// anunciamento de vitórias

		} while (verificaVitoria() == false);

		System.out.println("Fim do jogo");
		System.out.println("");
		System.out.println("O jogo durou " + turno + " turnos");
		System.out.println("");
		// Demonstra o primeiro jogador que ganhou 5 vitórias
		/*
		 * for (int i = 0; i < tabuleiro.getJogadores().size(); i++) { if
		 * (tabuleiro.getJogadores().get(i).getVitoria() >= 5) System.out.println((i +1)
		 * + "º -  " + tabuleiro.getJogadores().get(i).getNome());
		 * 
		 * // METER POSIÇÕES DOS JOGADORES DE ACORDO COM AS VITORIAS }
		 */

		int[] vitorias = new int[tabuleiro.jogadores.size()];
		for (int i = 0; i < tabuleiro.jogadores.size(); i++) {
			vitorias[i] = tabuleiro.jogadores.get(i).getVitoria();
		}
		int aux;
		for (int i = 0; i < tabuleiro.getJogadores().size() - 1; i++) {
			for (int j = i + 1; j < tabuleiro.getJogadores().size(); j++) {
				if (vitorias[i] < vitorias[j]) {
					aux = vitorias[i];
					vitorias[i] = vitorias[j];
					vitorias[j] = aux;
					Collections.swap(tabuleiro.getJogadores(), i, j);
				}
			}
		}
		for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {

			System.out.println((i + 1) + "º lugar - " + tabuleiro.getJogadores().get(i).getNome() + " com "
					+ tabuleiro.getJogadores().get(i).getVitoria() + " vitórias");
		}

		System.out.println("");
		System.out.println("");

	}

	/**
	 * Verifica se o jogador ganhou 10 duelos
	 * 
	 * @return True se algum jogador tiver ganho ou False caso nenhum tenha ganho
	 */
	public Boolean verificaVitoria() {
		for (int j = 0; j < tabuleiro.getJogadores().size(); j++) {
			if (tabuleiro.getJogadores().get(j).getVitoria() >= 10) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 
	 * Lança um dado, utiliza a posição atual do jogador, e depois anda o valor do
	 * dado no tabuleiro.
	 * 
	 * O dado não pode ser nulo e a posição do jogador não pode ser inferior a 0 nem
	 * superior a 20
	 * 
	 * @param dado    Um dado da classe dado
	 * @param jogador Posição do jogador
	 */
	public void andarJogador(Dado dado, int jogador) {

		// Validar os parametros
		if (dado == null) {
			throw new NullPointerException("O dado inserido é nulo");
		} else if (jogador < 0 || jogador > 24) {
			throw new IllegalArgumentException("A posição do jogador é superior a 24 ou inferior a 0");
		} else {

			int lancarDado = dado.lancarDado();

			System.out.println("Posição: " + tabuleiro.getJogadores().get(jogador).getPosicaoJogador());
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
			}

			System.out.println("Posição: " + tabuleiro.getJogadores().get(jogador).getPosicaoJogador());
			System.out.println("");

			verificarCasa(jogador);
		}
	}

	/**
	 * Verifica se o jogador está numa casa duelo ou surpresa e também se está na
	 * mesma casa que outro jogador, cada acontecimento resultará de uma ação, caso
	 * o jogador esteja numa casa surpresa, irá receber bónus, caso esteja numa casa
	 * duelo, irá duelar com outro jogador, caso esteja na mesma casa que outro
	 * jogador, irá duelar com esse jogador.
	 * 
	 * @param jogador Posicao do Jogador
	 */
	public void verificarCasa(int jogador) {
		if (jogador < 0 || jogador > 24) {
			throw new IllegalArgumentException("O jogador tem que ser superior a 0 e inferior a 25(não incluido)");
		} else {

			int posicaoJogador = tabuleiro.getJogadores().get(jogador).getPosicaoJogador();

			// Se os jogadores calharem na mesma casa, então fazem um duelo
			if (tabuleiro.getJogadores().get(0).getPosicaoJogador() == tabuleiro.getJogadores().get(1)
					.getPosicaoJogador()) {

				JOptionPane.showMessageDialog(null,
						tabuleiro.getJogadores().get(jogador).getNome() + " entrou em duelo", "SISTEMA DUELO",
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Entrou em duelo");
				System.out.println("");
				System.out.println("|");
				System.out.println("|");
				System.out.println("V");

				// Faz Desafio (duelo)
				tabuleiro.casaDuelo.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());

				// Se os jogadores calharem nas posições (3;8;13;18), faz surpresa
			} else if (posicaoJogador == 3 | posicaoJogador == 6 | posicaoJogador == 9 | posicaoJogador == 12
					| posicaoJogador == 15 | posicaoJogador == 18 | posicaoJogador == 21 | posicaoJogador == 24) {

				// Faz Desafio (surpresa)
				verificarMao(tabuleiro.getJogadores().get(jogador));
				tabuleiro.casaBonus.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());

				// Se os jogadores calharem nas posições (1;4;6;9;11;14;16;19), faz duelo
			} else if (posicaoJogador == 1 | posicaoJogador == 4 | posicaoJogador == 7 | posicaoJogador == 10
					| posicaoJogador == 13 | posicaoJogador == 16 | posicaoJogador == 19 | posicaoJogador == 22) {

				JOptionPane.showMessageDialog(null,
						tabuleiro.getJogadores().get(jogador).getNome() + " entrou em duelo", "SISTEMA DUELO",
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Casa Duelo");
				System.out.println("");
				System.out.println("|");
				System.out.println("|");
				System.out.println("V");

				// Faz Desafio (duelo)
				tabuleiro.casaDuelo.Desafio(jogador, baralho.getElementals(), tabuleiro.getJogadores());
			}
		}
	}

	/**
	 * Verifica a mão do jogador, na eventualidade de ficar sem cartas
	 * 
	 * @param jogador um jogador da classe jogador
	 */
	public void verificarMao(Jogador jogador) {

		if (jogador == null) {
			throw new NullPointerException("O jogador não é válido");

		} else {

			int quantidadeCartas = 3;

			// Caso o jogador fique sem cartas, recebe 3
			if (jogador.getMao().size() <= 0) {

				tabuleiro.getTabuleiro().get(0).recebeCarta(jogador, baralho.getElementals(), quantidadeCartas);
				JOptionPane.showMessageDialog(null, jogador.getNome() + "recebeu 3 cartas por ter ficado sem mão",
						"JOGO", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Descrição das características, objetivo e regras do jogo
	 */
	public void jogoDescricao() {

		String newLine = System.getProperty("line.separator");

		System.out.println("JOGO TABULEIRO: ELEMENTAL BATTLE");
		System.out.println("");
		System.out.println("");
		System.out.println("Objetivo:");
		System.out.println("");
		System.out.println("Obter 10 vitórias através de duelos");
		System.out.println("");
		System.out.println("");
		System.out.println("Informações:");
		System.out.println("");
		System.out.println("*    Um dado de 1 a 6");
		System.out.println("*    Um baralho de cartas");
		System.out.println("*    Um tabuleiro dividido por 25 casas");
		System.out.println("*    1 casa partida");
		System.out.println("*    8 casas neutra");
		System.out.println("*    8 casas duelo");
		System.out.println(
				"*    8 casas surpresa (nesta casa é testado a sorte do jogador, podendo sair dela beneficiado ou não)");
		System.out.println("");
		System.out.println("");
		System.out.println("Regras:");
		System.out.println("");
		System.out.println(" 1:   Jogadores: 2-6");
		System.out.println(" 2:   O jogador inicia com 10 cartas");
		System.out.println(" 3:   O jogador começa na casa partida");
		System.out.println(" 4:   O jogador só pode lançar o dado uma vez por jogada");
		System.out.println(" 5:   O jogador move-se pelo sentido dos ponteiros do relógio");
		System.out.println(" 6:   Cada vez que o jogador passa pela “casa partida”, recebe 1 carta aleatória");
		System.out.println(" 7:   As jogadas são alternadas");
		System.out.println(" 8:   Na casa neutra o jogador termina a sua vez");
		System.out.println(
				" 9:   Na casa surpresa o jogador recebe, aleatóriamente, uma ordem para avançar ou recuar x casas, ou pode receber/perder um bónus de força e/ou destreza numa carta aleatória");
		System.out.println("10:   Na casa duelo o jogador é obrigado a enfrentar o adversário");
		System.out.println(
				"11:   Se o jogador estiver na mesma casa que outro jogador, inica os duelos entre todos os jogadores ");
		System.out.println(
				"12:   Para ver quem ganha o duelo, é medido a força, caso seja igual é medido pela destreza e em caso de empate nenhum jogador ganha o ponto");
		System.out.println("13:   Cada carta só pode ser utilizada uma vez, pois é descartada após o seu uso");
		System.out.println("");
		System.out.println("");

		JOptionPane.showMessageDialog(null, " JOGO TABULEIRO: ELEMENTAL BATTLE" + newLine + newLine + "Objetivo:"
				+ newLine + newLine + "Obter 10 vitórias através de duelos" + newLine + newLine + "Informações:"
				+ newLine + newLine + "*    Um dado de 1 a 6" + newLine + "*    Um baralho de cartas" + newLine
				+ "*    Um tabuleiro dividido por 25 casas" + newLine + "*    1 casa partida" + newLine
				+ "*    8 casas neutra" + newLine + "*    8 casas duelo" + newLine + "*    8 casas surpresa" + newLine
				+ newLine + "Regras:" + newLine + newLine + " 1:   Jogadores: 2-6" + newLine
				+ " 2:   O jogador inicia com 10 cartas" + newLine + " 3:   O jogador começa na casa partida" + newLine
				+ " 4:   O jogador só pode lançar o dado uma vez por jogada" + newLine
				+ " 5:   O jogador move-se pelo sentido dos ponteiros do relógio" + newLine
				+ " 6:   Cada vez que o jogador passa pela “casa partida”, recebe 1 carta aleatória" + newLine
				+ " 7:   As jogadas são alternadas" + newLine + " 8:   Na casa neutra o jogador termina a sua vez"
				+ newLine
				+ " 9:   Na casa surpresa o jogador recebe, aleatóriamente, uma ordem para avançar ou recuar x casas, ou pode receber/perder um bónus de força e/ou destreza numa carta aleatória"
				+ newLine + "10:  Na casa duelo o jogador é obrigado a enfrentar o adversário" + newLine
				+ "11:  Se o jogador estiver na mesma casa que outro jogador, inica os duelos entre todos os jogadores"
				+ newLine
				+ "12:  Para ver quem ganha o duelo, é medido a força, caso seja igual é medido pela destreza e em caso de empate nenhum jogador ganha o ponto"
				+ newLine + "13:  Cada carta só pode ser utilizada uma vez, pois é descartada após o seu uso",
				"ELEMENTAL BATTLES", JOptionPane.INFORMATION_MESSAGE);

	}

}
