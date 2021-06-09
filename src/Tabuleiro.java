import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tabuleiro {

	// Criação dos jogadores
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	/**
	 * Criação do tabuleiro
	 */
	private ArrayList<Casa> tabuleiro;
	
	Casa casaBonus = new Bonus();
	
	Casa casaDuelo = new Duelo();


	// Construtor - com argumentos
	/**
	 * Construtor com argumentos, verifica se os jogadores são válidos
	 * 
	 * @param jogadores Jogadores
	 * @throws NullPointerException Caso os jogadores não sejam válidos
	 */
	public Tabuleiro() {
		
		int numeroJogadores = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de jogadores que vão participar "));
		
		for (int i = 0; i < numeroJogadores; i++) {
			Jogador jogador = new Jogador( );
			jogadores.add(jogador);
		}
		
		this.tabuleiro = new ArrayList<Casa>(criarTabuleiro());
	}

	// Construtor - cópia
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
