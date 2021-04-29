package mille_bornes.cartes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;

public abstract class Attaque extends Bataille {

	public Attaque(String nom) {
		super(nom, Categorie.ATTAQUE);
	}

	/*
	Une attaque ne contre aucune carte
	
	Specified by:
	contre in class Bataille
	Parameters:
	carte - inutile
	Returns:
	toujours faux
	*/
	public boolean contre(Attaque carte) {
		return false;
	}

	/*
	Si le joueur cible peut avancer, dépose la carte sur sa pile de bataille.
	
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