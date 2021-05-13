package mille_bornes.cartes.attaques;

import mille_bornes.EtatJoueur;
import mille_bornes.Jeu;
import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Botte;
import mille_bornes.cartes.Carte;

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
		if (joueur.getLimiteVitesse()) {
			throw new IllegalStateException("La vitesse de ce joueur est déjà limitée.");
		}
		else {
			joueur.setLimiteVitesse(true);
		}
		for (Carte c: joueur.getMain()) {
			if (c instanceof Botte && ((Botte) c).contre(this)) {
				joueur.choisitCoupFourre(jeu, this, joueur.getMain().indexOf(c));
				break; // désole pour le break mais sinon c'est ConcurrentModificationException
			}
		}
	}
}
