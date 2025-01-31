package app_cinema;

public class Planning {
	private static Planning planningUnique;
	
	private Planning () {}

	public static Planning getInstance () {
		if (Planning.planningUnique == null) {
			Planning.planningUnique = new Planning();
		}
		else {
			System.err.println("Attention, un planning existe déjà !");
			System.err.println("Il ne peut pas y avoir de doublon !");
		}
		return Planning.planningUnique;
	}
}