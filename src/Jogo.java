import java.util.ArrayList;
import java.util.Collections;

public class Jogo {
	// Atributos
	// Gerar o tabuleiro
	Tabuleiro tabuleiro = new Tabuleiro();
	// Gerar um dado
	Dado dado = new Dado();
	// Gerar um baralho
	Baralho baralho = new Baralho();
	// Gerar Pe�a
	//Peca peca = new Peca();
	ArrayList<Peca> pecas = new ArrayList<Peca>();


	// Construtor - com argumentos

	// Construtor - c�pia

	// Acessores

	// Comportamentos

	public static ArrayList<Casa> tabuleiro6x6() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa(i));
		}

		return casas;
	}

	public void mostrarCartas(ArrayList<Carta> cartas) {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println("Carta " + (1 + i) + ": " + cartas.get(i));
		}

	}

	public static void distribuirBaralho(ArrayList<Carta> baralho, ArrayList<Carta> primeiraMao, ArrayList<Carta> segundaMao) {

		Collections.shuffle(baralho);

		

		for (int i = 0; i < 7; i++) {
			Collections.shuffle(baralho);
			primeiraMao.add(baralho.get(i));
		}

		for (int i = 0; i < 7; i++) {
			Collections.shuffle(baralho);
			segundaMao.add(baralho.get(i));
		}
		//t.getJogador(0).setCartas(primeiroBaralho);

		
		// System.out.println(baralho);
	}

	// Turno ( while, for dentro, vai trocando de jogadores, dando lhes a ordem de andar, dentro da ordem andar, verficar se calhou numa casa especial e faz a respetiva
	//a��o, caso contrario, passa de turno.
	
	public void turno () {


		distribuirBaralho(baralho.getElementals(), baralho.getPrimeiraMao(), baralho.getSegundaMao());

		 do{
			 int turno = 1;
			 if (turno == 1) {
				 mostrarCartas(baralho.getPrimeiraMao());
				 andarJogador(dado, (Peca) tabuleiro.getJogadores().get(0), (Peca) tabuleiro.getJogadores().get(1));
			}else if (turno == 2) {
				 mostrarCartas(baralho.getSegundaMao());
				 andarJogador(dado, (Peca) tabuleiro.getJogadores().get(0), (Peca) tabuleiro.getJogadores().get(1));
			}
			 
			
		 }while(tabuleiro.getJogadores().get(0) == tabuleiro.getJogadores().get(1));
		 
		 if(tabuleiro.getJogadores().get(0).getVitoria() == 5) {
			 System.out.println("Ganhou o Jogador 1");
		 } else
			 System.out.println("Ganhou o Jogador 2");
	}
	
	public void andarJogador(Dado dado, Peca jogador, Peca jogador2) {

		int lancarDado = dado.lancarDado();
	

		System.out.println("Valor do dado: " + lancarDado);

		// Declarar o n�mero de casas que o jogador vai andar com base na posi��o atual
		// + o valor do dado lan�ado
		int andarCasas = jogador.getPosicao() + lancarDado;

		// Se o n�mero de casas a andar for maior que o n�mero do tabuleiro
		if (andarCasas > tabuleiro.getTabuleiroSize()) {

			// Subtrai ao n� de casas a andar o tamanho do tabuleiro + 1.
			// Ex: andarCasas = 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) =
			// posicao 2
			jogador.setPosicao(andarCasas - (tabuleiro.getTabuleiroSize() + 1));
		} else
			// Caso contr�rio, anda o n� de casas
			jogador.setPosicao(andarCasas);

		tabuleiro.verificarCasa(jogador, jogador2);
	}

	// M�todos Adicionais

}
