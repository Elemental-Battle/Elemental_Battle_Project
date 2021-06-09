import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

public class Bonus extends Casa {

	/**
	 * 
	 * @param numero ???
	 */
	public Bonus() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Desafio(int jogador, ArrayList<Carta> baralho, ArrayList<Jogador> jogadores) {
		Random rand = new Random();
		int numeroDesafio = rand.nextInt(4) + 1;
		int numeroCasas = rand.nextInt(3) + 1;
		int capacidade = rand.nextInt(6);
		int carta = rand.nextInt(jogadores.get(jogador).getMao().size());
		
		// Recebe Carta
		switch (numeroDesafio) {
		case 1: {
			Collections.shuffle(baralho);
			jogadores.get(jogador).getMao().add(baralho.get(1));
			JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(jogador).getNome()+ " recebeu a carta: " + jogadores.get(jogador).getCarta(jogadores.get(jogador).getMao().size() - 1));
			break;
		}
		// Andar x
		case 2: {
			jogadores.get(jogador).setPosicaoJogador(jogadores.get(jogador).getPosicaoJogador() + numeroCasas);
			JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(jogador).getNome() + " avan�ou para casa " + jogadores.get(jogador).getPosicaoJogador());
			break;
		}

		// Recuar x
		case 3: {
			jogadores.get(jogador).setPosicaoJogador(jogadores.get(jogador).getPosicaoJogador() - numeroCasas);
			JOptionPane.showMessageDialog(null, "O jogador " + jogadores.get(jogador).getNome() + " recuou para casa: " + jogadores.get(jogador).getPosicaoJogador());
			break;
		}

		// Receber Capacidade
		case 4: {

			jogadores.get(jogador).getMao().get(carta).setCapacidade(capacidade);
			
			System.out.println("A carta " + jogadores.get(jogador).getMao().get(carta) + " recebeu a capacidade: "+ jogadores.get(jogador).getMao().get(carta).legendaCapacidade(capacidade));
			JOptionPane.showMessageDialog(null, "A carta " + jogadores.get(jogador).getMao().get(carta).getNome() + " do jogador " + jogadores.get(jogador).getNome() + " recebeu a capacidade " + jogadores.get(jogador).getMao().get(carta).legendaCapacidade(capacidade));
			break;
		}
		default:

			break;

		}
		
	}
}
