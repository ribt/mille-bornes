package mille_bornes;

import java.util.Random;

import mille_bornes.cartes.Carte;

public class Bot extends Joueur {
	private static int compteur = 1;
	private Random rand = new Random();

	public Bot() {
		super("Bot "+compteur);
		compteur++;
	}
	
	@Override
	public int choisitCarte() {
//		int r = rand.nextInt();
//		System.out.println(r+" "+r%15+" "+(r%15-7));
		int choix = rand.nextInt()%8; // entre -7 et 7
		if (choix == 0)
			choix = 1;
		if (choix > 0)
			System.out.println("\nJe joue "+getMain().get(choix-1));
		if (choix < 0)
			System.out.println("\nJe défausse "+getMain().get(-choix-1));
		return choix;
	}
	
	@Override
	public Joueur choisitAdversaire(Carte carte) {
		Joueur choix = this;
		for (int i = 0; i < rand.nextInt()%4 + 1; i++) {
			choix = choix.getProchainJoueur();
		}
		System.out.println("sur "+choix.nom);
		return choix;
	}
}
