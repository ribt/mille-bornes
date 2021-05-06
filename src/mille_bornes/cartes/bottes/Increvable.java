package mille_bornes.cartes.bottes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;
import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Botte;
import mille_bornes.cartes.attaques.Crevaison;

public class Increvable extends Botte {
	public static final Increvable unique = new Increvable();

	private Increvable() {
		super("Increvable");
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
		return carte instanceof Crevaison;
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
		jeu.activeProchainJoueurEtTireCarte();
	}
}
