package mille_bornes;

public class Main  {

	public static void main(String[] args) {
		Jeu jeu = new Jeu(new Joueur("Ribt"));
		jeu.ajouteJoueurs(new Joueur("Suake"));
		jeu.prepareJeu();
		System.out.println(jeu);
	}
}
