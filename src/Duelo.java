import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Duelo /* extends CasaDuelo */ {

	// Atributos
//	private Duelo duelo;
//
//	// Construtor - default
//	public Duelo(Duelo duelo) {
//		this.duelo = duelo;
//
//	}
//
//	// Construtor - com argumentos
//	public Duelo(Duelo duelo, Jogador jogador1, Jogador jogador2) {
//		this.duelo = duelo;
//
//	}

	// Construtor - cópia

	// Acessores

	// Comportamentos

	// Métodos Adicionais

	/**
	 * A classe duelo serve para fazer um combate entre dois jogadores. Esse
	 * resultado pode resultar de uma vitória, derrota ou empate. Para descobrirmos
	 * esse resultado, temos definido como parâmetros a força como prioritária, caso
	 * ela seja igual, então verificamos a destreza, caso seja também igual e
	 * nenhuma carta tenha alguma capacidade para modificar os seus atributos (força
	 * ou destreza) então resulta num empate.
	 * 
	 * @param cartaJ1  carta do jogador 1
	 * @param cartaJ2  carta do jogador 2
	 * @param jogador1 jogador 1
	 * @param jogador2 jogador 2
	 */
	public void duelo(int cartaJ1, int cartaJ2, ArrayList<Carta> primeiraMao, ArrayList<Carta> segundaMao) {

		System.out.println("Jogador 1 Escolhe uma carta");
		//JOptionPane.showInputDialog("Escolha a carta do" + jogador1.getNome());
		primeiraMao.get(cartaJ1);
		System.out.println("Jogador 2 Escolhe uma carta");
		segundaMao.get(cartaJ2);

		//Verifica se o Jogador1 ganhou
		if (primeiraMao.get(cartaJ1).getForca() > segundaMao.get(cartaJ2).getForca()) {
			System.out.println("Jogador 1 Ganhou o Duelo");

			//Verifica se o Jogador 2 Ganhou
		} else if (primeiraMao.get(cartaJ1).getForca() < segundaMao.get(cartaJ2).getForca()) {
			System.out.println("Jogador 2 Ganhou o Duelo");
		} else {
			//Verifica se o Jogador 1 tem mais Destreza
			if (primeiraMao.get(cartaJ1).getDestreza() > segundaMao.get(cartaJ2).getDestreza()) {
				System.out.println("Jogador 1 Ganhou o Duelo");

				//Verifica se o Jogador 2 tem mais Destreza
			} else if (primeiraMao.get(cartaJ1).getDestreza() < segundaMao.get(cartaJ2).getDestreza()) {
				System.out.println("Jogador 2 Ganhou o Duelo");
				//Caso contrário empate
			} else {
				System.out.println("Ninguem Ganhou o Duelo");
			}
		}

	}

}
