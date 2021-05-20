import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Dado dado = new Dado();

		Jogador jogador1 = new Jogador("1");
		Jogador jogador2 = new Jogador("2");

		PosicaoJogador posicaoJogador1 = new PosicaoJogador(jogador1);

		ArrayList<Casa> casas = new ArrayList<Casa>(criarCasas());

		Tabuleiro t = new Tabuleiro(casas, jogador1, jogador2);

		System.out.println("O tabuleiro tem " + casas.size() + " casas");
		System.out.println("");

		System.out.println(posicaoJogador1);
		System.out.println("");
		for (int i = 0; i < 12; i++) {
			/*
			 * int lancarDado = dado.lancarDado();
			 * 
			 * 
			 * t.andarJogador(dado, posicaoJogador1); System.out.println(posicaoJogador1);
			 * System.out.println();
			 */
		}

		// Creating an empty Stack
		
		Jogo jogo = new Jogo(jogador1, jogador2);
		
		ArrayList<Carta> baralho = new ArrayList<Carta>(criarBaralho());
		
		jogo.distribuirBaralho(baralho, jogador1, jogador2);
		
		
		
	}

	public static ArrayList<Casa> criarCasas() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa(i));
		}

		return casas;
	}
	

	public static ArrayList<Carta> criarBaralho() {
		ArrayList<Carta> baralho = new ArrayList<Carta>();

		baralho.add(new Carta("Water Elemental", 10, 5, 6));
		baralho.add(new Carta("Fire Elemental", 10, 5, 3));
		baralho.add(new Carta("Earth  Elemental", 10, 5, 4));
		baralho.add(new Carta("Air   Elemental", 10, 5, 1));
		baralho.add(new Carta("Water Bender", 5, 5, 2));
		baralho.add(new Carta("Fire Bender", 5, 5, 5));
		baralho.add(new Carta("Earth  Bender", 5, 5, 4));
		baralho.add(new Carta("Air  Bender", 5, 5, 1));
		baralho.add(new Carta("Emperor", 4, 5, 2));
		baralho.add(new Carta("Archmage", 4, 4, 5));
		baralho.add(new Carta("Hell", 4, 5, 1));
		baralho.add(new Carta("Murlock", 1, 5, 3));
		baralho.add(new Carta("Storm", 3, 5, 0));
		baralho.add(new Carta("Bloodmage", 3, 2, 0));
		baralho.add(new Carta("Doctor Boom", 3, 4, 0));
		baralho.add(new Carta("Windrunner", 3, 1, 0));
		baralho.add(new Carta("Cursed Blade", 1, 1, 0));
		baralho.add(new Carta("Magma Rager", 1, 2, 0));
		baralho.add(new Carta("Azure Drake", 1, 4, 0));
		baralho.add(new Carta("Angry Chicken", 6, 5, 0));
		baralho.add(new Carta("Faceless", 7, 4, 0));
		baralho.add(new Carta("Reksai", 7, 5, 0));
		baralho.add(new Carta("Yasuo", 7, 1, 0));
		baralho.add(new Carta("Razorpetal", 7, 3, 0));
		baralho.add(new Carta("Safari", 8, 5, 0));
		baralho.add(new Carta("Death", 8, 3, 0));
		baralho.add(new Carta("Brook", 8, 1, 0));
		baralho.add(new Carta("Zed", 9, 2, 6));
		baralho.add(new Carta("The Lich King", 9, 5, 5));
		baralho.add(new Carta("God King", 9, 3, 2));

		return baralho;
	}
}
