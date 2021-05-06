package mille_bornes;

import java.util.ArrayList;
import java.util.List;

import mille_bornes.cartes.*;
import mille_bornes.cartes.attaques.*;
import mille_bornes.cartes.parades.*;
import java.util.Collections;
import mille_bornes.cartes.bottes.*;

public class TasDeCartes {
	private final List<Carte> cartes;

	public TasDeCartes(boolean creerLesCartes) {
		this.cartes = new ArrayList<Carte>();
		if(creerLesCartes) {
			this.creeLesCartes();
		}
	}

	/*
	Ajoute les 110 cartes du Mille-Bornes au tas de cartes.
	*/
	private void creeLesCartes() {
		// les bornes kilométriques :
		for (int i = 0; i < 10; i++) {
			cartes.add(new Borne(25));
			cartes.add(new Borne(50));
			cartes.add(new Borne(75));
		}
		for (int i = 0; i < 12; i++) {
			cartes.add(new Borne(100));
		}
		for (int i = 0; i < 4; i++) {
			cartes.add(new Borne(200));
		}
		
		// les attaques :
		for (int i = 0; i < 5; i++) {
			cartes.add(new FeuRouge());
		}
		for (int i = 0; i < 4; i++) {
			cartes.add(new LimiteVitesse());
		}
		for (int i = 0; i < 3; i++) {
			cartes.add(new PanneEssence());
			cartes.add(new Crevaison());
			cartes.add(new Accident());
		}
		
		// les parades :
		for (int i = 0; i < 14; i++) {
			cartes.add(new FeuVert());
		}
		for (int i = 0; i < 6; i++) {
			cartes.add(new FinDeLimite());
			cartes.add(new Essence());
			cartes.add(new RoueDeSecours());
			cartes.add(new Reparations());
		}
		
		// les bottes :
		cartes.add(VehiculePrioritaire.unique);
		cartes.add(Citerne.unique);
		cartes.add(Increvable.unique);
		cartes.add(AsDuVolant.unique);
		
	}

	/*
	Mélange le tas de cartes
	
	See Also:
	Collections.shuffle(List)
	*/
	public void melangeCartes() {
		Collections.shuffle(cartes);
	}

	/*
	retourne le nombre de cartes présentes dans le tas.
	*/
	public int getNbCartes() {
		return cartes.size();
	}

	/*
	Teste si le tas est vide.
	*/
	public boolean estVide() {
		return cartes.isEmpty();
	}

	/*
	Montre la première carte du tas, sans la retirer.
	*/
	public Carte regarde() {
		return cartes.get(0);
	}
	/*
	Tire et retourne la première carte du tas.
	*/
	public Carte prend() {
		Carte derniereCarte = cartes.get(0);
		cartes.remove(0);
		return derniereCarte;
	}

	/*
	Ajoute une carte au dessus du tas. (Elle devient la première)
	*/
	public void pose(Carte carte) {
		cartes.add(0, carte);
	}
	
	/*
	 * Fonctions pour tester
	 */
	
	public Carte get(int i) {
		return cartes.get(i);
	}
	
	public String toString() {
		if (cartes.isEmpty()) {
			return null;
		}
		String str = cartes.get(0).nom + ", ";
		for(int i = 1; i<cartes.size()-1; i++) {
			str = str + (cartes.get(i)+", ");
	    }
		str = "Contenu du tas de cartes : " + str + (cartes.get(cartes.size()-1));
		return str;
	}
}
