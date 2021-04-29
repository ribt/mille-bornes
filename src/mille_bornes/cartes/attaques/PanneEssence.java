package mille_bornes.cartes.attaques;

import mille_bornes.cartes.Attaque;

public class PanneEssence extends Attaque {

	public PanneEssence() {
		super("Panne d'essance");
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par une Citerne
	
	Overrides:
	estContreeParCiterne in class Bataille
	*/
	public boolean estContreeParCiterne() {
		return true;
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par une Essence
	
	Overrides:
	estContreeParEssence in class Bataille
	*/
	public boolean estContreeParEssence() {
		return true;
	}
}
