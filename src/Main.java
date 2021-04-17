public class Main  {

	public static void main(String[] args) {
		Jeu jeu = new Jeu(new Joueur("ribt"));
		jeu.prepareJeu();
		System.out.println(jeu);
	}
}
