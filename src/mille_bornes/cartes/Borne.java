package mille_bornes.cartes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;

public class Borne extends Carte {
	public final int km;

	public Borne(int km) {
		super("Borne de "+km+" km", Categorie.BORNE);
		this.km = km;
	}

	/*
	Ajoute des kilomètres au compteur du joueur.
	
	Specified by:
	appliqueEffet in class Carte
	Parameters:
	jeu - le jeu
	joueur - le joueur
	Throws:
	IllegalStateException - si le joueur est immobilisé
	*/
	public void appliqueEffet(Jeu jeu, EtatJoueur joueur) throws IllegalStateException {	
		joueur.ajouteKm(km);
	}
}