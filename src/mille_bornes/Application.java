package mille_bornes;

import java.util.Scanner;

import mille_bornes.bots.*;

public class Application {
	public static Jeu getParamJeu() {
		Scanner sc = new Scanner(System.in);
		String input;
		int nombreJoueurs = 0;
		int nombreBots = -1;
		int difficulteBot;
		Jeu jeu = new Jeu();
		
		System.out.print("Bienvenue dans cette nouvelle partie de Mille Bornes\nA combien voulez vous jouer ?\n> ");
		
		while(nombreJoueurs <= 1 || nombreJoueurs > 4) {
			input = sc.next();
			try {
				nombreJoueurs = Integer.valueOf(input);
				if(nombreJoueurs <= 1 || nombreJoueurs > 4) {
					System.out.print("Erreur : Il ne peut y avoir qu'entre 2 et 4 joueurs\n> ");
				}
			} catch(NumberFormatException e) {
				System.out.print("Erreur : Le nombre de joueurs a été mal rentré\n> ");
			}
		}
		
		System.out.print("Combien de bot voulez vous ?\n> ");
		
		while(nombreBots < 0 || nombreBots > nombreJoueurs) {
			input = sc.next();
			try {
				nombreBots = Integer.valueOf(input);
				if(nombreBots < 0 || nombreBots > nombreJoueurs) {
					throw new Exception("Il ne peut y avoir qu'entre 0 et "+nombreJoueurs+" bots\n> ");
				}
			} catch(NumberFormatException e) {
				System.out.print("Erreur : Le nombre de bots a été mal rentré\n> ");
			}catch(Exception e) {
				System.out.print("Erreur : "+e.getMessage());
			}
		}
		
		System.out.print("Il y a "+nombreJoueurs+" joueurs dont "+nombreBots+" bot");
		if(nombreBots>1){
			System.out.println("s");
		} else
			System.out.print("\n");
		
		
		for(int i = 0; i < nombreBots; i++) {
			difficulteBot = 0;
			System.out.println("Quelle difficulté voulez vous pour le bot n°"+(i+1)+" ?\nIl y a 3 Niveaux\n> ");
			while(difficulteBot < 1 || difficulteBot > 3) {
				input = sc.next();
				try {
					difficulteBot = Integer.valueOf(input);
					if(difficulteBot < 1 || difficulteBot > 3) {
						System.out.print("Erreur : Il n'y a que 3 niveaux de difficulté\n> ");
					}
					else {
						System.out.print("Quel nom voulez vous lui donner ?\n> ");
						input = sc.next();
						switch(difficulteBot) {
						case 1:
							jeu.ajouteJoueurs(new BotDebile(input));
							System.out.println("Création d'un bot débile répondant au doux nom de "+input);
							break;
						case 2:
							jeu.ajouteJoueurs(new BotGentil(input));
							System.out.println("Création d'un bot gentil répondant au doux nom de "+input);
							break;
						case 3:
							jeu.ajouteJoueurs(new BotMechant(input));
							System.out.println("Création d'un bot mechant répondant au doux nom de "+input);
							break;
						}
					}
				} catch(NumberFormatException e) {
					System.out.print("Erreur : La difficulté été mal rentré\n> ");
				}
			}
		}
		
		for(int i = 0; i < (nombreJoueurs - nombreBots); i++) {
			System.out.print("Quelle nom voulez vous pour le joueur n°"+(i+1)+" ?\n> ");
			input = sc.next();
			jeu.ajouteJoueurs(new Joueur(input));
		}
		sc.close();
		return jeu;
	}
}
