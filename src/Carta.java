
public class Carta{
	
	//Argumentos
	private String nome; // Nome da carta
	private int forca; // For�a/poder da carta
	private int destreza; //destreza da carta
	private int caracteristica; // n�mero das caracter�sticas da carta
	
	
	// Construtor - com argumentos
	
	public Carta(String nome, int forca, int destreza, int caracteristica) {
		//Validar o nome
		if(nome != null && nome != "")
			this.nome = nome;
		else
			throw new NullPointerException("O nome tem que ser v�lido");
		
		//Verificar se a for�a est� no intervalo de 1 a 5
			validarAtributo(10, this.forca, forca);
		
		//Verificar se a destreza est� no intervalo de 1 a 5
			validarAtributo(5, this.destreza, destreza);
			
		//Verificar se a caracteristica est� no intervalo de 1 a 5		
			validarAtributo(6, this.caracteristica, caracteristica);
	}

	// Construtor - c�pia
	
	public Carta (Carta carta) {
		if(carta == null)
			throw new NullPointerException("A carta � nula, por favor escolha uma v�lida");
		
		//Verificar se a for�a est� no intervalo de 0 a 5
			validarAtributo(10, this.forca, carta.forca);
				
		//Verificar se a destreza est� no intervalo de 0 a 5
			validarAtributo(5, this.destreza, carta.destreza);
				
		//Verificar se a caracteristica est� no intervalo de 1 a 5
			validarAtributo(6, this.caracteristica, carta.caracteristica);
}

	
	// Acessores
	
		//Get caracteristica
	public int getCaracteristica() {
		return caracteristica;
	}
		//Set caracteristica
	public void setCaracteristica(int caracteristica) {
		this.caracteristica = caracteristica;
	}
		//Get for�a
	public int getForca() {
		return forca;
	}

		//Get destreza
	public int getDestreza() {
		return destreza;
	}
	
	
	// Comportamentos
	
	/**
	 * Valida os atributos dados como par�metro. 
	 * 
	 * @param valorMaximo Valor m�ximo que o atributo pode ter
	 * @param atributo Valor do atributo da carta
	 * @param valorAtributo Valor que se quer dar ao atributo
	 * 
	 * @throws IllegalArgumentException Se o valor do atributo for inferior a 0 ou superior a 5
	 */
	private void validarAtributo(int valorMaximo, int atributo, int valorAtributo) {
		if(atributo < 0 || atributo > valorMaximo)
			//Como a for�a est� fora do intervalo, lan�a um erro
			throw new IllegalArgumentException("O atributo tem que estar no intervalo de 0 a " + valorMaximo);
		else
			//Caso contr�rio define a for�a
			this.forca = atributo;
	}
	
	
	// M�todos Adicionais
	
	

	
}
