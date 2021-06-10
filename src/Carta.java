
public class Carta {

	// Atributos
	private String nome; // Nome da carta
	private int forca; // Força/poder da carta
	private int destreza; // destreza da carta
	private int capacidade; // número da capacidade da carta
	

	/**
	 * 
	 * Validação dos atributos da carta (nome, forca, destreza e capacidade)
	 * 
	 * @param nome       Nome da carta
	 * @param forca      Poder da carta
	 * @param destreza   Destreza da Carta
	 * @param capacidade Capacidade da carta
	 */
	// Construtor - com argumentos
	public Carta(String nome, int forca, int destreza, int capacidade) {
		// Validar o nome
		if (nome != null && nome != "")
			this.nome = nome;
		else
			throw new NullPointerException("O nome tem que ser válido");

		// Verificar se a força está no intervalo de 0 a 5
		validarForca(forca);

		// Verificar se a destreza está no intervalo de 0 a 5
		validarDestreza(destreza);

		// Verificar se a caracteristica está no intervalo de 1 a 5
		validarCapacidade(capacidade);

	}

	// Construtor - cópia

	/**
	 * Validação dos atributos da carta (nome, forca, destreza e capacidade)
	 * 
	 * @param carta Atibutos da carta
	 *              
	 */
	public Carta(Carta carta) {
		if (carta == null)
			throw new NullPointerException("A carta é nula, por favor escolha uma válida");

		// Verificar se a força está no intervalo de 0 a 10
		validarForca(carta.forca);

		// Verificar se a destreza está no intervalo de 0 a 5
		validarDestreza(carta.destreza);

		// Verificar se a caracteristica está no intervalo de 0 a 6
		validarCapacidade(carta.capacidade);

	}

	// Acessores
	
	/**
	 *  Recebe o nome da carta
	 *  
	 * @return nome da carta
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Recebe a capacidade da carta
	 * 
	 * @return capacidade da carta
	 */
	public int getCapacidade() {
		return capacidade;
	}

	/**
	 * Define a capacidade de uma carta
	 * 
	 * @param capacidade da carta
	 */
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	/**
	 * Recebe a força da carta
	 * 
	 * @return força da carta
	 */
	public int getForca() {
		return forca;
	}

	/**
	 * Recebe a destreza da carta
	 * 
	 * @return destreza da carta
	 */
	public int getDestreza() {
		return destreza;
	}

	// Comportamentos


	/**
	 * Valida o atributo forca. A forca tem como limite de
	 * intervalo entre 0 a 10
	 * 
	 * @param forca Nível de força da carta
	 * 
	 * @throws IllegalArgumentException Se o valor da força for inferior a 0 ou superior a 10
	 */
	private void validarForca(int forca) {

		if (forca < 0 || forca > 10) {
			throw new IllegalArgumentException("A força tem que estar no intervalo de 0 e entre 10, inclusive");
		} else {
			this.forca = forca;
		}

	}

	/**
	 * Valida o atributo destreza. A destreza tem como limite
	 * de intervalo entre 0 a 5
	 * 
	 * @param destreza Nível de destreza da carta
	 * @throws IllegalArgumentException Se o valor da destreza for inferior a 0 ou superior a 5
	 */
	private void validarDestreza(int destreza) {

		if (destreza < 0 || destreza > 5) {
			throw new IllegalArgumentException("A destreza tem que estar no intervalo de 0 e entre 5, inclusive");
		} else {
			this.destreza = destreza;
		}

	}

	/**
	 * Valida o atributo capacidade. O tipo de capacidade tem
	 * como limite de intervalo entre 0 a 6
	 * 
	 * @param capacidade Tipo de capacidade da carta
	 */
	private void validarCapacidade(int capacidade) {

		if (capacidade < 0 || capacidade > 6) {
			throw new IllegalArgumentException("A capacidade tem que estar no intervalo de 0 e entre 6, inclusive");
		} else {
			this.capacidade = capacidade;
		}

	}

	/**
	 * Legenda do efeito de cada capacidade úinica, de 0 a 6
	 * 
	 * @param capacidade Tipo de capacidade da carta
	 * @return Legenda do efeito da respetiva capacidade
	 */
	public String legendaCapacidade(int capacidade) {

		switch (capacidade) {
		case 0:
			return "Sem efeito";

		case 1:
			return "Ganha 2 de força";

		case 2:
			return "Ganha 2 de destreza";

		case 3:
			return "Ganha 2 força e destreza";

		case 4:
			return "Tira 2 de força ao adversário";

		case 5:
			return "Tira 2 destreza ao adversário";

		case 6:
			return "Tira 2 força e destreza ao adversário";

		default:
			throw new IllegalArgumentException("A capacidade tem que ter um número válido");
		}

	}

	/**
	 * Todos os tipos efeitos que uma carta pode ter, Validação do atributo
	 * capacidade, a carta tem de ter uma capacidade de 0 a 6 inclusive
	 * 
	 * @param capacidade Tipo de capacidade da carta
	 * @param cartaJ2    Uma carta
	 */
	private void efeitoCapacidade(int capacidade, Carta cartaJ2) {

		switch (capacidade) {
		case 0:

			break;
		case 1:

			// Ganha 2 de força
			this.forca = forca + 2;

			break;
		case 2:
			// Ganha 2 de destreza
			this.destreza = destreza + 2;

			break;
		case 3:
			// Ganha 2 força e destreza
			this.destreza = destreza + 2;
			this.forca = forca + 2;

			break;
		case 4:
			// Tira 2 de força ao adversário
			cartaJ2.forca = cartaJ2.forca - 2;

			break;
		case 5:
			// Tira 2 destreza ao adversário
			cartaJ2.destreza = cartaJ2.destreza - 2;

			break;
		case 6:
			// Tira 2 força e destreza ao adversário
			cartaJ2.forca = cartaJ2.forca - 2;
			cartaJ2.destreza = cartaJ2.destreza - 2;

			break;

		default:
			throw new IllegalArgumentException("A capacidade tem que ter um número válido");
		}

	}
	
	// Métodos Adicionais


	//Print da carta com as suas respetivas características
	@Override
	public String toString() {
		return nome + " | Força: " + forca + " | destreza: " + destreza + " | capacidade: "
				+ legendaCapacidade(capacidade);
	}

}
