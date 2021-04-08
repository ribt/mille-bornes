public abstract class Carte  {
	public final String nom;
	public final Categorie categorie;

	public Carte(String nom, Categorie categorie) {
		// TO DO
	}

	/*
	Applique les effets de la carte au joueur ciblé.
	
	Parameters:
	jeu - le jeu
	joueur - le joueur ciblé
	Throws:
	IllegalStateException - si la carte n'est pas applicable
	*/
	public abstract void appliqueEffet(Jeu jeu, EtatJoueur joueur) throws IllegalStateException {
		// TO DO
	}

	/*
	Décrit la carte.
	
	Overrides:
	toString in class Object
	Returns:
	le nom de la carte
	*/
	public String toString() {
		// TO DO
	}
}
