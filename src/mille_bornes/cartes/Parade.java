package mille_bornes.cartes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;
import mille_bornes.cartes.bottes.VehiculePrioritaire;

public abstract class Parade extends Bataille {

	public Parade(String nom) {
		super(nom, Categorie.PARADE);
	}

	/*
	Si le joueur soufre de l'attaque parée, recouvre l'attaque et annule ses effets.
	
	Overrides:
	appliqueEffet in class Bataille
	Parameters:
	jeu - le jeu
	joueur - le joueur ciblé
	Throws:
	IllegalStateException - si la carte n'est pas applicable
	*/
	public void appliqueEffet(Jeu jeu, EtatJoueur joueur) throws IllegalStateException {
		if (joueur.getBataille() == null && !joueur.getBottes().contains(VehiculePrioritaire.unique)) {
			throw new IllegalStateException("Vous n'avez toujours pas démarré, il faut commencer par un feu vert");
		}
		if (joueur.getBataille() instanceof Attaque && this.contre((Attaque)joueur.getBataille())) {
			joueur.setBataille(this);
		} else {
			throw new IllegalStateException("Vous ne pouvez pas jouer cette carte.");
		}
	}
}
