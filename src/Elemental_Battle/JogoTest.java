package Elemental_Battle;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * A classe JogoTeste tem o prop�sito de testar todo o c�digo da classe Jogo
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

class JogoTest {

	@Test
	// Verificar se existe um baralho de cartas para jogar o jogo
	void testMostrarCartas() {
		Jogo jogo = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.mostrarCartas(null);
		}, "Precisa de inserir um baralho de cartas v�lido");
	}

	@Test
	// Verificar se existe um jogador para receber uma carta
	void testReceberCarta() {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.receberCarta(null);
		}, "Precisa de inserir um jogador v�lido");
	}

	@Test
	// Verficiar se existe um baralho de cartas para poder distribui-las
	void testDistribuirBaralho() {
		Jogo jogo = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.distribuirBaralho(null);
		}, "Precisa de inserir um baralho de cartas v�lido");
	}

	@Test
	// Verificar o valor do dado e o valor da posi��o do jogador
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
	// Verificar a posi��o do jogador
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
	// Verificar se o jogador tem m�o
	void testVerificarMao() {
		Jogo jogo = new Jogo();
		Jogador jogador = new Jogador();

		// Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.verificarMao(null);
		}, "O jogador n�o � v�lido");

	}

}