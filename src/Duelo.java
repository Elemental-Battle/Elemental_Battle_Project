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
	 * resultado pode resultar de uma vitória, derrota ou empate. Para descobrirmos
	 * esse resultado, verifica a força como prioritária, caso ela seja igual, então
	 * verificamos a destreza, caso seja também igual então resulta num empate.
	 * 
	 * @param jogadores Jogadores
	 */
	public void duelo() {

	}

	@Override
	public void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores) {
		int cartaJ1 = 0;
		int cartaJ2 = 0;
		// System.out.println("Jogador 1 Escolhe uma carta");
		for (int i = 0; i < jogadores.size(); i++) {
			int carta = Integer
					.parseInt(JOptionPane.showInputDialog("Escolha a carta do " + jogadores.get(i).getNome()));

			switch (i) {
			case 1: {
				cartaJ1 = carta;
				break;
			}

			case 2: {
				cartaJ2 = carta;
				break;
			}

			}
		}

		// Verifica se o Jogador1 ganhou
		if (jogadores.get(0).getCarta(cartaJ1).getForca() > jogadores.get(1).getCarta(cartaJ2).getForca()) {
			System.out.println("Jogador 1 Ganhou o Duelo");
			jogadores.get(0).setVitoria(jogadores.get(0).getVitoria() + 1);
			JOptionPane.showMessageDialog(null, "Ganhou o jogador " + jogadores.get(0).getNome());

		} else if (jogadores.get(0).getCarta(cartaJ1).getForca() < jogadores.get(1).getCarta(cartaJ2).getForca()) {
			System.out.println("Jogador 2 Ganhou o Duelo");
			jogadores.get(1).setVitoria(jogadores.get(1).getVitoria() + 1);
			JOptionPane.showMessageDialog(null, "Ganhou o jogador " + jogadores.get(1).getNome());

		} else if (jogadores.get(0).getCarta(cartaJ1).getDestreza() > jogadores.get(1).getCarta(cartaJ2)
				.getDestreza()) {
			System.out.println("Jogador 1 Ganhou o Duelo");
			jogadores.get(0).setVitoria(jogadores.get(0).getVitoria() + 1);
			JOptionPane.showMessageDialog(null, "Ganhou o jogador " + jogadores.get(0).getNome());

		} else if (jogadores.get(0).getCarta(cartaJ1).getDestreza() < jogadores.get(1).getCarta(1).getDestreza()) {
			System.out.println("Jogador 2 Ganhou o Duelo");
			jogadores.get(1).setVitoria(jogadores.get(1).getVitoria() + 1);
			JOptionPane.showMessageDialog(null, "Ganhou o jogador " + jogadores.get(0).getNome());

		} else {
			System.out.println("Ninguem Ganhou o Duelo");
		}

	}

}
