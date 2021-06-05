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
	public Duelo() {

	}

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
	public void duelo(ArrayList<Jogador> jogadores) {

		//	System.out.println("Jogador 1 Escolhe uma carta");
			//JOptionPane.showInputDialog("Escolha a carta do" + jogador1.getNome());
		//	primeiraMao.get(cartaJ1);
		//	System.out.println("Jogador 2 Escolhe uma carta");
		//	segundaMao.get(cartaJ2);

			
			//Verifica se o Jogador1 ganhou
			if (jogadores.get(0).getCarta(1).getForca() > jogadores.get(1).getCarta(1).getForca()) {
				System.out.println("Jogador 1 Ganhou o Duelo");
				jogadores.get(0).setVitoria(jogadores.get(0).getVitoria()+ 1);
				
			} else if (jogadores.get(0).getCarta(1).getForca() < jogadores.get(1).getCarta(1).getForca()) {
				System.out.println("Jogador 2 Ganhou o Duelo");
				jogadores.get(1).setVitoria(jogadores.get(1).getVitoria()+ 1);
				
			} else if (jogadores.get(0).getCarta(1).getDestreza() > jogadores.get(1).getCarta(1).getDestreza()) {
					System.out.println("Jogador 1 Ganhou o Duelo");
					jogadores.get(0).setVitoria(jogadores.get(0).getVitoria()+ 1);
					
				} else if (jogadores.get(0).getCarta(1).getDestreza() < jogadores.get(1).getCarta(1).getDestreza()) {
					System.out.println("Jogador 2 Ganhou o Duelo");
					jogadores.get(1).setVitoria(jogadores.get(1).getVitoria()+ 1);
					
				} else {
					System.out.println("Ninguem Ganhou o Duelo");
				}
			}

	}

