package mille_bornes.bots;

import java.util.Random;

import mille_bornes.Jeu;
import mille_bornes.Joueur;
import mille_bornes.cartes.Attaque;

public abstract class Bot extends Joueur {
	protected Random rand = new Random();

	public Bot(String nom) {
		super(nom);
	}
	
	@Override
	public abstract int choisitCarte();
	
	@Override
	public abstract Joueur choisitAdversaire(Attaque carte);
	
	@Override
	public void joueCarte(Jeu jeu, int numero) {
		System.out.println("\nJe joue "+getMain().get(numero)+".");
		super.joueCarte(jeu, numero);
	}
	
	@Override
	public void joueCarte(Jeu jeu, int numero, Joueur adversaire) {
		System.out.println("\nJ'attaque "+adversaire.nom+" avec "+getMain().get(numero)+".");
		super.joueCarte(jeu, numero, adversaire);
	}
	
	@Override
	public void defausseCarte(Jeu jeu, int numero) {
		System.out.println("\nJe défausse "+getMain().get(numero)+".");
		super.defausseCarte(jeu, numero);
	}
	
	@Override
	public void choisitCoupFourre(Jeu jeu, Attaque attaque, int numero) {
		System.out.print("---------------------------------- Coup fourré ! ----------------------------------");
		joueCarte(jeu, numero);
		prendCarte(jeu.pioche());
		jeu.setProchainJoueur(this);
	}
}
