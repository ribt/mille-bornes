package mille_bornes;

import java.util.ArrayList;
import java.util.List;

import mille_bornes.cartes.Carte;

public class TasDeCartes  {
	private final List<Carte> cartes;

	public TasDeCartes(boolean creerLesCartes) {
		if(creerLesCartes) {
			this.cartes = null; // sinon ça compile pas
			this.creeLesCartes();
		} else {
			this.cartes = new ArrayList<Carte>();
		}
	}

	/*
	Ajoute les 110 cartes du Mille-Bornes au tas de cartes.
	*/
	private void creeLesCartes() {
		// TODO
	}

	/*
	Mélange le tas de cartes
	
	See Also:
	Collections.shuffle(List)
	*/
	public void melangeCartes() {
		// TODO
	}

	/*
	retourne le nombre de cartes présentes dans le tas.
	*/
	public int getNbCartes() {
		return cartes.size();
	}

	/*
	Teste si le tas est vide.
	*/
	public boolean estVide() {
		return cartes.isEmpty();
	}

	/*
	Montre la première carte du tas, sans la retirer.
	*/
	public Carte regarde() {
		return cartes.get(0);
	}

	/*
	Tire et retourne la première carte du tas.
	*/
	public Carte prend() {
		return cartes.remove(0);
	}

	/*
	Ajoute une carte au dessus du tas. (Elle devient la première)
	*/
	public void pose(Carte carte) {
		// TODO
	}
}