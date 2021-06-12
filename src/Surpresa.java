import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

public class Surpresa extends Casa {

	/**
	 * 
	 * @param Surpresa
	 */
	public Surpresa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * 4 b�nus escolhidos � sorte, sendo eles, o jogador receber uma carta, mover a
	 * sua pe�a para a frente, mover a sua pe�a para tr�s, receber ou modificar a
	 * capacidade de uma carta da sua m�o aleat�riamente
	 */
	public void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores) {
		Random rand = new Random();
		int numeroBonus = rand.nextInt(4) + 1;
		int numeroCasas = rand.nextInt(3) + 1;
		int capacidade = rand.nextInt(6);
		int carta = rand.nextInt(jogadores.get(jogador).getMao().size());

		// Recebe Carta
		switch (numeroBonus) {
		case 1: {
			Collections.shuffle(baralho);
			jogadores.get(jogador).getMao().add(baralho.get(1));
			System.out.println(
					"Recebeu a carta: " + jogadores.get(jogador).getCarta(jogadores.get(jogador).getMao().size() - 1));
			JOptionPane.showMessageDialog(null,
					jogadores.get(jogador).getNome() + " recebeu a carta: "
							+ jogadores.get(jogador).getCarta(jogadores.get(jogador).getMao().size()),
					"Casa Surpresa", JOptionPane.INFORMATION_MESSAGE);
			break;
		}

		// Andar x
		case 2: {
			jogadores.get(jogador).setPosicaoJogador(jogadores.get(jogador).getPosicaoJogador() + numeroCasas);
			System.out.println("Casa Surpresa: avan�ou para a casa " + jogadores.get(jogador).getPosicaoJogador());
			JOptionPane.showMessageDialog(null,
					jogadores.get(jogador).getNome() + " avan�ou para casa "
							+ jogadores.get(jogador).getPosicaoJogador(),
					"Casa Surpresa", JOptionPane.INFORMATION_MESSAGE);
			break;
		}

		// Recuar x
		case 3: {
			jogadores.get(jogador).setPosicaoJogador(jogadores.get(jogador).getPosicaoJogador() - numeroCasas);
			System.out.println("Casa Surpresa: recuou para a casa " + jogadores.get(jogador).getPosicaoJogador());
			JOptionPane.showMessageDialog(null,
					jogadores.get(jogador).getNome() + " recuou para casa: "
							+ jogadores.get(jogador).getPosicaoJogador(),
					"Casa Surpresa", JOptionPane.INFORMATION_MESSAGE);
			break;
		}

		// Receber Capacidade
		case 4: {

			jogadores.get(jogador).getMao().get(carta).setCapacidade(capacidade);

			System.out.println("A carta " + jogadores.get(jogador).getMao().get(carta) + " recebeu a capacidade: "
					+ jogadores.get(jogador).getMao().get(carta).legendaCapacidade(capacidade));
			JOptionPane.showMessageDialog(null,
					"A carta " + jogadores.get(jogador).getMao().get(carta).getNome() + " do(a) "
							+ jogadores.get(jogador).getNome() + " recebeu a capacidade: "
							+ jogadores.get(jogador).getMao().get(carta).legendaCapacidade(capacidade),
					"Casa Surpresa", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		default:

			break;

		}

	}
}