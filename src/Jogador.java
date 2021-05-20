import java.util.ArrayList;

public class Jogador {
	// Atributos

	// Declarar o baralho de cartas
	ArrayList<Carta> cartas = new ArrayList<Carta>();

	// Declara��o do nome do jogador
	private String nome;

	// Construtor - default
	public Jogador() {
		nome = "Jogador";
	}

	// Construtor - com argumentos
	public Jogador(String nome) {
		if (nome != "" || nome != null)
			this.nome = nome;
	}

	// Construtor - c�pia
	public Jogador(Jogador jogador) {
		if (jogador.nome != "" || jogador.nome != null)
			this.nome = jogador.nome;
	}

	// Acessores
	public String getNome() {
		return nome;
	}
	

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	// Comportamentos

	// Esta � uma maneira de criar um baralho de cartas automaticamente, mas n�s
	// optamos por criar as cartas manualmente, assim podemos criar as nossas
	/*
	 * public static ArrayList<Carta> criarBaralho() { ArrayList<Carta> cartas = new
	 * ArrayList<Carta>(); for (int i = 0; i < 3; i++) { cartas.add(new
	 * Carta("Carta " + i, 1 + i, i, i) ); }
	 * 
	 * return cartas; }
	 */

	public void mostrarCartas(ArrayList<Carta> cartas) {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println(cartas.indexOf(i));
		}

	}
	// M�todos Adicionais

	// ToString do Jogador com as respetivas informa��es
	@Override
	public String toString() {
		return "jogador " + getNome().toUpperCase();
	}

	// Clonar o Jogador
	public Jogador clone() {
		return new Jogador(this);
	}

	// Permite saber se os tabuleiros s�o iguais
	public boolean equals(Jogador jogador) {
		if (jogador == null)
			return false;
		else if (nome.equals(jogador.getNome()))
			return true;
		else
			return false;
	}
}
