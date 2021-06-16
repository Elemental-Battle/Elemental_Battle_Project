package Elemental_Battle;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * A classe JogoTeste tem o propósito de testar todos os comportamentos da
 * classe Jogo.
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

class JogoTest {

	@Test
	/**
	 * Verifica se existe um baralho de cartas válido para jogar o jogo.
	 */
	void testMostrarCartas() {
		Jogo jogo = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.mostrarCartas(null);
		}, "Precisa de inserir um baralho de cartas válido");
	}

	@Test
	/**
	 * Verifica se existe um jogador válido para receber uma carta.
	 */
	void testReceberCarta() {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.receberCarta(null);
		}, "Precisa de inserir um jogador válido");
	}

	@Test
	/**
	 * Verficia se existe um baralho válido de cartas para as poder distribuir.
	 */
	void testDistribuirBaralho() {
		Jogo jogo = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.distribuirBaralho(null);
		}, "Precisa de inserir um baralho de cartas válido");
	}

	@Test
	/**
	 * Verifica se o dado é nulo e depois se o valor da posição do jogador é
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
	 *  Verifica se a posição do jogador seja inferior a 0 e se o valor da posição do jogador é superior a 24.
	 */
	void testVerificarCasa() {
		Jogo jogo = new Jogo();

		// Teste 1
		assertThrows(IllegalArgumentException.class, () -> {
			jogo.verificarCasa(-1);
		}, "Caso o valor da posição do jogador seja inferior a 0");

		// Teste 2
		assertThrows(IllegalArgumentException.class, () -> {
			jogo.verificarCasa(25);
		}, "Caso o valor da posição do jogador seja superior a 24");

	}

	@Test
	/**
	 *  Verifica se o jogador tem uma mão válida.
	 */
	void testVerificarMao() {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.verificarMao(null);
		}, "O jogador não é válido");

	}

}
