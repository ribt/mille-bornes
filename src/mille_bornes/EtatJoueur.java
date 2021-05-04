package mille_bornes;

import java.util.*;

import mille_bornes.cartes.Attaque;
import mille_bornes.cartes.Bataille;
import mille_bornes.cartes.Botte;
import mille_bornes.cartes.Carte;
import mille_bornes.cartes.attaques.LimiteVitesse;

public class EtatJoueur  {
	private final Joueur joueur;
	private final Stack<Bataille> pileBataille;
	private final List<Carte> main;
	private final List<Botte> bottes;
	private int km;
	private boolean limiteVitesse;

	EtatJoueur(Joueur joueur) {
		this.joueur = joueur;
		// TODO
		this.pileBataille = new Stack<Bataille>();
		this.main = new ArrayList<Carte>();
		this.bottes = new ArrayList<Botte>();
		this.km = 0;
		this.limiteVitesse = false;
	}

	/*
	Retourne le nombre de kilomètres parcourus.
	*/
	public int getKm() {
		return km;
	}

	/*
	Ajoute des kilomètres parcourus au compteur.
	
	Parameters:
	km - le nombre de kilomètres à ajouter
	Throws:
	IllegalStateException - si le joueur ne peut pas avancer, ou s'il essaye d'avancer plus que la limite.
	*/
	public void ajouteKm(int km) throws IllegalStateException {
		if (limiteVitesse && km > 50) {
			throw new IllegalStateException("Vous êtes limité à 50 km/h.");
		}
		if (this.km + km > 1000) {
			throw new IllegalStateException("Il n'est pas possible de dépasser les 1000 km.");
		}
		String msgErreur = ditPourquoiPeutPasAvancer();
		if (msgErreur != null) {
			throw new IllegalStateException(msgErreur);
		}
		this.km += km;
	}

	/*
	Teste et décrit les raisons pour lesquelles le joueur est incapable d'avancer.
	
	Returns:
	un texte explicatif, ou null si le joueur peut avancer
	*/
	public String ditPourquoiPeutPasAvancer() {
		Carte bataille = this.getBataille();
		if (bataille == null) {
			return "Vous ne pouvez pas avancer car il faut un Feu Vert pour commencer.";
		}
		if (bataille instanceof Attaque && !(bataille instanceof LimiteVitesse)) {
			return "Vous ne pouvez pas avancer car vous êtes bloqué par l'attaque "+bataille;
		}
		return null;
	}

	/*
	Teste si la vitesse est actuellement limitée.
	*/
	public boolean getLimiteVitesse() {
		return limiteVitesse;
	}

	/*
	Change la limite de vitesse.
	
	Parameters:
	limiteVitesse - si vrai, le joueur ne pourra plus avancer que de 50 km par tour de jeu.
	*/
	public void setLimiteVitesse(boolean limiteVitesse) {
		this.limiteVitesse = limiteVitesse;
	}

	/*
	Consulte la carte au sommet de la pile de bataille. (la seule visible)
	
	Returns:
	la carte au sommet de la pile de bataille, ou null si elle est vide.
	*/
	public Bataille getBataille() {
		if (pileBataille.isEmpty()) {
			return null;
		}
		return pileBataille.pop();
	}

	/*
	Ajoute la carte spécifiée au sommet de la pile de bataille.
	 Ne teste pas si le coup est légal !
	
	Parameters:
	carte - la carte à ajouter
	*/
	public void setBataille(Bataille carte) {
		pileBataille.push(carte);
	}

	/*
	Retire la carte au sommet de la pile de bataille et la défausse.
	
	Parameters:
	jeu - le jeu (et sa défausse)
	*/
	public void defausseBataille(Jeu jeu) {
		jeu.defausse(pileBataille.pop());
	}

	/*
	Retourne la main du joueur.
	
	Returns:
	une copie non modifiable de la main du joueur
	See Also:
	Collections.unmodifiableList(List)
	*/
	public List<Carte> getMain() {
		return Collections.unmodifiableList(main);
	}

	/*
	Ajoute une botte sur le jeu.
	 Les effets de la botte ne sont pas appliqués.
	
	Parameters:
	carte - la botte à jouer
	*/
	public void addBotte(Botte carte) {
		bottes.add(carte);
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
		carte.appliqueEffet(jeu, this);
	}

	/*
	Décrit l'état du jeu.
	 Par exemple " 125 km (50) [A...], Feu Rouge"
	
	Overrides:
	toString in class Object
	Returns:
	une ligne de texte contenant la distance parcourue, la limite de vitesse en cours, les bottes exposées et la carte au sommet de la pile de bataille.
	*/
	public String toString() {
		String txt = km+" km";
		if (limiteVitesse) {
			txt += ", limite à 50 km/h";
		}
		txt += "\nListe des bottes du joueur :";
		for(Botte botte : bottes) {
			txt += botte+" ";
		}
		if (pileBataille.isEmpty()) {
			txt += "\nLa pile de bataille est vide";
		} else {
			txt += "\nSommet de la pile de bataille : "+pileBataille.pop();
		}
		return txt;
	}

	/*
	Ajoute une carte à la main du joueur.
	
	Parameters:
	carte - la carte à ajouter.
	Throws:
	IllegalStateException - si le joueur a déjà plus de 6 cartes
	*/
	public void prendCarte(Carte carte) throws IllegalStateException {
		if (main.size() > 6) {
			throw new IllegalStateException("Le joueur a déjà 6 cartes en main.");
		}
		main.add(carte);
	}

	/*
	Défausse la carte spéficiée
	
	Parameters:
	jeu - le jeu (et sa défausse)
	numero - l'index de la carte dans la main (de 0 à 6)
	*/
	public void defausseCarte(Jeu jeu, int numero) {
		jeu.defausse(main.get(numero));
		main.remove(numero);
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
		Carte carte = main.get(numero);
		if (carte instanceof Attaque) {
			throw new IllegalStateException("La carte est une attaque donc il faut spécifier un adversaire.");
		}
		carte.appliqueEffet(jeu, this);
		main.remove(numero);
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
		Carte carte = main.get(numero);
		if (!(carte instanceof Attaque)) {
			throw new IllegalStateException("La carte n'est pas une attaque donc il ne faut pas spécifier d'adversaire.");
		}
		adversaire.attaque(jeu, (Attaque)carte);
		main.remove(numero);
	}

	/*
	Retourne la liste des bottes jouées
	
	Returns:
	une copie non modifiable des bottes du joueur
	See Also:
	Collections.unmodifiableList(List)
	*/
	public List<Botte> getBottes() {
		return bottes;
	}
}
