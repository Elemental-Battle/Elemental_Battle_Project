import java.util.ArrayList;
import java.util.Collections;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

public class Jogo {

	// Atributos

	static Tabuleiro tabuleiro = new Tabuleiro(); // Gerar um tabuleiro
	Dado dado = new Dado(); // Gerar um dado
	Baralho baralho = new Baralho(); // Gerar um baralho
	ArrayList<Peca> pecas = new ArrayList<Peca>(); // Gerar uma pe�a

	// Comportamentos

	/**
	 * Cria��o do jogo de tabuleiro
	 */
	public Jogo() {
	
		jogoDescricao();
		turno();

	}

	/**
	 * Mostrar as cartas do jogador
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
	 * Baralha o baralho e distribui as cartas para os jogadores
	 * 
	 * @param baralho Baralho de cartas
	 */
	public static void distribuirBaralho(ArrayList<Carta> baralho) {

		Collections.shuffle(baralho);

		// Baralha o baralho e distribui 7 cartas � m�o de cada jogador
		for (int jogador = 0; jogador < tabuleiro.getJogadores().size(); jogador++) {
			for (int carta = 0; carta < 7; carta++) {
				Collections.shuffle(baralho);
				tabuleiro.getJogadores().get(jogador).getMao().add(baralho.get(carta));
			}
		}

	}

	/**
	 * Cria��o do sistema de turnos, o jogo come�a no turno 1 com a distribui��o de
	 * um baralho de cartas para a m�o de cada jogador, os jogadores jogam
	 * alternadamente, come�ando pelo jogador 1, sendo que cada jogador cumpre o
	 * ciclo, sendo ele, lan�ar o dado, mover a pe�a e verificar as escolhas
	 * disponiveis de acordo com a localiza��o da pe�a, por fim o turno acaba e
	 * come�a tudo novamente mas no turno a seguir.
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

			// O jogador mostra as cartas que tem no seu baralho, move a pe�a dele
			// no tabuleiro, e, se calhar numa casa duelo ou surpresa faz o respetivo
			// desafio,
			// caso contr�rio, passa o turno

			System.err.println("------------------- Turno " + turno + " --------------------");
			System.out.println("");
			// Demonstra o nome do jogador que deve fazer a sua jogada
			for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
				System.out.println("");
				System.out.println("-------------------- Vez do jogador " + tabuleiro.getJogadores().get(i).getNome()
						+ " --------------------");
				System.out.println("");

				System.out.println("M�o do jogador:");
				// Mostra as cartas que tem na sua m�o
				mostrarCartas(tabuleiro.jogadores.get(i).getMao());
				// Move a pe�a do jogador
				andarJogador(dado, i);
				System.out
						.println("O jogador est� na posi��o : " + tabuleiro.getJogadores().get(i).getPosicaoJogador());
				System.out.println();

				// Anuncia a quantidade de duelos ganhos de cada jogador
				for (int j = 0; j < tabuleiro.getJogadores().size(); j++) {

					System.out.println("O jogador " + tabuleiro.getJogadores().get(j).getNome() + " tem  "
							+ tabuleiro.getJogadores().get(j).getVitoria() + " vit�rias");
				}
				System.out.println("");
			}
			turno++;
			// anunciamento de vit�rias

		} while (verificaVitoria() == false);

		System.out.println("Fim do jogo");
		System.out.println("");
		System.out.println("O jogo durou " + turno + " turnos");
		System.out.println("");
		// Demonstra o primeiro jogador que ganhou 5 vit�rias
		for (int i = 0; i < tabuleiro.getJogadores().size(); i++) {
			if (tabuleiro.getJogadores().get(i).getVitoria() == 5)
				System.out.println("Ganhou o Jogador " + tabuleiro.getJogadores().get(i).getNome());
		}
		System.out.println("");

	}

	/**
	 * Verifica se o jogador ganhou 5 duelos
	 * 
	 * @return true/false
	 */
	public Boolean verificaVitoria() {
		for (int j = 0; j < tabuleiro.getJogadores().size(); j++) {
			if (tabuleiro.getJogadores().get(j).getVitoria() >= 5) {
				return true;
			}
		}
		return false;

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

		// Se o n�mero de casas a andar for maior que o n�mero do tabuleiro
		if (andarCasas > tabuleiro.getTabuleiro().size()) {

//				 Subtrai ao n� de casas a andar com tamanho do tabuleiro + 1. Ex: andarCasas =
//				 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) = posicao 2

			tabuleiro.getJogadores().get(jogador).setPosicaoJogador((andarCasas - tabuleiro.getTabuleiro().size()));
			receberCarta(tabuleiro.getJogadores().get(jogador));
		} else {
			// Caso contr�rio, anda o n� de casas
			tabuleiro.getJogadores().get(jogador).setPosicaoJogador(andarCasas);
			System.out.println("Posi��o do jogador " + tabuleiro.getJogadores().get(jogador).getNome() + " �: "
					+ tabuleiro.getJogadores().get(jogador).getPosicaoJogador());
		}
		verificarCasa(jogador);
	}

