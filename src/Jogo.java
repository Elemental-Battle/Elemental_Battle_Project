import java.util.ArrayList;

public class Jogo {
	//Atributos
		//Gerar o tabuleiro
		ArrayList<Casa>  casas = new ArrayList<Casa>(tabuleiro6x6());
		//criar um dado
	Dado dado = new Dado();
	
	//Criar os 2 jogadores
	Jogador jogador1;
	Jogador jogador2;
	
	//Criar as posições dos jogadores
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
	
	
	public static ArrayList<Casa> tabuleiro6x6() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa(i));
		}
		
		
		return casas;
	}
	

	
	

		
		
		// Acessores
		
		
		// Comportamentos
		
		
		// Métodos Adicionais

	
	
}
