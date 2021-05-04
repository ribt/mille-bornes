package mille_bornes;

public class Main  {

	public static void main(String[] args) {
		Jeu jeu = new Jeu(new Joueur("Ribt"));
		jeu.ajouteJoueurs(new Joueur("Suake"));
		jeu.prepareJeu();
		
		while(!(jeu.estPartieFinie())) {
			jeu.joue();
		}
		
		System.out.println("\nLa partie est finie.\nLe gagnant est : "+jeu.getGagnant());
	}
}
