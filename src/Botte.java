public abstract class Botte extends Carte {

	public Botte(String nom) {
		super(nom, Categorie.BOTTE);
	}

	/*
	Teste si cette carte contre l'attaque spécifiée.
	
	Parameters:
	carte - l'attaque à contrer
	*/
	public abstract boolean contre(Attaque carte);

	/*
	Applique les effets de la carte au joueur cible, et lui transfère le tour de jeu.
	
	Specified by:
	appliqueEffet in class Carte
	Parameters:
	jeu - le jeu
	joueur - le joueur ciblé
	*/
	public abstract void appliqueEffet(Jeu jeu, EtatJoueur joueur);
}
