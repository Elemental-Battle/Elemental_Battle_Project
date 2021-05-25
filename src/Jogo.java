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
		jogador1.mostrarCartas(primeiroBaralho);
		System.out.println("");
		System.out.println("-----------------------------------------------");
		System.out.println("");

		System.out.println("Baralho do Jogador 2");
		System.out.println("");
		jogador2.mostrarCartas(segundoBaralho);

		// System.out.println(baralho);
	}
	// Métodos Adicionais

}
