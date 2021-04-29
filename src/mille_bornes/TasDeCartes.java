package mille_bornes;

import java.util.ArrayList;
import java.util.List;

import mille_bornes.cartes.Borne;
import mille_bornes.cartes.Carte;
import mille_bornes.cartes.attaques.Accident;
import mille_bornes.cartes.attaques.Crevaison;
import mille_bornes.cartes.attaques.FeuRouge;
import mille_bornes.cartes.attaques.LimiteVitesse;
import mille_bornes.cartes.attaques.PanneEssence;
import mille_bornes.cartes.parades.Essence;
import mille_bornes.cartes.parades.FeuVert;
import mille_bornes.cartes.parades.FinDeLimite;
import mille_bornes.cartes.parades.Reparations;
import mille_bornes.cartes.parades.RoueDeSecours;

import java.util.Collections;


public class TasDeCartes  {
	private final List<Carte> cartes;

	public TasDeCartes(boolean creerLesCartes) {
		if(creerLesCartes) {
			this.creeLesCartes();
		} else {
			cartes = new ArrayList<>();
		}
	}

	/*
	Ajoute les 110 cartes du Mille-Bornes au tas de cartes.
	4 "botte"
	Attaques :
		5 "feux rouges"
		4 "limite de vitesse
		3 "panne d'essence"
		3 "pneu crevé"
		3 "accident"
	Parades :
		14 "feu vert"
		6 "fin de limite de vitesse"
		6 "essence"
		6 "roue de secours"
		6 "réparations"
	Bornes :
		10 "25"
		10 "50"
		10 "75"
		12 "100"
		4 "200"
	*/
	private void creeLesCartes() {
		for(int i = 0;i < 14; i++) {
			if (i < 3) {
				cartes.add(new PanneEssence());
				cartes.add(new Crevaison());
				cartes.add(new Accident());	
			}
			if (i < 4) {
				cartes.add(new LimiteVitesse());
				cartes.add(new Borne(200));
			}
			if (i < 5) {
				cartes.add(new FeuRouge());
			}
			if (i < 6) {
				cartes.add(new FinDeLimite());
				cartes.add(new Essence());
				cartes.add(new RoueDeSecours());
				cartes.add(new Reparations());
			}
			if (i < 10) {
				cartes.add(new Borne(25));
				cartes.add(new Borne(50));
				cartes.add(new Borne(75));
			}
			if (i < 12) {
				cartes.add(new Borne(100));
			}
			if (i < 14) {
				cartes.add(new FeuVert());
			}
		}
		
	}

	/*
	Mélange le tas de cartes
	
	See Also:
	Collections.shuffle(List)
	*/
	public void melangeCartes() {
		Collections.shuffle(cartes);
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
		return cartes.get(getNbCartes()-1);
	}

	/*
	Tire et retourne la première carte du tas.
	*/
	public Carte prend() {
		// TODO
	}

	/*
	Ajoute une carte au dessus du tas. (Elle devient la première)
	*/
	public void pose(Carte carte) {
		// TODO
	}
}