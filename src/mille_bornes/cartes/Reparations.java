package mille_bornes.cartes;

public class Reparations extends Parade {

	public Reparations() {
		super("Réparations");
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
		return carte instanceof Accident;
	}
}
