package mille_bornes.cartes;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;

public abstract class Bataille extends Carte {

	public Bataille(String nom, Categorie categorie) {
		super(nom, categorie);
	}

	/*
	Teste si cette carte est contrée par un Feu Vert
	*/
	public boolean estContreeParFeuVert() {
		return false;
	}

	/*
	Teste si cette carte est contrée par une Fin de Limite de Vitesse
	*/
	public boolean estContreeParFinDeLimite() {
		return false;
	}

	/*
	Teste si cette carte est contrée par une Essence
	*/
	public boolean estContreeParEssence() {
		return false;
	}

	/*
	Teste si cette carte est contrée par une Roue de Secours
	*/
	public boolean estContreeParRoueDeSecours() {
		return false;
	}

	/*
	Teste si cette carte est contrée par des Réparations
	*/
	public boolean estContreeParReparations() {
		return false;
	}

	/*
	Teste si cette carte est contrée par un Véhicule Prioritaire
	*/
	public boolean estContreeParVehiculePrioritaire() {
		return false;
	}

	/*
	Teste si cette carte est contrée par une Citerne
	*/
	public boolean estContreeParCiterne() {
		return false;
	}

	/*
	Teste si cette carte est contrée par un Increvable
	*/
	public boolean estContreeParIncrevable() {
		return false;
	}

	/*
	Teste si cette carte est contrée par un As du Volant
	*/
	public boolean estContreeParAsDuVolant() {
		return false;
	}

	/*
	Teste si cette carte contre l'attaque spécifiée.
	
	Parameters:
	carte - l'attaque à contrer
	*/
	public abstract boolean contre(Attaque carte);

	/*
	Applique les effets de la carte au joueur cible.
	
	Specified by:
	appliqueEffet in class Carte
	Parameters:
	jeu - le jeu
	joueur - le joueur ciblé
	Throws:
	IllegalStateException - si la carte n'est pas applicable
	*/
	public abstract void appliqueEffet(Jeu jeu, EtatJoueur joueur) throws IllegalStateException;
}