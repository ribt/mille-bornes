package mille_bornes.bots;

import java.util.List;

import mille_bornes.Joueur;
import mille_bornes.cartes.*;
import mille_bornes.cartes.attaques.LimiteVitesse;
import mille_bornes.cartes.bottes.VehiculePrioritaire;
import mille_bornes.cartes.parades.FeuVert;
import mille_bornes.cartes.parades.FinDeLimite;

public class BotMechant extends Bot {

	public BotMechant() {
		super("Bot méchant");
	}
	
	@Override
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
			if (carte instanceof Attaque && choisitAdversaire((Attaque) carte) != null)
				return i+1;
		}
		
		if (ditPourquoiPeutPasAvancer() == null && borneMax.km > 0) {
			return main.indexOf(borneMax) + 1;
		}
		
		return -pireCarte();
	}
	
	@Override
	public Joueur choisitAdversaire(Attaque carte) {
		Joueur test = this.getProchainJoueur();
		Joueur choix = null;
		boolean protege;
		
		while (test != this) {
			protege = false;
			for (Botte b: test.getBottes()) {
				if (b.contre(carte)) {
					protege = true;
				}
			}
			if (!protege && test.getBataille() instanceof Parade
					&& (!(carte instanceof LimiteVitesse) || !test.getLimiteVitesse())
					&& (choix == null || test.getKm() > choix.getKm())) {
				choix = test;
			}
			test = test.getProchainJoueur();
		}
		
		if (choix != null)
			System.out.println("sur "+choix.nom);
		return choix;
	}
	
	public int pireCarte() {
		List<Carte> main = getMain();
		Carte carte;
		
		for (int i=0; i < main.size(); i++) {
			carte = main.get(i);
			if (carte instanceof Borne && getKm()+((Borne) carte).km > 1000)
				return i+1;
			if (carte instanceof Parade || carte instanceof Attaque)
				return i+1;
			if (carte instanceof Borne && ((Borne) carte).km <= 50 && !getLimiteVitesse())
				return i+1;
		}
		
		return 1;
	}

}
