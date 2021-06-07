
public class Turno {

	int turno;

	/**
	 * Criar turno
	 */
	public Turno() {
		turno = 1;
	}

	/**
	 * Turnos alternados pelo jogador 1 e jogador 2
	 */
	public void mudancaTurno() {
		if (turno % 2 == 0) {
			System.out.println("Turno do jogador 2");
			turno++;
		} else {
			System.out.println("Turno do jogador 1");
			turno++;
		}
	}
}
