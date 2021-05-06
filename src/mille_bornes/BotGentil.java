package mille_bornes;

import java.util.List;

import mille_bornes.cartes.*;
import mille_bornes.cartes.bottes.VehiculePrioritaire;
import mille_bornes.cartes.parades.FeuVert;
import mille_bornes.cartes.parades.FinDeLimite;

public class BotGentil extends Bot {

	public BotGentil() {
		super("Bot gentil");
	}
	
	public int choisitCarte() {
		List<Carte> main = getMain();
		Carte carte;
		Borne borneMax = new Borne(0);
		
		for (int i=0; i < main.size(); i++) {
			carte = main.get(i);
			if (carte instanceof Botte)
				return i+1;
			if (getBataille() == null && !getBottes().contains(VehiculePrioritaire.unique) && carte instanceof FeuVert)
				return i+1;
			if (getLimiteVitesse() && carte instanceof FinDeLimite)
				return i+1;
			if (getBataille() instanceof Attaque && carte instanceof Parade && ((Parade) carte).contre((Attaque) getBataille()))
				return i+1;
			if (carte instanceof Borne) {
				if (((Borne) carte).km > borneMax.km && getKm()+((Borne) carte).km <= 1000 && (!getLimiteVitesse() || ((Borne) carte).km <= 50)) {
					borneMax = (Borne)carte;
				}
			}
		}
		
		if (ditPourquoiPeutPasAvancer() == null && borneMax.km > 0) {
			return main.indexOf(borneMax) + 1;
		}
		
		for (int i=0; i < main.size(); i++) {
			carte = main.get(i);
			if (carte instanceof Borne && getKm()+((Borne) carte).km > 1000)
				return -i-1;
			if (carte instanceof Parade || carte instanceof Attaque)
				return -i-1;
			if (carte instanceof Borne && ((Borne) carte).km <= 50 && !getLimiteVitesse())
				return -i-1;
		}
		
		return -1;
	}
	
	public Joueur choisitAdversaire(Carte carte) {
		Joueur choix = this;
		for (int i = 0; i < rand.nextInt()%4 + 1; i++) {
			choix = choix.getProchainJoueur();
		}
		System.out.println("sur "+choix.nom);
		return choix;
	}

}
