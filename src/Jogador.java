import java.util.ArrayList;

public class Jogador extends Peca {
	// Atributos


	// Declaração do nome do jogador
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

	// Construtor - cópia
	public Jogador(Jogador jogador) {
		if (jogador.nome != "" || jogador.nome != null)
			this.nome = jogador.nome;
	}

	// Acessores
	public String getNome() {
		return nome;
	}

	// Comportamentos


	// Métodos Adicionais

	// ToString do Jogador com as respetivas informações
	@Override
	public String toString() {
		return "jogador " + getNome().toUpperCase();
	}

	// Clonar o Jogador
	public Jogador clone() {
		return new Jogador(this);
	}

	// Permite saber se os tabuleiros são iguais
	public boolean equals(Jogador jogador) {
		if (jogador == null)
			return false;
		else if (nome.equals(jogador.getNome()))
			return true;
		else
			return false;
	}
}
