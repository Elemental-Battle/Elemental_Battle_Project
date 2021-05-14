
public class Jogador {
	//Atributos
	
		//Declara��o do nome do jogador
	private String nome;
	
	//Construtor - default
	public Jogador() {
		
	}
	
	// Construtor - com argumentos
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	// Construtor - c�pia
	public Jogador(Jogador jogador) {
		this.nome = jogador.nome;
	}
	// Acessores
	public String getNome() {
		return nome;
	}
	
	// Comportamentos
	
	// M�todos Adicionais
	
		//ToString do Jogador com as respetivas informa��es
		@Override
		public String toString() {
			return "jogador " + getNome().toUpperCase();
		}
		
		//Clonar o Jogador
		public Jogador clone() {
			return new Jogador(this);
		}
		
		//Permite saber se os tabuleiros s�o iguais
		public boolean equals(Jogador jogador) {
			if(jogador == null)
				return false;
			else if (nome.equals( jogador.getNome() ))
				return true;
			else
				return false;
		}
}
