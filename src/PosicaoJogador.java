
public class PosicaoJogador{

	//Atributos
			//Declara��o da posi��o atual do jogador
		int posicao;
			//Declara��o do Jogador
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
	
	
	
	
	// M�todos Adicionais
	@Override
		public String toString() {
		if (jogador.getNome() != "" && jogador.getNome() != null) {
			if(getPosicao() == 0) {
				return "O " + jogador + " est� na posicao = Casa Partida";
			}
			return "O " + jogador + " est� na posicao = " + posicao;
			
		}else
			return null;
	}
}
