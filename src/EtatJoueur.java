public class EtatJoueur  {
	private final Joueur joueur;
	private final Stack<Bataille> pileBataille;
	private final List<Carte> main;
	private final List<Botte> bottes;
	private int km;
	private boolean limiteVitesse;

	EtatJoueur(Joueur joueur) {
		// TO DO
	}

	/*
	Retourne le nombre de kilomètres parcourus.
	*/
	public int getKm() {
		// TO DO
	}

	/*
	Ajoute des kilomètres parcourus au compteur.
	
	Parameters:
	km - le nombre de kilomètres à ajouter
	Throws:
	IllegalStateException - si le joueur ne peut pas avancer, ou s'il essaye d'avancer plus que la limite.
	*/
	public void ajouteKm(int km) throws IllegalStateException {
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
	Teste si la vitesse est actuellement limitée.
	*/
	public boolean getLimiteVitesse() {
		// TO DO
	}

	/*
	Change la limite de vitesse.
	
	Parameters:
	limiteVitesse - si vrai, le joueur ne pourra plus avancer que de 50 km par tour de jeu.
	*/
	public void setLimiteVitesse(boolean limiteVitesse) {
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
	Ajoute la carte spécifiée au sommet de la pile de bataille.
	 Ne teste pas si le coup est légal !
	
	Parameters:
	carte - la carte à ajouter
	*/
	public void setBataille(Bataille carte) {
		// TO DO
	}

	/*
	Retire la carte au sommet de la pile de bataille et la défausse.
	
	Parameters:
	jeu - le jeu (et sa défausse)
	*/
	public void defausseBataille(Jeu jeu) {
		// TO DO
	}

	/*
	Retourne la main du joueur.
	
	Returns:
	une copie non modifiable de la main du joueur
	See Also:
	Collections.unmodifiableList(List)
	*/
	public List<Carte> getMain() {
		// TO DO
	}

	/*
	Ajoute une botte sur le jeu.
	 Les effets de la botte ne sont pas appliqués.
	
	Parameters:
	carte - la botte à jouer
	*/
	public void addBotte(Botte carte) {
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
	Décrit l'état du jeu.
	 Par exemple " 125 km (50) [A...], Feu Rouge"
	
	Overrides:
	toString in class Object
	Returns:
	une ligne de texte contenant la distance parcourue, la limite de vitesse en cours, les bottes exposées et la carte au sommet de la pile de bataille.
	*/
	public String toString() {
		// TO DO
	}

	/*
	Ajoute une carte à la main du joueur.
	
	Parameters:
	carte - la carte à ajouter.
	Throws:
	IllegalStateException - si le joueur a déjà plus de 6 cartes
	*/
	public void prendCarte(Carte carte) throws IllegalStateException {
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
