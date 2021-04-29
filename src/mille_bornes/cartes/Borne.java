package mille_bornes.cartes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;

public class Borne extends Carte {
	public final int km;

	public Borne(int _km) {
		super("borne de "+_km+"km", Categorie.BORNE);
		this.km = _km;
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
		if(joueur.ditPourquoiPeutPasAvancer() != null) {
			throw new IllegalStateException("Le joueur est immobilisé");
		}
		else {
			joueur.ajouteKm(km);
		}
	}
}