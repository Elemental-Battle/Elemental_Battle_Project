package Elemental_Battle;

/**
 * A classe carta tem a carateriza��o de uma carta padr�o do baralho, contendo o
 * seu nome, forca, destreza e capacidade
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

public class Carta {

	// Atributos
	private String nome; // Nome da carta
	private int forca; // For�a/poder da carta
	private int destreza; // destreza da carta
	private int capacidade; // n�mero da capacidade da carta

	/**
	 * 
	 * Valida��o dos atributos da carta (nome, forca, destreza e capacidade)
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

		// Verificar se a for�a est� no intervalo de 0 a 10
		validarForca(forca);

		// Verificar se a destreza est� no intervalo de 0 a 5
		validarDestreza(destreza);

		// Verificar se a capacidade est� no intervalo de 0 a 6
		validarCapacidade(capacidade);

	}

	/**
	 * Valida��o dos atributos da carta (nome, forca, destreza e capacidade)
	 * 
	 * @param carta Atibutos da carta
	 * 
	 */
	public Carta(Carta carta) {
		if (carta == null)
			throw new NullPointerException("A carta � nula, por favor escolha uma v�lida");

		// Verificar se a for�a est� no intervalo de 0 a 10
		validarForca(carta.forca);

		// Verificar se a destreza est� no intervalo de 0 a 5
		validarDestreza(carta.destreza);

		// Verificar se a capacidade est� no intervalo de 0 a 6
		validarCapacidade(carta.capacidade);

	}

	// Acessores

	/**
	 * Define a for�a da carta
	 * 
	 * @param forca For�a da Carta
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
	 * Recebe a for�a da carta
	 * 
	 * @return for�a da carta
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
	 * @param forca N�vel de for�a da carta
	 * 
	 * @throws IllegalArgumentException Se o valor da for�a for inferior a 0 ou
	 *                                  superior a 10
	 */
	private void validarForca(int forca) {

		if (forca < 0 || forca > 10) {
			throw new IllegalArgumentException("A for�a tem que estar no intervalo de 0 e entre 10, inclusive");
		} else {
			this.forca = forca;
		}

	}

	/**
	 * Valida o atributo destreza. A destreza tem como limite de intervalo entre 0 a
	 * 5
	 * 
	 * @param destreza N�vel de destreza da carta
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
	 * Legenda do efeito de cada capacidade �inica, de 0 a 6 Valida o valor da
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
			return "Ganha 2 de for�a"; // Legenda da capacidade 1

		case 2:
			return "Ganha 2 de destreza"; // Legenda da capacidade 2

		case 3:
			return "Ganha 2 for�a e destreza"; // Legenda da capacidade 3

		case 4:
			return "Tira 2 de for�a ao advers�rio"; // Legenda da capacidade 4

		case 5:
			return "Tira 2 destreza ao advers�rio"; // Legenda da capacidade 5

		case 6:
			return "Tira 2 for�a e destreza ao advers�rio"; // Legenda da capacidade 6

		default:
			throw new IllegalArgumentException("A capacidade tem que ter um n�mero v�lido");
		}

	}

	/**
	 * Todos os tipos efeitos que uma carta pode ter, Valida��o do atributo
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

			// Ganha 2 de for�a
			cartaJ1.setForca(cartaJ1.getForca() + 2);

			break;
		case 2:
			// Ganha 2 de destreza
			cartaJ1.setDestreza(cartaJ1.getDestreza() + 2);
			break;
		case 3:
			// Ganha 2 for�a e destreza
			cartaJ1.setDestreza(cartaJ1.getDestreza() + 2);
			cartaJ1.setForca(cartaJ1.getForca() + 2);

			break;
		case 4:
			// Tira 2 de for�a ao advers�rio
			cartaJ2.setForca(cartaJ2.getForca() - 2);

			break;
		case 5:
			// Tira 2 destreza ao advers�rio
			cartaJ2.setDestreza(cartaJ2.getDestreza() - 2);

			break;
		case 6:
			// Tira 2 for�a e destreza ao advers�rio
			cartaJ2.setForca(cartaJ2.getForca() - 2);
			cartaJ2.setDestreza(cartaJ2.getDestreza() - 2);

			break;

		default:
			throw new IllegalArgumentException("A capacidade tem que ter um n�mero v�lido");
		}

	}

	// M�todos Adicionais

	// Print da carta com as suas respetivas caracter�sticas
	@Override
	public String toString() {
		return nome + " | For�a: " + forca + " | destreza: " + destreza + " | capacidade: "
				+ legendaCapacidade(capacidade);
	}

}
