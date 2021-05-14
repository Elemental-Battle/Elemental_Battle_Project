import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Dado dado = new Dado();
		
		Jogador jogador1 = new Jogador("1");
		Jogador jogador2 = new Jogador();
		
		PosicaoJogador posicaoJogador1 = new PosicaoJogador(jogador1);
		
		ArrayList<Casa>  casas = new ArrayList<Casa>(criarCasas());
		
		
		Tabuleiro t = new Tabuleiro(casas, jogador1, jogador2);
		
		System.out.println("O tabuleiro tem " + casas.size() + " casas");
		System.out.println("");
		
		System.out.println(posicaoJogador1);
		System.out.println("");
		for (int i = 0; i < 5; i++) {
		
			
			t.andarJogador(dado, posicaoJogador1);
			System.out.println(posicaoJogador1);
			System.out.println();
			
		}

		
	}

	
	public static ArrayList<Casa> criarCasas() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 15; i++) {
			casas.add(new Casa(i));
		}
		
		
		return casas;
	}
}

