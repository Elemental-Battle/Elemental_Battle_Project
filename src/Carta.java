
public class Carta {

	// Argumentos
	private String nome; // Nome da carta
	private int forca; // For�a/poder da carta
	private int destreza; // destreza da carta
	private int capacidade; // n�mero da capacidade da carta

	// Construtor - com argumentos

	public Carta(String nome, int forca, int destreza, int capacidade) {
		// Validar o nome
		if (nome != null && nome != "")
			this.nome = nome;
		else
			throw new NullPointerException("O nome tem que ser v�lido");

		// Verificar se a for�a est� no intervalo de 0 a 5
		validarForca(forca);

		// Verificar se a destreza est� no intervalo de 0 a 5
		validarDestreza(destreza);

		// Verificar se a caracteristica est� no intervalo de 1 a 5
		validarCapacidade(capacidade);

	}

	// Construtor - c�pia

	public Carta(Carta carta) {
		if (carta == null)
			throw new NullPointerException("A carta � nula, por favor escolha uma v�lida");

		// Verificar se a for�a est� no intervalo de 0 a 5
		validarForca(carta.forca);

		// Verificar se a destreza est� no intervalo de 0 a 5
		validarDestreza(carta.destreza);

		// Verificar se a caracteristica est� no intervalo de 1 a 5
		validarCapacidade(carta.capacidade);

	}

	// Acessores

	// Get caracteristica
	public int getCapacidade() {
		return capacidade;
	}

	// Set caracteristica
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	// Get for�a
	public int getForca() {
		return forca;
	}

	// Get destreza
	public int getDestreza() {
		return destreza;
	}

	// Comportamentos

	/**
	 * Valida os atributos dados como par�metro.
	 * 
	 * @param valorMaximo   Valor m�ximo que o atributo pode ter
	 * @param atributo      Valor do atributo da carta
	 * @param valorAtributo Valor que se quer dar ao atributo
	 * 
	 * @throws IllegalArgumentException Se o valor do atributo for inferior a 0 ou
	 *                                  superior a 5
	 */
	private void validarForca(int forca) {

		if (forca < 0 || forca > 10) {
			throw new IllegalArgumentException("A for�a tem que estar no intervalo de 0 e entre 10, inclusive");
		} else {
			this.forca = forca;
		}

	}

	private void validarDestreza(int destreza) {

		if (destreza < 0 || destreza > 5) {
			throw new IllegalArgumentException("A destreza tem que estar no intervalo de 0 e entre 5, inclusive");
		} else {
			this.destreza = destreza;
		}

	}

	private void validarCapacidade(int capacidade) {

		if (capacidade < 0 || capacidade > 6) {
			throw new IllegalArgumentException("A capacidade tem que estar no intervalo de 0 e entre 6, inclusive");
		} else {
			this.capacidade = capacidade;
		}

	}

	private String legendaCapacidade(int capacidade) {

		switch (capacidade) {
		case 0:
			return "Sem efeito";

		case 1:
			return "Ganha 2 de for�a";

		case 2:
			return "Ganha 2 de destreza";

		case 3:
			return "Ganha 2 for�a e destreza";

		case 4:
			return "Tira 2 de for�a ao advers�rio";

		case 5:
			return "Tira 2 destreza ao advers�rio";

		case 6:
			return "Tira 2 for�a e destreza ao advers�rio";

		default:
			throw new IllegalArgumentException("A capacidade tem que ter um n�mero v�lido");
		}

	}

	private void efeitoCapacidade(int capacidade, Carta cartaJ2) {

		switch (capacidade) {
		case 0:

			break;
		case 1:

			// Ganha 2 de for�a
			this.forca = forca + 2;

			break;
		case 2:
			// Ganha 2 de destreza
			this.destreza = destreza + 2;

			break;
		case 3:
			// Ganha 2 for�a e destreza
			this.destreza = destreza + 2;
			this.forca = forca + 2;

			break;
		case 4:
			// Tira 2 de for�a ao advers�rio
			cartaJ2.forca = cartaJ2.forca - 2;

			break;
		case 5:
			// Tira 2 destreza ao advers�rio
			cartaJ2.destreza = cartaJ2.destreza - 2;

			break;
		case 6:
			// Tira 2 for�a e destreza ao advers�rio
			cartaJ2.forca = cartaJ2.forca - 2;
			cartaJ2.destreza = cartaJ2.destreza - 2;

			break;

		default:
			throw new IllegalArgumentException("A capacidade tem que ter um n�mero v�lido");
		}

	}
	// M�todos Adicionais

	@Override
	public String toString() {
		return nome + " | For�a: " + forca + " | destreza: " + destreza + " | capacidade: "
				+ legendaCapacidade(capacidade);
	}

}
