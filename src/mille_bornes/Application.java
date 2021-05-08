package mille_bornes;

import java.util.InputMismatchException;
import java.util.Scanner;

import mille_bornes.bots.*;

public class Application {
	public static Jeu getParamJeu() {
		Scanner sc = new Scanner(System.in);
		int nombreJoueurs = 0;
		int nombreBots = -1;
		int difficulteBot;
		Jeu jeu = new Jeu();
		
		System.out.print("Bienvenue dans cette nouvelle partie de Mille Bornes\n");
		
		while (nombreJoueurs <= 1 || nombreJoueurs > 4) {
			nombreJoueurs = demandeInt(sc, "À combien voulez-vous jouer ?\n> ");
			if (nombreJoueurs <= 1 || nombreJoueurs > 4) {
					System.out.println("Erreur : Il ne peut y avoir qu'entre 2 et 4 joueurs.");
			}
		}
		
		while (nombreBots < 0 || nombreBots > nombreJoueurs) {
			nombreBots = demandeInt(sc, "Combien de bot voulez-vous ? Il peut en avoir jusqu'à "+nombreJoueurs+".\n> ");
			if (nombreBots < 0 || nombreBots > nombreJoueurs) {
				System.out.println("Il ne peut y avoir qu'entre 0 et "+nombreJoueurs+" bots.");
			}
		}
		
		System.out.print("Il y a "+nombreJoueurs+" joueurs dont "+nombreBots+" bot");
		if (nombreBots>1) {
			System.out.println("s.");
		} else {
			System.out.println(".");
		}
		
		for (int i = 0; i < nombreBots; i++) {
			difficulteBot = 0;
			while (difficulteBot < 1 || difficulteBot > 3) {
				difficulteBot = demandeInt(sc, "Quelle difficulté voulez-vous pour le bot n°"+(i+1)+" ?\nIl y a 3 niveaux entre 1 et 3.\n> ");
				if(difficulteBot < 1 || difficulteBot > 3) {
					System.out.print("Erreur : Il n'y a que 3 niveaux de difficulté.");
				}
				else {
					System.out.print("Quel nom voulez-vous lui donner ?\n> ");
					switch (difficulteBot) {
					case 1:
						jeu.ajouteJoueurs(new BotDebile(sc.next()));
						break;
					case 2:
						jeu.ajouteJoueurs(new BotGentil(sc.next()));
						break;
					case 3:
						jeu.ajouteJoueurs(new BotMechant(sc.next()));
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < (nombreJoueurs - nombreBots); i++) {
			System.out.print("Quelle nom voulez-vous pour le joueur n°"+(i+1)+" ?\n> ");
			jeu.ajouteJoueurs(new Joueur(sc.next()));
		}
		return jeu;
	}
	
	public static int demandeInt(Scanner sc, String question) {
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
}
