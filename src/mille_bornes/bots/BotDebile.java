package mille_bornes.bots;

import mille_bornes.Joueur;
import mille_bornes.cartes.Carte;

public class BotDebile extends Bot {

	public BotDebile() {
		super("Bot débile");
	}

	@Override
	public int choisitCarte() {
		return rand.nextInt()%8;
	}

	@Override
	public Joueur choisitAdversaire(Carte carte) {
		Joueur choix = this.getProchainJoueur();
		while (choix == this || rand.nextFloat() > 0.5) {
			choix = choix.getProchainJoueur();
		}
		System.out.println("sur "+choix.nom);
		return choix;
	}

}
