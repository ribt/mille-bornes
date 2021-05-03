package mille_bornes.cartes;

public class RoueDeSecours extends Parade {

	public RoueDeSecours() {
		super("Roue de secours");
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte contre l'attaque spécifiée.
	
	Specified by:
	contre in class Bataille
	Parameters:
	carte - l'attaque à contrer
	*/
	public boolean contre(Attaque carte) {
		return carte instanceof Crevaison;
	}
}
