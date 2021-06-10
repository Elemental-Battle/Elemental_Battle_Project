import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Duelo extends Casa {

// Construtor Default
	public Duelo() {

	}

	/**
	 * Fazer um combate entre dois jogadores. Esse combate pode resultar numa
	 * vit�ria, empate ou derrota. Para descobrirmos esse resultado, verifica-se a
	 * for�a como priorit�ria, caso seja igual, ent�o verificamos como segundo
	 * priorit�rio a destreza, caso seja tamb�m igual, resulta num empate.
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
			System.out.println("");
			System.out.println("M�o do jogador: " + jogadores.get(i).getNome());

			// O jogador escolha uma carta que tenha na sua m�o, caso n�o tenha cartas,
			// recebe 3
			if (jogadores.get(i).getMao().size() > 0) {
				mostrarCartas(jogadores.get(i).getMao());
				do {
					cartas[i] = Integer.parseInt(
							JOptionPane.showInputDialog("Escolha a carta do jogador " + jogadores.get(i).getNome()))
							- 1;

				} while (cartas[i] > jogadores.get(i).getMao().size() - 1 || carta < 0);

			} else {
				recebeCarta(jogadores.get(i), baralho, quantidadeCartas);
				JOptionPane.showMessageDialog(null,
						"O jogador" + jogadores.get(i).getNome() + "recebeu 3 cartas por ter ficado sem m�o");
				mostrarCartas(jogadores.get(i).getMao());
				do {
					cartas[i] = Integer.parseInt(
							JOptionPane.showInputDialog("Escolha a carta do jogador " + jogadores.get(i).getNome()))
							- 1;
				} while (cartas[i] > jogadores.get(i).getMao().size() - 1 || carta < 0);

			}

		}
		for (int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).getCarta(i).efeitoCapacidade(jogadores.get(i).getCarta(i + 1));

		}
		// Vai buscar a carta escolhida de cada jogador e compar�-las e decidir o
		// vencedor duelo de acordo com os par�metros estabelicidos (for�a e destreza)
		for (int i = 0; i < jogadores.size() - 1; i++) {

			if (jogadores.get(i).getCarta(cartas[i]).getForca() > jogadores.get(i + 1).getCarta(cartas[i + 1])
					.getForca()) {
				System.out.println("");
				System.out.println("O jogador " + jogadores.get(i).getNome() + " ganhou ao jogador "
						+ jogadores.get(i + 1).getNome());
				jogadores.get(i).setVitoria(jogadores.get(i).getVitoria() + 1);
				JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(i).getNome()
						+ " ganhou contra o jogador " + jogadores.get(i + 1).getNome() + " atrav�s da for�a");

			} else if (jogadores.get(i + 1).getCarta(cartas[i + 1]).getForca() > jogadores.get(i).getCarta(cartas[i])
					.getForca()) {
				System.out.println("O jogador " + jogadores.get(i + 1).getNome() + " ganhou ao jogador "
						+ jogadores.get(i).getNome());
				jogadores.get(i + 1).setVitoria(jogadores.get(i + 1).getVitoria() + 1);

				JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(i + 1).getNome()
						+ " ganhou contra o jogador " + jogadores.get(i).getNome() + " atrav�s da for�a");
			} else if (jogadores.get(i).getCarta(cartas[i]).getDestreza() > jogadores.get(i + 1).getCarta(cartas[i + 1])
					.getDestreza()) {
				System.out.println("O jogador " + jogadores.get(i).getNome() + " ganhou ao jogador "
						+ jogadores.get(i + 1).getNome());
				jogadores.get(i).setVitoria(jogadores.get(i).getVitoria() + 1);
				JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(i).getNome()
						+ " ganhou contra o jogador " + jogadores.get(i + 1).getNome() + " atrav�s da destreza");

			} else if (jogadores.get(i + 1).getCarta(cartas[i + 1]).getDestreza() > jogadores.get(i).getCarta(cartas[i])
					.getDestreza()) {
				System.out.println("O jogador " + jogadores.get(i + 1).getNome() + " ganhou ao jogador "
						+ jogadores.get(i).getNome());
				jogadores.get(i + 1).setVitoria(jogadores.get(i + 1).getVitoria() + 1);
				JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(i + 1).getNome()
						+ " ganhou contra o jogador " + jogadores.get(i).getNome() + " atrav�s da destreza");

			} else {
				System.out.println("");
				System.out.println("Empate");
				JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(i).getNome()
						+ " empatou contra o jogador " + jogadores.get(i + 1).getNome());
			}
		}

		// Remover as cartas utilizadas pelos jogadores
		for (

				int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).getMao().remove(cartas[i]);
		}

	}

	public void mostrarCartas(ArrayList<Carta> cartas) {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println("Carta " + (1 + i) + ": " + cartas.get(i));
		}
	}

}
