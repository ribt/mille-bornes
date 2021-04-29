package mille_bornes.cartes.parades;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;
import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Parade;
import mille_bornes.cartes.attaques.FeuRouge;

public class FeuVert extends Parade {

	public FeuVert() {
		super("Feu vert");
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte contre l'attaque spécifiée.
	
	Specified by:
	contre in class Bataille
	Parameters:
	carte - l'attaque à contrer
	*/
	public boolean contre(Attaque carte) {
		return carte instanceof FeuRouge;
	}

	/*
	Description copied from class: Parade
	Si le joueur soufre de l'attaque parée, recouvre l'attaque et annule ses effets.
	
	Overrides:
	appliqueEffet in class Parade
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
