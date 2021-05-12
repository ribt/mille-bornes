package mille_bornes.cartes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;
import mille_bornes.cartes.bottes.VehiculePrioritaire;

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
		if (joueur.getBataille() == null && !joueur.getBottes().contains(VehiculePrioritaire.unique)) {
			throw new IllegalStateException("Impossible de poser une attaque sur un joueur qui n'a pas encore posé de Feu Vert.");
		}
		if (joueur.getBataille() instanceof Attaque) {
			throw new IllegalStateException("Ce joueur est déjà bloqué par une attaque.");
		}
		for (Botte b: joueur.getBottes()) {
			if (b.contre(this)) {
				throw new IllegalStateException("Impossible d'appliquer l'attaque "+this+" sur ce joueur car il est "+b+".");
			}
		}
		joueur.setBataille(this);
		for (Carte c: joueur.getMain()) {
			if (c instanceof Botte && ((Botte) c).contre(this)) {
				joueur.choisitCoupFourre(jeu, this, (Botte) c);
			}
		}
	}
}