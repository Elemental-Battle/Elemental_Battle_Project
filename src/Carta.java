
public class Carta {

	// Argumentos
	private String nome; // Nome da carta
	private int forca; // For�a/poder da carta
	private int destreza; // destreza da carta
	private int caracteristica; // n�mero das caracter�sticas da carta

	// Construtor - com argumentos

	public Carta(String nome, int forca, int destreza, int caracteristica) {
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
		validarCaracteristica(caracteristica);
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
		validarCaracteristica(carta.caracteristica);
	}

	// Acessores

	// Get caracteristica
	public int getCaracteristica() {
		return caracteristica;
	}

	// Set caracteristica
	public void setCaracteristica(int caracteristica) {
		this.caracteristica = caracteristica;
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
		
		 if(forca < 0 || forca > 10) {
			 throw new IllegalArgumentException("A for�a tem que estar no intervalo de 0 e entre 10, inclusive");
		 }
		 else {
			 this.forca = forca;
		 }
		 
	}
	
	private void validarDestreza(int destreza) {
		
		 if(destreza < 0 || destreza > 5) {
			 throw new IllegalArgumentException("A destreza tem que estar no intervalo de 0 e entre 5, inclusive");
		 }
		 else {
			 this.destreza = destreza;
		 }
		 
	}
	
	private void validarCaracteristica(int caracteristica) {
		
		 if(caracteristica < 0 || caracteristica > 6) {
			 throw new IllegalArgumentException("A caracteristica tem que estar no intervalo de 0 e entre 6, inclusive");
		 }
		 else {
			 this.caracteristica = caracteristica;
		 }
		 
	}

	// M�todos Adicionais

	@Override
	public String toString() {
		return "Nome da Carta " + nome + ", forca=" + forca + ", destreza=" + destreza + ", caracteristica="
				+ caracteristica + "]";
	}

}
