public abstract class Bataille extends Carte {

	public Bataille(String nom, Categorie categorie) {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par un Feu Vert
	*/
	public boolean estContreeParFeuVert() {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par une Fin de Limite de Vitesse
	*/
	public boolean estContreeParFinDeLimite() {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par une Essence
	*/
	public boolean estContreeParEssence() {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par une Roue de Secours
	*/
	public boolean estContreeParRoueDeSecours() {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par des Réparations
	*/
	public boolean estContreeParReparations() {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par un Véhicule Prioritaire
	*/
	public boolean estContreeParVehiculePrioritaire() {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par une Citerne
	*/
	public boolean estContreeParCiterne() {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par un Increvable
	*/
	public boolean estContreeParIncrevable() {
		// TO DO
	}

	/*
	Teste si cette carte est contrée par un As du Volant
	*/
	public boolean estContreeParAsDuVolant() {
		// TO DO
	}

	/*
	Teste si cette carte contre l'attaque spécifiée.
	
	Parameters:
	carte - l'attaque à contrer
	*/
	public abstract boolean contre(Attaque carte) {
		// TO DO
	}

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
	public void appliqueEffet(Jeu jeu, EtatJoueur joueur) throws IllegalStateException {
		// TO DO
	}
}
