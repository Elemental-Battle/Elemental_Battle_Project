import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Baralho {

	/*
	 * Cria��o de cartas
	 */
	ArrayList<Carta> elementals = new ArrayList<Carta>();

	/**
	 * 
	 * @param baralho Cria��o de um set de 30 cartas
	 */
	public void criarBaralho1(ArrayList<Carta> baralho) {
		baralho.add(new Carta("Water Elemental", 10, 5, 6));
		baralho.add(new Carta("Fire Elemental", 10, 5, 3));
		baralho.add(new Carta("Earth Elemental", 10, 5, 4));
		baralho.add(new Carta("Air Elemental", 10, 5, 1));
		baralho.add(new Carta("Water Bender", 5, 5, 2));
		baralho.add(new Carta("Fire Bender", 5, 5, 5));
		baralho.add(new Carta("Earth Bender", 5, 5, 4));
		baralho.add(new Carta("Air Bender", 5, 5, 1));
		baralho.add(new Carta("Emperor", 4, 5, 2));
		baralho.add(new Carta("Archmage", 4, 4, 5));
		baralho.add(new Carta("Hell", 4, 5, 1));
		baralho.add(new Carta("Murlock", 1, 5, 3));
		baralho.add(new Carta("Storm", 3, 5, 0));
		baralho.add(new Carta("Bloodmage", 3, 2, 0));
		baralho.add(new Carta("Doctor Boom", 3, 4, 0));
		baralho.add(new Carta("Windrunner", 3, 1, 0));
		baralho.add(new Carta("Cursed Blade", 1, 1, 0));
		baralho.add(new Carta("Magma Rager", 1, 2, 0));
		baralho.add(new Carta("Azure Drake", 1, 4, 0));
		baralho.add(new Carta("Angry Chicken", 6, 5, 0));
		baralho.add(new Carta("Faceless", 7, 4, 0));
		baralho.add(new Carta("Reksai", 7, 5, 0));
		baralho.add(new Carta("Yasuo", 7, 1, 0));
		baralho.add(new Carta("Razorpetal", 7, 3, 0));
		baralho.add(new Carta("Safari", 8, 5, 0));
		baralho.add(new Carta("Death", 8, 3, 0));
		baralho.add(new Carta("Brook", 8, 1, 0));
		baralho.add(new Carta("Zed", 9, 2, 6));
		baralho.add(new Carta("The Lich King", 9, 5, 5));
		baralho.add(new Carta("God King", 9, 3, 2));
	}

	/**
	 * Devolve o baralho Elementals
	 * 
	 * @return As cartas do set "elementals"
	 */
	public ArrayList<Carta> getElementals() {
		return elementals;
	}

	/**
	 * Cria��o de um baralho com um set de 30 cartas
	 */
	public Baralho() {
		criarBaralho1(elementals);

	}

	
}