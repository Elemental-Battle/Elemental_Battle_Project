import java.util.ArrayList;

public class Baralho {
	
	ArrayList<Carta> cartas = new ArrayList<Carta>();
	
	public static ArrayList<Carta> criarBaralho() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		
			cartas.add(new Carta("Carta de Fogo", 8, 2, 0) );
		
		return cartas;
	}
	
}
