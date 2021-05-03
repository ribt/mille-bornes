package mille_bornes;

import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Botte;

public class AsDuVolant extends Botte {
	public static final AsDuVolant unique;

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
		return carte instanceof Accident;
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
		// TODO
	}
}
