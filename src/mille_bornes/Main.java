package mille_bornes;

import java.util.List;

public class Main  {

	public static void main(String[] args) {
		Jeu jeu = new Jeu(new Joueur("humain"), new Bot());
		jeu.prepareJeu();
		
		while(!(jeu.estPartieFinie())) {
			jeu.joue();
		}
		
		System.out.println("\nLa partie est finie.");
		
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
