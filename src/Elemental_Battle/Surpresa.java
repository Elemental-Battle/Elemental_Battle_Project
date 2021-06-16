package Elemental_Battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * A classe Surpresa decide à sorte 4 bónus que o jogador pode receber,  podendo eles beneficiar ou prejudicar o mesmo.
 * 
 * @author Vasco Geada
 * @author Olavo Caxeiro
 *
 */

public class Surpresa extends Casa {

	/**
	 * Construtor default.
	 */
	public Surpresa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * 4 bónus escolhidos à sorte. Sendo eles, o jogador receber uma carta, mover a
	 * sua peça para a frente, mover a sua peça para trás, receber ou modificar a
	 * capacidade de uma carta da sua mão aleatóriamente.
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
							+ jogadores.get(jogador).getCarta(jogadores.get(jogador).getMao().size() - 1),
					"Casa Surpresa", JOptionPane.INFORMATION_MESSAGE);
			break;
		}

		// Andar x
		case 2: {

			int andarCasas = jogadores.get(jogador).getPosicaoJogador() + numeroCasas;
			if (andarCasas > 24) {

//				 Subtrai ao nº de casas a andar com tamanho do tabuleiro + 1. Ex: andarCasas =
//				 18, casas.size() = 14 + 1. andarCasas - (casas.size() + 1) = posicao 2

				jogadores.get(jogador).setPosicaoJogador((andarCasas - 24));
				jogadores.get(jogador).getMao().add(baralho.get(1));
			} else {

				jogadores.get(jogador).setPosicaoJogador(jogadores.get(jogador).getPosicaoJogador() + numeroCasas);
				System.out.println("Casa Surpresa: avançou para a casa " + jogadores.get(jogador).getPosicaoJogador());
				JOptionPane.showMessageDialog(null,
						jogadores.get(jogador).getNome() + " avançou para casa "
								+ jogadores.get(jogador).getPosicaoJogador(),
						"Casa Surpresa", JOptionPane.INFORMATION_MESSAGE);
			}
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

			System.out.println(
					"Casa Surpresa: A carta " + jogadores.get(jogador).getMao().get(carta) + " recebeu a capacidade: "
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
