package mille_bornes.cartes.bottes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;
import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Botte;

public class AsDuVolant extends Botte {
	public static final AsDuVolant unique = new AsDuVolant();

	private AsDuVolant() {
		super("As du volant");
	}

	/*
	Description copied from class: Botte
	Teste si cette carte contre l'attaque spécifiée.
	
	Specified by:
	contre in class Botte
	Parameters:
	carte - l'attaque à contrer
	*/
	public boolean contre(Attaque carte) {
		return carte.estContreeParAsDuVolant();
	}

	/*
	Description copied from class: Botte
	Applique les effets de la carte au joueur cible, et lui transfère le tour de jeu.
	
	Specified by:
	appliqueEffet in class Botte
	Parameters:
	jeu - le jeu
	joueur - le joueur ciblé
	*/
	public void appliqueEffet(Jeu jeu, EtatJoueur joueur) {
		joueur.addBotte(this);
		if (joueur.getBataille() instanceof Attaque && this.contre((Attaque)joueur.getBataille())) {
			joueur.defausseBataille(jeu);
		}
		jeu.setProchainJoueur(jeu.getJoueurActif());
	}
}
