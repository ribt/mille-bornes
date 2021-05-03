package mille_bornes;

public class TasDeCartes  {
	private final List<Carte> cartes;

	public TasDeCartes(boolean creerLesCartes) {
		if(creerLesCartes) {
			this.creeLesCartes();
		} else {
			this.cartes = new Arraylist<>();
		}
	}

	/*
	Ajoute les 110 cartes du Mille-Bornes au tas de cartes.
	*/
	private void creeLesCartes() {
		// TODO
	}

	/*
	Mélange le tas de cartes
	
	See Also:
	Collections.shuffle(List)
	*/
	public void melangeCartes() {
		// TODO
	}

	/*
	retourne le nombre de cartes présentes dans le tas.
	*/
	public int getNbCartes() {
		// TODO
	}

	/*
	Teste si le tas est vide.
	*/
	public boolean estVide() {
		// TODO
	}

	/*
	Montre la première carte du tas, sans la retirer.
	*/
	public Carte regarde() {
		// TODO
	}

	/*
	Tire et retourne la première carte du tas.
	*/
	public Carte prend() {
		// TODO
	}

	/*
	Ajoute une carte au dessus du tas. (Elle devient la première)
	*/
	public void pose(Carte carte) {
		// TODO
	}
}