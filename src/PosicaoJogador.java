
public class PosicaoJogador{

	//Atributos
			//Declaração da posição atual do jogador
		int posicao;
			//Declaração do Jogador
		Jogador jogador;

	// Construtor - com argumentos
		public PosicaoJogador (Jogador jogador) {
			this.jogador = jogador;
			posicao = 0;
		}


	// Acessores
		public int getPosicao() {
			return posicao;
		}	
		
		public void setPosicao(int posicao) {
			this.posicao = posicao;
		}
	
		public Jogador getJogador() {
			return jogador;
		}


	
		
		
	
	// Comportamentos
	
	
	
	
	// Métodos Adicionais
	@Override
		public String toString() {
		if (jogador.getNome() != "" && jogador.getNome() != null) {
			if(getPosicao() == 0) {
				return "O " + jogador + " está na posicao = Casa Partida";
			}
			return "O " + jogador + " está na posicao = " + posicao;
			
		}else
			return null;
	}
}
