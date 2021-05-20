import java.util.ArrayList;
import java.util.Collections;

public class Jogo {
	// Atributos
	// Gerar o tabuleiro
	ArrayList<Casa> casas = new ArrayList<Casa>(tabuleiro6x6());
	// criar um dado
	Dado dado = new Dado();

	// Criar os 2 jogadores
	Jogador jogador1 = new Jogador();
	Jogador jogador2 = new Jogador();

	// Criar as posições dos jogadores
	PosicaoJogador posicaoJogador1 = new PosicaoJogador(jogador1);
	PosicaoJogador posicaoJogador2 = new PosicaoJogador(jogador2);

	// Construtor - com argumentos
	public Jogo(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}

	// Construtor - cópia
	public Jogo(Jogo jogo) {
		this.jogador1 = jogo.jogador1;
		this.jogador2 = jogo.jogador2;
	}


	// Acessores

	// Comportamentos
	
	public static ArrayList<Casa> tabuleiro6x6() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa(i));
		}

		return casas;
	}
	
	private static ArrayList<Carta> criarBaralho() {
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
	
	
	public static void distribuirBaralho(ArrayList<Carta> baralho, Jogador jogador1, Jogador jogador2) {
		
		Collections.shuffle(baralho);
		
		ArrayList<Carta> primeiroBaralho = new ArrayList<Carta>();
		ArrayList<Carta> segundoBaralho = new ArrayList<Carta>();
		
		System.out.println("Baralho do Jogador 1");
		System.out.println("");
		for (int i = 0; i < 7; i++) {
			Collections.shuffle(baralho);
			primeiroBaralho.add(baralho.get(i));
			System.out.println("Carta nº " + i + ": " + primeiroBaralho.get(i));
		}
		System.out.println("");
		System.out.println("-----------------------------------------------");
		System.out.println("");
		
		System.out.println("Baralho do Jogador 2");
		System.out.println("");
		for (int i = 0; i < 7; i++) {
			Collections.shuffle(baralho);
			segundoBaralho.add(baralho.get(i));
			System.out.println("Carta nº " + i + ": " + segundoBaralho.get(i));
		}
		
		jogador1.setCartas(primeiroBaralho);
		jogador2.setCartas(segundoBaralho);
		
		//System.out.println(baralho);
	}
	// Métodos Adicionais

}
