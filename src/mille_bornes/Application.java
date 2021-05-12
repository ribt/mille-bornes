package mille_bornes;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import mille_bornes.bots.*;

public class Application {
	private Scanner sc;
	private Jeu jeu;
	private int nombreJoueurs;
	private int nombreBots;	
	
	public Application() {
		this.sc = new Scanner(System.in);
		this.jeu = new Jeu();
		this.nombreJoueurs = 0;
		this.nombreBots = -1;
	}
	
	public void initialiserPartie() {				
		while (nombreJoueurs <= 1 || nombreJoueurs > 4) {
			nombreJoueurs = demandeInt("À combien voulez-vous jouer ?\n> ");
			if (nombreJoueurs <= 1 || nombreJoueurs > 4) {
					System.out.println("Erreur : Il ne peut y avoir qu'entre 2 et 4 joueurs.");
			}
		}
		
		while (nombreBots < 0 || nombreBots > nombreJoueurs) {
			nombreBots = demandeInt("Combien de bot(s) voulez-vous ? Il peut y en avoir jusqu'à "+nombreJoueurs+".\n> ");
			if (nombreBots < 0 || nombreBots > nombreJoueurs) {
				System.out.println("Il ne peut y en avoir qu'entre 0 et "+nombreJoueurs+" bots.");
			}
		}
		
		System.out.print("Il y a "+nombreJoueurs+" joueurs dont "+nombreBots+" bot");
		if (nombreBots>1) {
			System.out.println("s.");
		} else {
			System.out.println(".");
		}
	}
		
	public void configurerBots() {
		int difficulteBot;
		for (int i = 0; i < nombreBots; i++) {
			difficulteBot = 0;
			while (difficulteBot < 1 || difficulteBot > 3) {
				difficulteBot = demandeInt("Quelle difficulté voulez-vous pour le bot n°"+(i+1)+" ?\n(un chiffre entre 1 et 3)\n> ");
				if (difficulteBot < 1 || difficulteBot > 3) {
					System.out.print("Erreur : Il n'y a que 3 niveaux de difficulté.");
				}
				else {
					switch (difficulteBot) {
					case 1:
						jeu.ajouteJoueurs(new BotDebile());
						break;
					case 2:
						jeu.ajouteJoueurs(new BotGentil());
						break;
					case 3:
						jeu.ajouteJoueurs(new BotMechant());
						break;
					}
				}
			}
		}
	}
	
	public void configurerJoueurs() {
		for (int i = 0; i < (nombreJoueurs - nombreBots); i++) {
			System.out.print("Quelle nom voulez-vous pour le joueur n°"+(i+1)+" ?\n> ");
			jeu.ajouteJoueurs(new Joueur(sc.next()));
		}
	}
	
	public int demandeInt(String question) {
		int nombre;
		while (true) {
			try {
				nombre = 0;
				System.out.print(question);
				nombre = sc.nextInt();
				return nombre;
			} catch (InputMismatchException e) {
				System.out.println("Le chiffre est mal rentré.");
				sc.nextLine();
			}
		}
	}
	
	public void jouer() {
		System.out.println("Bienvenue dans cette nouvelle partie de Mille Bornes\n");
		initialiserPartie();
		configurerBots();
		configurerJoueurs();
		jeu.prepareJeu();
		
		System.out.println("\n----------------------------------- C'est parti ! -----------------------------------\n");
		
		while (!(jeu.estPartieFinie())) {
			jeu.joue();
			System.out.print("----------------------------------- fin de tour -----------------------------------\n\n");
		}
		
		System.out.println("La partie est finie.");
		
		List<Joueur> gagnants = jeu.getGagnant();
		if (gagnants.size() == 1) {
			System.out.println("Le gagnant est "+gagnants.get(0).nom+" !");
		} else {
			System.out.println("Les gagnants ex-aequo sont :");
			for (Joueur j: gagnants) {
				System.out.println("- "+j.nom);
			}
		}
	}
}
