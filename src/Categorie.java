public enum Categorie extends Enum<Categorie> {

	private Categorie() {
		// TO DO
	}

	/*
	Returns an array containing the constants of this enum type, in
	the order they are declared. This method may be used to iterate
	over the constants as follows:
	
	for (Categorie c : Categorie.values())
	    System.out.println(c);
	
	
	Returns:
	an array containing the constants of this enum type, in the order they are declared
	*/
	public static Categorie[] values() {
		// TO DO
	}

	/*
	Returns the enum constant of this type with the specified name.
	The string must match exactly an identifier used to declare an
	enum constant in this type.  (Extraneous whitespace characters are 
	not permitted.)
	
	Parameters:
	name - the name of the enum constant to be returned.
	Returns:
	the enum constant with the specified name
	Throws:
	IllegalArgumentException - if this enum type has no constant with the specified name
	NullPointerException - if the argument is null
	*/
	public static Categorie valueOf(String name) {
		// TO DO
	}
}
