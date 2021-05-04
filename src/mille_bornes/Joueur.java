package mille_bornes;

import java.util.*;

import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Bataille;
import mille_bornes.cartes.Botte;
import mille_bornes.cartes.Carte;

public class Joueur  {
	public final String nom;
	private final EtatJoueur etat;
	private final Scanner input;
	private Joueur prochainJoueur;

	public Joueur(String nom) {
		this.nom = nom;
		this.etat = new EtatJoueur(this);
		this.input = new Scanner(System.in);
	}

	/*
	Récupère le prochain joueur
	*/
	public Joueur getProchainJoueur() {
		return prochainJoueur;
	}

	/*
	Règle le prochain joueur : définit la position autour de la table...
	*/
	public void setProchainJoueur(Joueur j) {
		this.prochainJoueur = j;
	}

	/*
	Retourne une copie non modifiable de la main
	*/
	public List<Carte> getMain() {
		return etat.getMain();
	}

	/*
	Retourne le nombre de kilomètres parcourus par le joueur
	*/
	public int getKm() {
		return etat.getKm();
	}

	/*
	Teste si la vitesse est actuellement limitée.
	*/
	public boolean getLimiteVitesse() {
		return etat.getLimiteVitesse();
	}

	/*
	Choisit la carte à jouer.
	 Attention aux exceptions : InputMismatchException et NoSuchElementException
	
	Returns:
	un entier entre -7 et +7 permettant de défausser (<0) ou de jouer (>0) la carte correspondante
	*/
	public int choisitCarte() {
		List<Carte> main = getMain();
		System.out.println("\nChoisissez la carte à jouer :");
		for (int i = 0; i < main.size(); i++) {
			System.out.println((i+1)+" : "+main.get(i));
		}
		System.out.println("Entrez -n pour défausser la carte n.");
		System.out.print("> ");
		return input.nextInt();
	}

	/*
	Choisit l'adversaire à attaquer
	
	Parameters:
	carte - l'attaque qui sera portée sur cet adversaire
	Returns:
	le Joueur choisi
	Throws:
	IllegalStateException - si le joueur décide d'annuler son attaque
	*/
	public Joueur choisitAdversaire(Carte carte) throws IllegalStateException {
		Joueur j = getProchainJoueur();
		int i = 0;
		ArrayList<Joueur> adversaires = new ArrayList<Joueur>();
		
		System.out.println("Choisissez l'adversaire à attaquer :");
		while (j != this) {
			System.out.println((i+1)+" : "+j.nom);
			adversaires.add(j);
			i++;
			j = j.getProchainJoueur();
		}
		
		System.out.print("> ");
		int choix = input.nextInt();
		while (choix <= 0 || choix > i) {
			System.out.println("Choisissez un nombre dans la liste ci-dessus.");
			System.out.print("> ");
			choix = input.nextInt();
		}
		return adversaires.get(choix-1);
	}

	/*
	Ajoute une carte à la main du joueur.
	
	Parameters:
	carte - la carte à ajouter
	Throws:
	IllegalStateException - si la main contient déjà plus de 6 cartes
	*/
	public void prendCarte(Carte carte) throws IllegalStateException {
		etat.prendCarte(carte);
	}

	/*
	Joue la carte spécifiée.
	 Si c'est une attaque, inclut la sélection d'un adversaire.
	
	Parameters:
	jeu - le jeu (et ses joueurs)
	numero - l'index de la carte dans la main (de 0 à 6)
	Throws:
	IllegalStateException - si la carte n'est pas jouable
	*/
	public void joueCarte(Jeu jeu, int numero) throws IllegalStateException {
		Carte carte = getMain().get(numero);
		if (carte instanceof Attaque) {
			etat.joueCarte(jeu, numero, choisitAdversaire(carte));
		} else {
			etat.joueCarte(jeu, numero);
		}
	}

	/*
	Défausse la carte spéficiée
	
	Parameters:
	jeu - le jeu (et sa défausse)
	numero - l'index de la carte dans la main (de 0 à 6)
	*/
	public void defausseCarte(Jeu jeu, int numero) {
		etat.defausseCarte(jeu, numero);
	}

	/*
	Applique une attaque à ce joueur.
	 Résout le coup-fourré si possible.
	
	Parameters:
	jeu - le jeu
	carte - l'attaque à appliquer
	Throws:
	IllegalStateException - si l'attque n'est pas applicable
	*/
	public void attaque(Jeu jeu, Attaque carte) throws IllegalStateException {
		etat.attaque(jeu, carte);
	}

	/*
	Joue la carte spécifiée.
	 Si c'est une attaque, inclut la sélection d'un adversaire.
	
	Parameters:
	jeu - le jeu (et ses joueurs)
	numero - l'index de la carte dans la main (de 0 à 6)
	adversaire - le joueur a attaquer le cas échéant
	Throws:
	IllegalStateException - si la carte n'est pas jouable
	*/
	public void joueCarte(Jeu jeu, int numero, Joueur adversaire) throws IllegalStateException {
		etat.joueCarte(jeu, numero, adversaire);
	}

	/*
	Consulte la carte au sommet de la pile de bataille. (la seule visible)
	
	Returns:
	la carte au sommet de la pile de bataille, ou null si elle est vide.
	*/
	public Bataille getBataille() {
		return etat.getBataille();
	}

	/*
	Teste et décrit les raisons pour lesquelles le joueur est incapable d'avancer.
	
	Returns:
	un texte explicatif, ou null si le joueur peut avancer
	*/
	public String ditPourquoiPeutPasAvancer() {
		return etat.ditPourquoiPeutPasAvancer();
	}

	/*
	Décrit le joueur.
	
	Overrides:
	toString in class Object
	Returns:
	le nom et l'état interne du joueur sur la même ligne.
	*/
	public String toString() {
		return nom+" : "+etat.toString();
	}

	/*
	Retourne la liste des bottes jouées
	
	Returns:
	une copie non modifiable des bottes du joueur
	See Also:
	Collections.unmodifiableList(List)
	*/
	public List<Botte> getBottes() {
		return etat.getBottes();
	}
}
