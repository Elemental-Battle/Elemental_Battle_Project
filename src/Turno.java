
public class Turno {

	int turno;
	
	public Turno() {
		turno = 1;
	}

	
	public void mudancaTurno() {
		if(turno % 2 == 0) {
			System.out.println("Turno do jogador 2");
			turno++;
		}else {
			System.out.println("Turno do jogador 1");
			turno++;
		}
	}
}
