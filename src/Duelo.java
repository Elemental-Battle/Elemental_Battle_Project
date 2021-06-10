import java.util.ArrayList;

import javax.swing.JOptionPane;

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

		int cartas[] = new int[jogadores.size()];

		// O jogador escolha uma carta que tenha na sua mão
		for (int i = 0; i < jogadores.size(); i++) {
			int carta = 0;
			do {
				cartas[i] = Integer.parseInt(
						JOptionPane.showInputDialog("Escolha a carta do jogador " + jogadores.get(i).getNome())) + 1;
			} while (cartas[i] > jogadores.get(i).getMao().size() || carta < 0);

		}

		// Vai buscar a carta escolhida de cada jogador e compará-las e decidir o vencedor duelo de acordo com os parâmetros estabelicidos (força e destreza)
		for (int i = 0; i < jogadores.size() - 1; i++) {
			if (jogadores.get(i).getCarta(cartas[i]).getForca() > jogadores.get(i + 1).getCarta(cartas[i + 1])
					.getForca()) {
				System.out.println("O jogador " + jogadores.get(i).getNome() + " ganhou ao jogador "
						+ jogadores.get(i + 1).getNome());
				jogadores.get(i).setVitoria(jogadores.get(i).getVitoria() + 1);
				JOptionPane.showMessageDialog(null,
						"O jogador " + jogadores.get(i).getNome() + " ganhou o duelo através da força");

			} else if (jogadores.get(i + 1).getCarta(cartas[i + 1]).getForca() > jogadores.get(i).getCarta(cartas[i])
					.getForca()) {
				System.out.println("O jogador " + jogadores.get(i + 1).getNome() + " ganhou ao jogador "
						+ jogadores.get(i).getNome());
				jogadores.get(i + 1).setVitoria(jogadores.get(i + 1).getVitoria() + 1);

				JOptionPane.showMessageDialog(null,
						"O jogador " + jogadores.get(i + 1).getNome() + " ganhou o duelo através da força");
			} else if (jogadores.get(i).getCarta(cartas[i]).getDestreza() > jogadores.get(i + 1).getCarta(cartas[i + 1])
					.getDestreza()) {
				System.out.println("O jogador " + jogadores.get(i).getNome() + " ganhou ao jogador "
						+ jogadores.get(i + 1).getNome());
				jogadores.get(i).setVitoria(jogadores.get(i).getVitoria() + 1);
				JOptionPane.showMessageDialog(null,
						"O jogador " + jogadores.get(i).getNome() + " ganhou o duelo através da força");

			} else if (jogadores.get(i + 1).getCarta(cartas[i + 1]).getDestreza() > jogadores.get(i).getCarta(cartas[i])
					.getDestreza()) {
				System.out.println("O jogador " + jogadores.get(i + 1).getNome() + " ganhou ao jogador "
						+ jogadores.get(i).getNome());
				jogadores.get(i + 1).setVitoria(jogadores.get(i + 1).getVitoria() + 1);
				JOptionPane.showMessageDialog(null,
						"O jogador " + jogadores.get(i + 1).getNome() + " ganhou o duelo através da força");

			} else {
				System.out.println("Empate");
				JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(i).getNome()
						+ " empatou contra o jogador " + jogadores.get(i + 1).getNome());
			}
		}
		
		// Remover as cartas utilizadas pelos jogadores
		for (int i = 0; i < jogadores.size(); i++) {
			jogadores.get(i).getMao().remove(cartas[i]);
		}

	}

}
