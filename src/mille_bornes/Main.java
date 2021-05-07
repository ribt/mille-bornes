package mille_bornes;

import java.util.List;

import mille_bornes.bots.*;

public class Main  {

	public static void main(String[] args) {
		Jeu jeu = new Jeu(new BotDebile(), new BotGentil(), new BotMechant(), new BotMechant());
		jeu.prepareJeu();
		
		while(!(jeu.estPartieFinie())) {
			jeu.joue();
		}
		
		System.out.println("La partie est finie.");
		
		List<Joueur> gagnants = jeu.getGagnant();
		if (gagnants.size() == 1) {
			System.out.println("Le gagnant est "+gagnants.get(0).nom+" !");
		} else {
			System.out.println("Les gagnants ex-aequo sont :");
			for (Joueur j: gagnants) {
				System.out.println("- "+j.nom);
			}
		}
	}
}
