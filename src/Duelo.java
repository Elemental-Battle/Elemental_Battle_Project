import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Duelo extends Casa {

	/**
	 * Construtor Default
	 */
	public Duelo() {

	}

	/**
	 * 
	 * A classe duelo serve para fazer um combate entre dois jogadores. Esse
	 * resultado pode resultar de uma vit�ria, derrota ou empate. Para descobrirmos
	 * esse resultado, verifica a for�a como priorit�ria, caso ela seja igual, ent�o
	 * verificamos a destreza, caso seja tamb�m igual ent�o resulta num empate.
	 * 
	 * @param jogadores Jogadores
	 */
	public void duelo() {

	}

	@Override
	public void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores) {

		int cartas[] = new int[jogadores.size()];
		// System.out.println("Jogador 1 Escolhe uma carta");
		for (int i = 0; i < jogadores.size(); i++) {
			int carta = 0;
			do {
				cartas[i] = Integer.parseInt(
						JOptionPane.showInputDialog("Escolha a carta do jogador " + jogadores.get(i).getNome())) + 1;
			} while (cartas[i] > jogadores.get(i).getMao().size() || carta < 0);

		}

		for (int i = 0; i < jogadores.size() - 1; i++) {
			if (jogadores.get(i).getCarta(cartas[i]).getForca() > jogadores.get(i + 1).getCarta(cartas[i + 1])
					.getForca()) {
				System.out.println("O jogador " + jogadores.get(i).getNome() + " ganhou ao jogador "
						+ jogadores.get(i + 1).getNome());
				jogadores.get(i).setVitoria(jogadores.get(i).getVitoria() + 1);
				JOptionPane.showMessageDialog(null,
						"O jogador " + jogadores.get(i).getNome() + " ganhou o duelo atrav�s da for�a");

			} else if (jogadores.get(i + 1).getCarta(cartas[i + 1]).getForca() > jogadores.get(i).getCarta(cartas[i])
					.getForca()) {
				System.out.println("O jogador " + jogadores.get(i + 1).getNome() + " ganhou ao jogador "
						+ jogadores.get(i).getNome());
				jogadores.get(i + 1).setVitoria(jogadores.get(i + 1).getVitoria() + 1);

				JOptionPane.showMessageDialog(null,
						"O jogador " + jogadores.get(i + 1).getNome() + " ganhou o duelo atrav�s da for�a");
			} else if (jogadores.get(i).getCarta(cartas[i]).getDestreza() > jogadores.get(i + 1).getCarta(cartas[i + 1])
					.getDestreza()) {
				System.out.println("O jogador " + jogadores.get(i).getNome() + " ganhou ao jogador "
						+ jogadores.get(i + 1).getNome());
				jogadores.get(i).setVitoria(jogadores.get(i).getVitoria() + 1);
				JOptionPane.showMessageDialog(null,
						"O jogador " + jogadores.get(i).getNome() + " ganhou o duelo atrav�s da for�a");

			} else if (jogadores.get(i + 1).getCarta(cartas[i + 1]).getDestreza() > jogadores.get(i).getCarta(cartas[i])
					.getDestreza()) {
				System.out.println("O jogador " + jogadores.get(i + 1).getNome() + " ganhou ao jogador "
						+ jogadores.get(i).getNome());
				jogadores.get(i + 1).setVitoria(jogadores.get(i + 1).getVitoria() + 1);
				JOptionPane.showMessageDialog(null,
						"O jogador " + jogadores.get(i + 1).getNome() + " ganhou o duelo atrav�s da for�a");

			} else {
				System.out.println("Empate");
				JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(i).getNome() + " empatou contra o jogador " + jogadores.get(i+1).getNome());
			}
		}
		for (int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).getMao().remove(cartas[i]);
		}
		
	}

}
