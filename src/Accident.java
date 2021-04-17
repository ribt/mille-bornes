public class Accident extends Attaque {

	public Accident() {
		super("Accident");
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par un As du Volant
	
	Overrides:
	estContreeParAsDuVolant in class Bataille
	*/
	public boolean estContreeParAsDuVolant() {
		return true;
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par des Réparations
	
	Overrides:
	estContreeParReparations in class Bataille
	*/
	public boolean estContreeParReparations() {
		return true;
	}
}
