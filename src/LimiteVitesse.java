public class LimiteVitesse extends Attaque {

	public LimiteVitesse() {
		super("Limite de vitesse");
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par une Fin de Limite de Vitesse
	
	Overrides:
	estContreeParFinDeLimite in class Bataille
	*/
	public boolean estContreeParFinDeLimite() {
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

	/*
	Description copied from class: Attaque
	Si le joueur cible peut avancer, dépose la carte sur sa pile de bataille.
	
	Overrides:
	appliqueEffet in class Attaque
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
