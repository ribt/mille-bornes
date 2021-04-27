import java.util.*;

public class Jeu  {
	private final List<Joueur> joueurs;
	private Joueur joueurActif;
	private Joueur prochainJoueur;
	private TasDeCartes sabot;
	private TasDeCartes defausse;

	public Jeu() {
		this.joueurs = new ArrayList<Joueur>();
		this.joueurActif = null;
		this.prochainJoueur = null;
	}

	public Jeu(Joueur... joueurs) {
		this.joueurs = new ArrayList<Joueur>();
		for (Joueur j: joueurs) {
			this.joueurs.add(j);
		}
		this.joueurActif = null;
		this.prochainJoueur = null;
	}

	/*
	Ajoute les joueurs spécifiés à la partie.
	
	Parameters:
	joueurs - le ou les joueurs à ajouter
	Throws:
	IllegalStateException - si la partie a déjà commencé
	*/
	public void ajouteJoueurs(Joueur... joueurs) throws IllegalStateException {
		if (joueurActif != null) {
			throw new IllegalStateException("La partie a déjà commencé.");
		}
		for (Joueur j: joueurs) {
			this.joueurs.add(j);
		}
	}

	/*
	Lance le jeu.
	 
	 randomise l'ordre de jeu des joueurs 
	 crée un sabot avec 110 cartes 
	 mélange les cartes aléatoirement 
	 crée une défausse vide 
	 distribue 6 cartes à chaque joueur, une par une, à tour de rôle 
	 choisit le prochain joueur
	*/
	public void prepareJeu() {
		Collections.shuffle(joueurs);
		sabot = new TasDeCartes(true);
		sabot.melangeCartes();
		defausse = new TasDeCartes(false);
		
		// TODO : distribuer les cartes
		
		joueurActif = joueurs.get(0);
		prochainJoueur = joueurActif.getProchainJoueur();
	}

	/*
	Décrit le jeu et indique le joueur actif.
	 Par exemple :
	  lui :   50 km (50) [....], Feu Vert
	 >toi :  125 km (50) [A...], Feu Rouge
	  moi :  200 km  [....], Feu Vert
	  nous :   25 km  [....], Feu Vert
	 Pioche :  67 cartes; Défausse : vide
	 
	
	Overrides:
	toString in class Object
	Returns:
	une chaîne contenant une ligne par joueur, indiquant son nom et son jeu visible, et une ligne indiquant le nombre de carte restant au sabot et la carte visible de la défausse.
	*/
	public String toString() {
		String txt = "";
		for (Joueur j: joueurs) {
			if (j == joueurActif) {
				txt += "> ";
			} else {
				txt += "  ";
			}
			txt += j.toString() + "\n";
		}
		txt += "Pioche : "+this.getNbCartesSabot()+" cartes; ";
		txt += "Défausse : "+this.defausse.getNbCartes()+" cartes";
		return txt;
	}

	/*
	Fait jouer le prochain joueur.
	 
	active le prochain joueur
	tire une carte pour ce joueur
	fait choisir la carte à jouer/défausser au joueur
	exécute le choix du joueur si possible, ou affiche l'erreur et recommence au 3.
	
	
	Returns:
	vrai ssi la partie est terminée : le sabot est vide (le joueur ne peut tirer de 7° carte) ou le joueur a atteint 1000 km.
	*/
	public boolean joue() {
		// TODO
		return estPartieFinie();
	}

	/*
	Active le joueur suivant de la partie et lui fait tirer une carte si la partie n'est pas terminée.
	*/
	public void activeProchainJoueurEtTireCarte() {
		// TODO
	}

	/*
	Teste si la partie est finie.
	*/
	public boolean estPartieFinie() {
		for (Joueur j: joueurs) {
			if (j.getKm() == 1000) {
				return true;
			}
		}
		return false;
	}

	/*
	Modifie le prochain joueur. Utile uniquement pour les bottes, qui font rejouer celui qui expose la botte.
	
	Parameters:
	prochainJoueurActif - le prochain joueur à jouer
	*/
	public void setProchainJoueur(Joueur prochainJoueurActif) {
		this.prochainJoueur = prochainJoueurActif;
	}

	/*
	Retourne le joueur actif : celui qui joue en ce moment.
	*/
	public Joueur getJoueurActif() {
		return this.joueurActif;
	}

	/*
	Retourne le gagnant de la partie : le premier à atteindre 1000km.
	 Si le sabot est épuisé, celui qui a le plus de kilomètres parcourus est le gagnant.
	
	Returns:
	La liste des joueurs ayant le plus de kilomètres. ( les gagnants ex-aequo )
	*/
	public List<Joueur> getGagnant() {
		// TODO
		return null;
	}

	/*
	Tire une carte du sabot.
	
	Returns:
	la carte à ajouter à sa main
	*/
	public Carte pioche() {
		return sabot.prend();
	}

	/*
	Empile une carte sur la défausse.
	
	Parameters:
	carte - la carte à défausser
	*/
	public void defausse(Carte carte) {
		defausse.pose(carte);
	}

	/*
	Retourne le nombre de cartes restant au sabot.
	*/
	public int getNbCartesSabot() {
		return sabot.getNbCartes();
	}

	/*
	Consulte la carte au somment de la défausse, sans l'en retirer.
	
	Returns:
	null si la défausse est vide, la carte du dessus sinon
	*/
	public Carte regardeDefausse() {
		return defausse.regarde();
	}
}
