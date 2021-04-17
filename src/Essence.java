public class Essence extends Parade {

	public Essence() {
		super("Essence");
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte contre l'attaque spécifiée.
	
	Specified by:
	contre in class Bataille
	Parameters:
	carte - l'attaque à contrer
	*/
	public boolean contre(Attaque carte) {
		return (carte instanceof PanneEssence);
	}
}
