import java.util.ArrayList;

public class Tabuleiro {

	//Atributos
		//Cria��o dos jogadores
	private Jogador jogador1 = new Jogador();
	private Jogador jogador2 = new Jogador();
	
		//Cria��o da casa
	private ArrayList<Casa> casas = new ArrayList<Casa>();
	
	//Construtor - default
	public Tabuleiro() {
		
	}
	// Construtor - com argumentos
	public Tabuleiro(ArrayList<Casa>  casas, Jogador jogador1, Jogador jogador2) {
		this.casas = casas;
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}
	// Construtor - c�pia
	public Tabuleiro (Tabuleiro tabuleiro) {
		this.casas = tabuleiro.casas;
		this.jogador1 = tabuleiro.jogador1;
		this.jogador2 = tabuleiro.jogador2;
	}
	// Acessores
	
	public Jogador getJogador1() {
		return jogador1;
	}
	
	public Jogador getJogador2() {
		return jogador2;
	}
	
	public ArrayList<Casa> getCasas() {
		return casas;
	}
	
	
	// Comportamentos
	
	//M�todos Adicionais
	
	//ToString do tabuleiro com as respetivas informa��es
	@Override
	public String toString() {
		return "Tabuleiro [N�mero de casas = " + getCasas() + ", Jogador 1 = " + jogador1 +  ", Jogador 2 = " + jogador2 + "]";
	}
	
	//Clonar o tabuleiro
	public Tabuleiro clone() {
		return new Tabuleiro(this);
	}
	
	//Permite saber se os tabuleiros s�o iguais
	public boolean equals(Tabuleiro tabuleiro) {
		if(tabuleiro == null)
			return false;
		else if (jogador1.equals( tabuleiro.getJogador1() ) || jogador2.equals( tabuleiro.getJogador2() ))
			return true;
		else if (casas.equals( tabuleiro.getCasas() ))
			return true;
		else
			return false;
	}

}
