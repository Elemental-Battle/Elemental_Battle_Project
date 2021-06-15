import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JogoTest {

	@Test
	void testMostrarCartas() {
		Jogo jogo  = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		
		// Teste 1 
		assertThrows(NullPointerException.class, () -> {
			jogo.mostrarCartas(null);
		}, "Precisa de inserir um baralho de cartas válido" );
	}
	
	@Test
	void testReceberCarta() {
		Jogo jogo  = new Jogo();
		Jogador jogador = new Jogador();
		
		// Teste 1 
		assertThrows(NullPointerException.class, () -> {
			jogo.receberCarta(null);
		}, "Precisa de inserir um jogador válido" );
	}
	
	@Test
	void testDistribuirBaralho() {
		Jogo jogo  = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		
		// Teste 1 
		assertThrows(NullPointerException.class, () -> {
			jogo.distribuirBaralho(null);
		}, "Precisa de inserir um baralho de cartas válido" );
	}
	
	@Test
	void testAndarJogador() {
		Jogo jogo  = new Jogo();
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		int jogador = 21;
		Dado dado = new Dado();

		//Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.andarJogador(null, jogador);
		}, "Caso o dado seja nulo" );
		
		
		//Teste 2
		assertThrows(IllegalArgumentException.class, () -> {
			jogo.andarJogador(dado, -1);
		}, "Caso o valor do jogador seja superior a 24 ou inferior a 0" );
	}
	
	@Test
	void testVerificarCasa() {
		Jogo jogo  = new Jogo();

		//Teste 1
		assertThrows(IllegalArgumentException.class, () -> {
			jogo.verificarCasa(-1);
		}, "Caso o valor da posição do jogador seja inferior a 0" );
		
		//Teste 2
		assertThrows(IllegalArgumentException.class, () -> {
			jogo.verificarCasa(25);
		}, "Caso o valor da posição do jogador seja superior a 24" );
		
	}
	
	@Test
	void testVerificarMao() {
		Jogo jogo  = new Jogo();
		Jogador jogador = new Jogador();

		//Teste 1
		assertThrows(NullPointerException.class, () -> {
			jogo.verificarMao(null);
		}, "O jogador não é válido");
		
	}
	
}
