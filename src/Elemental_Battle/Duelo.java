package Elemental_Battle;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *  A classe Duelo consiste em batalhas realizadas com cartas
 *  e a interação entre os jogadores, sendo a eles atribuido tais cartas.
 *  
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

public class Duelo extends Casa {

// Construtor Default
	public Duelo() {

	}

	/**
	 * Fazer um combate entre dois jogadores. Esse combate pode resultar numa
	 * vitória, empate ou derrota. Para descobrirmos esse resultado, verifica-se a
	 * força como prioritária, caso seja igual, então verificamos como segundo
	 * prioritário a destreza, caso seja também igual, resulta num empate.
	 * 
	 * @param jogador   Jogador
	 * @param baralho   Baralho de cartas
	 * @param jogadores Jogadores
	 */
	@Override
	public void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores) {

		String newLine = System.getProperty("line.separator");
		int quantidadeCartas = 3;
		int cartas[] = new int[jogadores.size()];

		// Mostra as cartas do jogador
		for (int i = 0; i < jogadores.size(); i++) {

			int carta = 0;
			System.out.println("");
			System.out.println("Mão do(a) " + jogadores.get(i).getNome());
			System.out.println("");

			if (jogadores.get(i).getMao().size() > 0) {
				mostrarCartas(jogadores.get(i).getMao());
				do {
					cartas[i] = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Número da Carta",
							jogadores.get(i).getNome(), JOptionPane.PLAIN_MESSAGE, null, null, "1")) - 1;

				} while (cartas[i] > jogadores.get(i).getMao().size() - 1 || carta < 0);

				// O jogador escolha uma carta que tenha na sua mão, caso não tenha cartas,
				// recebe 3

			} else {
				recebeCarta(jogadores.get(i), baralho, quantidadeCartas);
				JOptionPane.showMessageDialog(null,
						"O jogador" + jogadores.get(i).getNome() + "recebeu 3 cartas por ter ficado sem mão");
				mostrarCartas(jogadores.get(i).getMao());
				do {
					cartas[i] = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Número da Carta",
							jogadores.get(i).getNome(), JOptionPane.PLAIN_MESSAGE, null, null, "1")) - 1;
				} while (cartas[i] > jogadores.get(i).getMao().size() - 1 || carta < 0);

			}

		}
		System.out.println("");
		if (jogadores.size() < 3) {

			// Sistema de duelo entre 2 jogadores
			for (int i = 0; i < jogadores.size() - 1; i++) {

				if (jogadores.size() < 3)
					verificaDuelo(i, i + 1, cartas, jogadores);
			}

		} else {

			// Sistema de duelo de 2+ jogadores
			for (int i = 0; i < jogadores.size(); i++) {

				// Sistema de duelo de até ao penúltimo jogador

				if (i < jogadores.size() - 1) {
					verificaDuelo(i, i + 1, cartas, jogadores);

					// Sistema de duelo entre o último e primeiro jogador
				} else {
					verificaDuelo(i, 0, cartas, jogadores);
				}
			}
		}
		// Remover as cartas utilizadas pelos jogadores
		for (

				int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).getMao().remove(cartas[i]);
		}
	}

	public void verificaDuelo(int jogador1, int jogador2, int[] cartas, ArrayList<Jogador> jogadores) {

		if (jogadores.get(jogador1).getCarta(cartas[jogador1]).getForca() > jogadores.get(jogador2)
				.getCarta(cartas[jogador2]).getForca()) {
			System.out
					.println(jogadores.get(jogador1).getNome() + " ganhou contra " + jogadores.get(jogador2).getNome());
			jogadores.get(jogador1).setVitoria(jogadores.get(jogador1).getVitoria() + 1);
			JOptionPane.showMessageDialog(null,
					jogadores.get(jogador1).getNome() + " ganhou contra " + jogadores.get(jogador2).getNome(), "Duelo",
					JOptionPane.INFORMATION_MESSAGE);

			// Vitoria do jogador 2 contra o jogador 1 pela forÃ§a
		} else if (jogadores.get(jogador2).getCarta(cartas[jogador2]).getForca() > jogadores.get(jogador1)
				.getCarta(cartas[jogador1]).getForca()) {
			System.out
					.println(jogadores.get(jogador2).getNome() + " ganhou contra " + jogadores.get(jogador1).getNome());
			JOptionPane.showMessageDialog(null,
					jogadores.get(jogador2).getNome() + " ganhou contra " + jogadores.get(jogador1).getNome(), "Duelo",
					JOptionPane.INFORMATION_MESSAGE);
			jogadores.get(jogador2).setVitoria(jogadores.get(jogador2).getVitoria() + 1);

			// Vitoria do jogador 1 contra o jogador 2 pela destreza
		} else if (jogadores.get(jogador1).getCarta(cartas[jogador1]).getDestreza() > jogadores.get(jogador2)
				.getCarta(cartas[jogador2]).getDestreza()) {
			System.out
					.println(jogadores.get(jogador1).getNome() + " ganhou contra " + jogadores.get(jogador2).getNome());
			jogadores.get(jogador1).setVitoria(jogadores.get(jogador1).getVitoria() + 1);
			JOptionPane.showMessageDialog(null,
					jogadores.get(jogador1).getNome() + " ganhou contra " + jogadores.get(jogador2).getNome(), "Duelo",
					JOptionPane.INFORMATION_MESSAGE);

			// Vitoria do jogador 2 contra o jogador 1 pela destreza
		} else if (jogadores.get(jogador2).getCarta(cartas[jogador2]).getDestreza() > jogadores.get(jogador1)
				.getCarta(cartas[jogador1]).getDestreza()) {
			System.out
					.println(jogadores.get(jogador2).getNome() + " ganhou contra " + jogadores.get(jogador1).getNome());
			jogadores.get(jogador2).setVitoria(jogadores.get(jogador2).getVitoria() + 1);
			JOptionPane.showMessageDialog(null,
					jogadores.get(jogador2).getNome() + " ganhou contra " + jogadores.get(jogador1).getNome(), "Duelo",
					JOptionPane.INFORMATION_MESSAGE);

			// Empate entre os jogadores
		} else {

			System.out.println(
					jogadores.get(jogador1).getNome() + " empatou contra " + jogadores.get(jogador2).getNome());
			JOptionPane.showMessageDialog(null,
					jogadores.get(jogador1).getNome() + " empatou contra " + jogadores.get(jogador2).getNome(), "Duelo",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**
	 * Mostra as cartas do jogador
	 * 
	 * @param cartas Cartas de um baralho
	 */
	public void mostrarCartas(ArrayList<Carta> cartas) {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println("Carta " + (1 + i) + ": " + cartas.get(i));
		}
	}

}
