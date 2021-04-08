
public abstract class Carte {
	private String nom;
	private Categorie categorie;
	
	public abstract void appliqueEffet(Jeu jeu, EtatJoueur etat);
	
	public String toString() {
		return "Carte "+categorie+" : "+nom;
	}
}
