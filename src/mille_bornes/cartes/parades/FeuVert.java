package mille_bornes.cartes.parades;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;
import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Parade;
import mille_bornes.cartes.attaques.FeuRouge;
import mille_bornes.cartes.bottes.VehiculePrioritaire;

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
		return carte.estContreeParFeuVert();
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
		if (joueur.getBataille() == null) { // la pile est vide, il faut un FeuVert pour commencer
			if (joueur.getBottes().contains(VehiculePrioritaire.unique)) {
				throw new IllegalStateException("Pas besoin de commencer par un feu vert si vous êtes véhicule prioritaire !");
			}
			joueur.setBataille(this);
		}
		else if (joueur.getBataille() instanceof FeuRouge) {
			joueur.setBataille(this);
		}
		else {
			throw new IllegalStateException("Vous ne pouvez pas jouer un feu vert dans cette situation.");
		}
	}
}
