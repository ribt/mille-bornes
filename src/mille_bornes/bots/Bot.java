package mille_bornes.bots;

import java.util.Random;

import mille_bornes.Jeu;
import mille_bornes.Joueur;
import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Botte;

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
		System.out.println("\nJe joue "+getMain().get(numero)+" sur "+adversaire.nom+".");
		super.joueCarte(jeu, numero, adversaire);
	}
	
	@Override
	public void defausseCarte(Jeu jeu, int numero) {
		System.out.println("\nJe défausse "+getMain().get(numero)+".");
		super.defausseCarte(jeu, numero);
	}
	
	@Override
	public void choisitCoupFourre(Jeu jeu, Attaque carte, Botte botte) {
		joueCarte(jeu, getMain().indexOf(botte));
		getMain().add(jeu.pioche());
		jeu.setProchainJoueur(this);
	}
}
