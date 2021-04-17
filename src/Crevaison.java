public class Crevaison extends Attaque {

	public Crevaison() {
		super("Crevaison");
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par un Increvable
	
	Overrides:
	estContreeParIncrevable in class Bataille
	*/
	public boolean estContreeParIncrevable() {
		return true;
	}

	/*
	Description copied from class: Bataille
	Teste si cette carte est contrée par une Roue de Secours
	
	Overrides:
	estContreeParRoueDeSecours in class Bataille
	*/
	public boolean estContreeParRoueDeSecours() {
		return true;
	}
}
