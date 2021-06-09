
public class Carta {

	// Atributos
	/**
	 * Inserir as caracter�sticas da carta
	 */
	private String nome; // Nome da carta
	private int forca; // For�a/poder da carta
	

	private int destreza; // destreza da carta
	private int capacidade; // n�mero da capacidade da carta

	// Construtor - com argumentos

	/**
	 * 
	 * Valida��o dos par�metros da carta (nome, forca, destreza e capacidade)
	 * 
	 * @param nome       Nome da carta
	 * @param forca      Poder da carta
	 * @param destreza   Destreza da Carta
	 * @param capacidade Capacidade da carta
	 */
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

	/**
	 * 
	 * @param carta Valida��o dos par�metros da carta (nome, forca, destreza e
	 *              capacidade)
	 */
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
	
	/**
	 * 
	 * @return nome da carta
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * 
	 * @return Vai receber uma capacidade
	 */
	public int getCapacidade() {
		return capacidade;
	}

	/**
	 * 
	 * @param capacidade Vai definir uma capacidade
	 */
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	/**
	 * 
	 * @return Vai receber um n�vel de forca
	 */
	public int getForca() {
		return forca;
	}

	/**
	 * 
	 * @return Vai receber um n�vel de destreza
	 */
	public int getDestreza() {
		return destreza;
	}

	// Comportamentos



	/**
	 * Valida o atributo dado (forca) como par�metro. A for�a tem como limite de
	 * intervalo entre 0 a 10
	 * 
	 * @param forca N�vel de for�a de uma carta
	 * 
	 * @throws IllegalArgumentException Se o valor da for�a for inferior a 0 ou superior a 10
	 */
	private void validarForca(int forca) {

		if (forca < 0 || forca > 10) {
			throw new IllegalArgumentException("A for�a tem que estar no intervalo de 0 e entre 10, inclusive");
		} else {
			this.forca = forca;
		}

	}

	/**
	 * Valida o atributo dado (destreza) como par�metro. A destreza tem como limite
	 * de intervalo entre 0 a 5
	 * 
	 * @param destreza N�vel de destreza de uma carta
	 * @throws IllegalArgumentException Se o valor da destreza for inferior a 0 ou superior a 10
	 */
	private void validarDestreza(int destreza) {

		if (destreza < 0 || destreza > 5) {
			throw new IllegalArgumentException("A destreza tem que estar no intervalo de 0 e entre 5, inclusive");
		} else {
			this.destreza = destreza;
		}

	}

	/**
	 * Valida o atributo dado (capacidade) como par�metro. O tipo de capacidade tem
	 * como limite de intervalo entre 0 a 6
	 * 
	 * @param capacidade Tipo de capacidade de uma carta
	 */
	private void validarCapacidade(int capacidade) {

		if (capacidade < 0 || capacidade > 6) {
			throw new IllegalArgumentException("A capacidade tem que estar no intervalo de 0 e entre 6, inclusive");
		} else {
			this.capacidade = capacidade;
		}

	}

	/**
	 * Legenda do efeito de cada capacidade �inica, de 0 a 6
	 * 
	 * @param capacidade Tipo de capacidade de uma carta
	 * @return Legenda do efeito da respetiva capacidade
	 */
	public String legendaCapacidade(int capacidade) {

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

	/**
	 * Todos os tipos efeitos que uma carta pode ter Valida��o do par�metro
	 * capacidade, a carta tem de ter uma capacidade de 0 a 6
	 * 
	 * @param capacidade Tipo de capacidade de uma carta
	 * @param cartaJ2    Uma carta
	 */
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

	/**
	 * Print da carta com as suas respetivas caracter�sticas
	 */
	@Override
	public String toString() {
		return nome + " | For�a: " + forca + " | destreza: " + destreza + " | capacidade: "
				+ legendaCapacidade(capacidade);
	}

}
