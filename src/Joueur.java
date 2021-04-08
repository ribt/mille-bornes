public class Joueur  {
	public final String nom;
	private final EtatJoueur etat;
	private final Scanner input;
	private Joueur prochainJoueur;

	public Joueur(String nom) {
		// TO DO
	}

	/*
	Récupère le prochain joueur
	*/
	public Joueur getProchainJoueur() {
		// TO DO
	}

	/*
	Règle le prochain joueur : définit la position autour de la table...
	*/
	public void setProchainJoueur(Joueur j) {
		// TO DO
	}

	/*
	Retourne une copie non modifiable de la main
	*/
	public List<Carte> getMain() {
		// TO DO
	}

	/*
	Retourne le nombre de kilomètres parcourus par le joueur
	*/
	public int getKm() {
		// TO DO
	}

	/*
	Teste si la vitesse est actuellement limitée.
	*/
	public boolean getLimiteVitesse() {
		// TO DO
	}

	/*
	Choisit la carte à jouer.
	 Attention aux exceptions : InputMismatchException et NoSuchElementException
	
	Returns:
	un entier entre -7 et +7 permettant de défausser (<0) ou de jouer (>0) la carte correspondante
	*/
	public int choisitCarte() {
		// TO DO
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
		// TO DO
	}

	/*
	Ajoute une carte à la main du joueur.
	
	Parameters:
	carte - la carte à ajouter
	Throws:
	IllegalStateException - si la main contient déjà plus de 6 cartes
	*/
	public void prendCarte(Carte carte) throws IllegalStateException {
		// TO DO
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
		// TO DO
	}

	/*
	Défausse la carte spéficiée
	
	Parameters:
	jeu - le jeu (et sa défausse)
	numero - l'index de la carte dans la main (de 0 à 6)
	*/
	public void defausseCarte(Jeu jeu, int numero) {
		// TO DO
	}

	/*
	Applique une attaque à ce joueur.
	 Résoud le coup-fourré si possible.
	
	Parameters:
	jeu - le jeu
	carte - l'attaque à apliquer
	Throws:
	IllegalStateException - si l'attque n'est pas applicable
	*/
	public void attaque(Jeu jeu, Attaque carte) throws IllegalStateException {
		// TO DO
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
		// TO DO
	}

	/*
	Consulte la carte au sommet de la pile de bataille. (la seule visible)
	
	Returns:
	la carte au sommet de la pile de bataille, ou null si elle est vide.
	*/
	public Bataille getBataille() {
		// TO DO
	}

	/*
	Teste et décrit les raisons pour lesquelles le joueur est incapable d'avancer.
	
	Returns:
	un texte explicatif, ou null si le joueur peut avancer
	*/
	public String ditPourquoiPeutPasAvancer() {
		// TO DO
	}

	/*
	Décrit le joueur.
	
	Overrides:
	toString in class Object
	Returns:
	le nom et l'état interne du joueur sur la même ligne.
	*/
	public String toString() {
		// TO DO
	}

	/*
	Retourne la liste des bottes jouées
	
	Returns:
	une copie non modifiable des bottes du joueur
	See Also:
	Collections.unmodifiableList(List)
	*/
	public List<Botte> getBottes() {
		// TO DO
	}
}
