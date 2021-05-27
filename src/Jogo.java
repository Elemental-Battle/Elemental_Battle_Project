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
	// Gerar Peça
	Peca peca = new Peca();

	// Construtor - com argumentos

	// Construtor - cópia

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

	public static void distribuirBaralho(ArrayList<Carta> baralho, Jogador jogador1, Jogador jogador2) {

		Collections.shuffle(baralho);

		ArrayList<Carta> primeiroBaralho = new ArrayList<Carta>();
		ArrayList<Carta> segundoBaralho = new ArrayList<Carta>();

		for (int i = 0; i < 7; i++) {
			Collections.shuffle(baralho);
			primeiroBaralho.add(baralho.get(i));
		}

		for (int i = 0; i < 7; i++) {
			Collections.shuffle(baralho);
			segundoBaralho.add(baralho.get(i));
		}

//		jogador1.setCartas(primeiroBaralho);
//		jogador2.setCartas(segundoBaralho);

		System.out.println("Baralho do Jogador 1");
		System.out.println("");
		//jogador1.mostrarCartas(primeiroBaralho);
		System.out.println("");
		System.out.println("-----------------------------------------------");
		System.out.println("");

		System.out.println("Baralho do Jogador 2");
		System.out.println("");
		//jogador2.mostrarCartas(segundoBaralho);

		// System.out.println(baralho);
	}

	// Turno ( while, for dentro, vai trocando de jogadores, dando lhes a ordem de andar, dentro da ordem andar, verficar se calhou numa casa especial e faz a respetiva
	//ação, caso contrario, passa de turno.
	
	
	public void andarJogador(Dado dado, Peca jogador) {

		int lancarDado = dado.lancarDado();
	

		System.out.println("Valor do dado: " + lancarDado);

		// Declarar o número de casas que o jogador vai andar com base na posição atual
		// + o valor do dado lançado
		int andarCasas = jogador.getPosicao() + lancarDado;

		// Se o número de casas a andar for maior que o número do tabuleiro
		if (andarCasas > tabuleiro.getTabuleiroSize()) {

			// Subtrai ao nº de casas a andar o tamanho do tabuleiro + 1.
			// Ex: andarCasas = 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) =
			// posicao 2
			jogador.setPosicao(andarCasas - (tabuleiro.getTabuleiroSize() + 1));
		} else
			// Caso contrário, anda o nº de casas
			jogador.setPosicao(andarCasas);

	}

	// Métodos Adicionais

}
