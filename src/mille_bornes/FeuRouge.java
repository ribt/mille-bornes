package mille_bornes;

import mille_bornes.cartes.Attaque;

public class FeuRouge extends Attaque {

	public FeuRouge() {
		super("Feu Rouge");
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par un Feu Vert
	
	Overrides:
	estContreeParFeuVert in class Bataille
	*/
	public boolean estContreeParFeuVert() {
		return true;
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par un Véhicule Prioritaire
	
	Overrides:
	estContreeParVehiculePrioritaire in class Bataille
	*/
	public boolean estContreeParVehiculePrioritaire() {
		return true;
	}
}
