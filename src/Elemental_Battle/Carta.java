package Elemental_Battle;

/**
 * A classe carta tem a caraterização de uma carta padrão do baralho, contendo o
 * seu nome, forca, destreza e capacidade
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

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
	public Carta(String nome, int forca, int destreza, int capacidade) {
		// Validar o nome
		if (nome != null && nome != "")
			this.nome = nome;
		else
			throw new NullPointerException("O nome tem que ser válido");

		// Verificar se a força está no intervalo de 0 a 10
		validarForca(forca);

		// Verificar se a destreza está no intervalo de 0 a 5
		validarDestreza(destreza);

		// Verificar se a capacidade está no intervalo de 0 a 6
		validarCapacidade(capacidade);

	}

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

		// Verificar se a capacidade está no intervalo de 0 a 6
		validarCapacidade(carta.capacidade);

	}

	// Acessores

	/**
	 * Define a força da carta
	 * 
	 * @param forca Força da Carta
	 */
	public void setForca(int forca) {
		this.forca = forca;
	}

	/**
	 * Defome a destreza da carta
	 * 
	 * @param destreza Destreza da carta
	 */
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	/**
	 * Recebe o nome da carta
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
	 * Valida o atributo forca. A forca tem como limite de intervalo entre 0 a 10
	 * 
	 * @param forca Nível de força da carta
	 * 
	 * @throws IllegalArgumentException Se o valor da força for inferior a 0 ou
	 *                                  superior a 10
	 */
	private void validarForca(int forca) {

		if (forca < 0 || forca > 10) {
			throw new IllegalArgumentException("A força tem que estar no intervalo de 0 e entre 10, inclusive");
		} else {
			this.forca = forca;
		}

	}

	/**
	 * Valida o atributo destreza. A destreza tem como limite de intervalo entre 0 a
	 * 5
	 * 
	 * @param destreza Nível de destreza da carta
	 * @throws IllegalArgumentException Se o valor da destreza for inferior a 0 ou
	 *                                  superior a 5
	 */
	private void validarDestreza(int destreza) {

		if (destreza < 0 || destreza > 5) {
			throw new IllegalArgumentException("A destreza tem que estar no intervalo de 0 e entre 5, inclusive");
		} else {
			this.destreza = destreza;
		}

	}

	/**
	 * Valida o atributo capacidade. O tipo de capacidade tem como limite de
	 * intervalo entre 0 a 6
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
	 * Legenda do efeito de cada capacidade úinica, de 0 a 6 Valida o valor da
	 * capacidade
	 * 
	 * @param capacidade Tipo de capacidade da carta
	 * @return Legenda do efeito da respetiva capacidade
	 */
	public String legendaCapacidade(int capacidade) {

		switch (capacidade) {
		case 0:
			return "Sem efeito"; // Legenda da capacidade 0

		case 1:
			return "Ganha 2 de força"; // Legenda da capacidade 1

		case 2:
			return "Ganha 2 de destreza"; // Legenda da capacidade 2

		case 3:
			return "Ganha 2 força e destreza"; // Legenda da capacidade 3

		case 4:
			return "Tira 2 de força ao adversário"; // Legenda da capacidade 4

		case 5:
			return "Tira 2 destreza ao adversário"; // Legenda da capacidade 5

		case 6:
			return "Tira 2 força e destreza ao adversário"; // Legenda da capacidade 6

		default:
			throw new IllegalArgumentException("A capacidade tem que ter um número válido");
		}

	}

	/**
	 * Todos os tipos efeitos que uma carta pode ter, Validação do atributo
	 * capacidade, a carta tem de ter uma capacidade de 0 a 6 inclusive
	 * 
	 * @param cartaJ1 Carta do jogador 1
	 * @param cartaJ2 Carta do jogador 2
	 */
	public void efeitoCapacidade(Carta cartaJ1, Carta cartaJ2) {

		switch (this.capacidade) {
		case 0:

			// Sem efeito

			break;
		case 1:

			// Ganha 2 de força
			cartaJ1.setForca(cartaJ1.getForca() + 2);

			break;
		case 2:
			// Ganha 2 de destreza
			cartaJ1.setDestreza(cartaJ1.getDestreza() + 2);
			break;
		case 3:
			// Ganha 2 força e destreza
			cartaJ1.setDestreza(cartaJ1.getDestreza() + 2);
			cartaJ1.setForca(cartaJ1.getForca() + 2);

			break;
		case 4:
			// Tira 2 de força ao adversário
			cartaJ2.setForca(cartaJ2.getForca() - 2);

			break;
		case 5:
			// Tira 2 destreza ao adversário
			cartaJ2.setDestreza(cartaJ2.getDestreza() - 2);

			break;
		case 6:
			// Tira 2 força e destreza ao adversário
			cartaJ2.setForca(cartaJ2.getForca() - 2);
			cartaJ2.setDestreza(cartaJ2.getDestreza() - 2);

			break;

		default:
			throw new IllegalArgumentException("A capacidade tem que ter um número válido");
		}

	}

	// Métodos Adicionais

	// Print da carta com as suas respetivas características
	@Override
	public String toString() {
		return nome + " | Força: " + forca + " | destreza: " + destreza + " | capacidade: "
				+ legendaCapacidade(capacidade);
	}

}
