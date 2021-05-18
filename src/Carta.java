
public class Carta{
	
	//Argumentos
	private String nome; // Nome da carta
	private int forca; // Força/poder da carta
	private int destreza; //destreza da carta
	private int caracteristica; // número das características da carta
	
	
	// Construtor - com argumentos
	
	public Carta(String nome, int forca, int destreza, int caracteristica) {
		//Validar o nome
		if(nome != null && nome != "")
			this.nome = nome;
		else
			throw new NullPointerException("O nome tem que ser válido");
		
		//Verificar se a força está no intervalo de 1 a 5
			validarAtributo(10, this.forca, forca);
		
		//Verificar se a destreza está no intervalo de 1 a 5
			validarAtributo(5, this.destreza, destreza);
			
		//Verificar se a caracteristica está no intervalo de 1 a 5		
			validarAtributo(6, this.caracteristica, caracteristica);
	}

	// Construtor - cópia
	
	public Carta (Carta carta) {
		if(carta == null)
			throw new NullPointerException("A carta é nula, por favor escolha uma válida");
		
		//Verificar se a força está no intervalo de 0 a 5
			validarAtributo(10, this.forca, carta.forca);
				
		//Verificar se a destreza está no intervalo de 0 a 5
			validarAtributo(5, this.destreza, carta.destreza);
				
		//Verificar se a caracteristica está no intervalo de 1 a 5
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
		//Get força
	public int getForca() {
		return forca;
	}

		//Get destreza
	public int getDestreza() {
		return destreza;
	}
	
	
	// Comportamentos
	
	/**
	 * Valida os atributos dados como parâmetro. 
	 * 
	 * @param valorMaximo Valor máximo que o atributo pode ter
	 * @param atributo Valor do atributo da carta
	 * @param valorAtributo Valor que se quer dar ao atributo
	 * 
	 * @throws IllegalArgumentException Se o valor do atributo for inferior a 0 ou superior a 5
	 */
	private void validarAtributo(int valorMaximo, int atributo, int valorAtributo) {
		if(atributo < 0 || atributo > valorMaximo)
			//Como a força está fora do intervalo, lança um erro
			throw new IllegalArgumentException("O atributo tem que estar no intervalo de 0 a " + valorMaximo);
		else
			//Caso contrário define a força
			this.forca = atributo;
	}
	
	
	// Métodos Adicionais
	
	

	
}