	/**
	 * Verifica se o jogador est� numa casa duelo ou surpresa e tamb�m se est� na
	 * mesma casa que outro jogador, cada acontecimento resultar� de uma a��o, caso
	 * o jogador esteja numa casa surpresa, ir� receber b�nus, caso esteja numa casa
	 * duelo, ir� duelar com outro jogador, caso esteja na mesma casa que outro
	 * jogador, ir� duelar com esse jogador.
	 * 
	 * 
	 * @param jogador Posicao do Jogador
	 */
	public void verificarCasa(int jogador) {
		int posicaoJogador = tabuleiro.getJogadores().get(jogador).getPosicaoJogador();

		if (tabuleiro.getJogadores().get(0).getPosicaoJogador() == tabuleiro.getJogadores().get(1)
				.getPosicaoJogador()) {

			// Se os jogadores calharem na mesma casa, ent�o fazem um duelo
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

	/**
	 * Descri��o das caracter�sticas, objetivo e regras do jogo
	 */
	public void jogoDescricao() {

		String newLine = System.getProperty("line.separator");

		JOptionPane.showMessageDialog(null, " JOGO TABULEIRO: ELEMENTAL BATTLE" + newLine + newLine + "Objetivo:"
				+ newLine + newLine + "Obter 5 vit�rias nas casas duelo" + newLine + newLine + "Informa��es:" + newLine
				+ newLine + "*    Um dado de 1 a 6" + newLine + "*    Um tabuleiro dividido por 21 casas" + newLine
				+ "*    Um baralho de 30 cartas" + newLine + "*    1 casa partida (posi��o onde o jogador come�a)"
				+ newLine + "*    7 casas neutra (o jogador n�o pode fazer qualquer a��o e passa o turno)" + newLine
				+ "*    8 casas duelo (o jogador � obrigado a entrar num duelo com o advers�rio)" + newLine
				+ "*    4 casas surpresa (nesta casa � testado a sorte do jogador, podendo sair dela beneficiado ou n�o)"
				+ newLine + newLine + "Regras:" + newLine + newLine + "1:   Jogadores: 2-6" + newLine
				+ "2:   O jogador inicia com 7 cartas" + newLine + "3:   O jogador come�a na casa partida" + newLine
				+ "4:   O jogador s� pode lan�ar o dado uma vez por jogada" + newLine
				+ "5:   O jogador move-se pelo sentido dos ponteiros do rel�gio" + newLine
				+ "6:   Cada vez que o jogador passa pela �casa partida�, recebe 1 carta aleat�ria" + newLine
				+ "7:   As jogadas s�o alternadas" + newLine + "8:   Na casa neutra o jogador termina a sua vez"
				+ newLine
				+ "9:   Na casa surpresa o jogador recebe, aleat�riamente, uma ordem para avan�ar ou recuar x casas, ou pode receber um b�nus de for�a e/ou destreza numa carta � sua escolha"
				+ newLine + "10:   Na casa duelo o jogador � obrigado a enfrentar o advers�rio" + newLine
				+ "11:   Para ver quem ganha o duelo, � medido a for�a, caso seja igual � medido pela destreza e em caso de empate nenhum jogador ganha o ponto"
				+ newLine + "12:   Cada carta s� pode ser utilizada uma vez, pois � descartada ap�s o seu uso");

	}

}
