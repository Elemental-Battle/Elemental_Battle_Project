package Elemental_Battle;

/**
 * A classe Peca tem como objetivo representar o jogador no tabuleiro, através de uma cor.
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

public class Peca {
	protected String cor;

	/**
	 * Devolve a cor da peça.
	 * 
	 * @return A cor da peça.s
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Define a cor da peça.
	 * 
	 * @param cor Cor da peça.
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	

}
