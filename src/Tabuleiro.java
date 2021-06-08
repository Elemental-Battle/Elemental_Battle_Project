import java.util.ArrayList;

public class Tabuleiro {

	// Cria��o dos jogadores
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	/**
	 * Cria��o do tabuleiro
	 */
	private ArrayList<Casa> tabuleiro = new ArrayList<Casa>();
	
	Casa casaBonus = new Bonus();
	
	Casa casaDuelo = new Duelo();

	// Construtor - default
	/**
	 * Construtor por defeito
	 */
	public Tabuleiro() {
	}

	// Construtor - com argumentos
	/**
	 * Construtor com argumentos, verifica se os jogadores s�o v�lidos
	 * 
	 * @param jogadores Jogadores
	 * @throws NullPointerException Caso os jogadores n�o sejam v�lidos
	 */
	public Tabuleiro(ArrayList<Jogador> jogadores) {
		// Se o tabuleiro for null, ent�o lan�a um erro.
		if (jogadores == null)
			new NullPointerException("Jogadores n�o s�o v�lidos");
		else
			this.jogadores = jogadores;
	}

	// Construtor - c�pia
	/**
	 * ??
	 * 
	 * @param tabuleiro Tabuleiro
	 */
	public Tabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro.tabuleiro;
		this.jogadores = tabuleiro.jogadores;
	}

	// Acessores

	/**
	 * 
	 * @return Jogadores
	 */
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	/**
	 * 
	 * @return Recebe o tamanho do tabuleiro
	 */
	public int getTabuleiroSize() {
		return tabuleiro.size();

	}

	/**
	 * 
	 * @return Recebe o tabuleiro
	 */
	public ArrayList<Casa> getTabuleiro() {
		return tabuleiro;
	}

	// Comportamentos

	/**
	 * 
	 * @return Criar casas para o tabuleiro
	 */
	public static ArrayList<Casa> criarTabuleiro() {
		ArrayList<Casa> casas = new ArrayList<Casa>();
		for (int i = 0; i < 20; i++) {
			casas.add(new Casa() {
				
				@Override
				public void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores) {
					// TODO Auto-generated method stub
					
				}
			});
		}

		return casas;
	}

	/**
	 * Clonar o tabuleiro
	 */
	public Tabuleiro clone() {
		return new Tabuleiro(this);
	}

}
