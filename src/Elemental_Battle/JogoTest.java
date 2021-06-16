package Elemental_Battle;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * A classe JogoTeste tem o prop�sito de testar todos os comportamentos da
 * classe Jogo.
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

class JogoTest {

	@Test
	/**
	 * Verifica se existe um baralho de cartas v�lido para jogar o jogo.
	 */
	void testMostrarCartas() {
		Jogo jogo = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.mostrarCartas(null);
		}, "Precisa de inserir um baralho de cartas v�lido");
	}

	@Test
	/**
	 * Verifica se existe um jogador v�lido para receber uma carta.
	 */
	void testReceberCarta() {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.receberCarta(null);
		}, "Precisa de inserir um jogador v�lido");
	}

	@Test
	/**
	 * Verficia se existe um baralho v�lido de cartas para as poder distribuir.
	 */
	void testDistribuirBaralho() {
		Jogo jogo = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.distribuirBaralho(null);
		}, "Precisa de inserir um baralho de cartas v�lido");
	}

	@Test
	/**
	 * Verifica se o dado � nulo e depois se o valor da posi��o do jogador �
	 * superior a 0 e inferior a 24.
	 */
	void testAndarJogador() {
		Jogo jogo = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		int jogador = 21;
		Dado dado = new Dado();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.andarJogador(null, jogador);
		}, "Caso o dado seja nulo");

		// Teste 2
		assertThrows(IllegalArgumentException.class, () -> {
			jogo.andarJogador(dado, -1);
		}, "Caso o valor do jogador seja superior a 24 ou inferior a 0");
	}

	@Test
	/**
	 *  Verifica se a posi��o do jogador seja inferior a 0 e se o valor da posi��o do jogador � superior a 24.
	 */
	void testVerificarCasa() {
		Jogo jogo = new Jogo();

		// Teste 1
		assertThrows(IllegalArgumentException.class, () -> {
			jogo.verificarCasa(-1);
		}, "Caso o valor da posi��o do jogador seja inferior a 0");

		// Teste 2
		assertThrows(IllegalArgumentException.class, () -> {
			jogo.verificarCasa(25);
		}, "Caso o valor da posi��o do jogador seja superior a 24");

	}

	@Test
	/**
	 *  Verifica se o jogador tem uma m�o v�lida.
	 */
	void testVerificarMao() {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.verificarMao(null);
		}, "O jogador n�o � v�lido");

	}

}
