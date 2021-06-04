import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		
		
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		Jogador jogador1 = new Jogador();
		Jogador jogador2 = new Jogador();
		jogadores.add(jogador1);
		jogadores.add(jogador2);
		
		
		Tabuleiro tabuleiro = new Tabuleiro(jogadores);
		Jogo jogo = new Jogo(tabuleiro);
		jogo.turno();
		
		
		
//		System.out.println("O tabuleiro tem " + casas.size() + " casas");
//		System.out.println("");

//		System.out.println(posicaoJogador1);
//		System.out.println("");
		// for (int i = 0; i < 12; i++) {
		/*
		 * int lancarDado = dado.lancarDado();
		 * 
		 * 
		 * t.andarJogador(dado, posicaoJogador1); System.out.println(posicaoJogador1);
		 * System.out.println();
		 */
		// }

		// Creating an empty Stack

//		Jogo jogo = new Jogo(jogador1, jogador2);
//
//		ArrayList<Carta> baralho = new ArrayList<Carta>(criarBaralho());
//
//		jogo.distribuirBaralho(baralho, jogador1, jogador2);
//
//	}

	}

}
