package mille_bornes.cartes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;

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
		// TODO
	}
}
