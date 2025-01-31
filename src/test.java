package app_cinema;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seance s= new Seance();
		Billet a=new BilletEtudiant(s);
		System.out.println("Billet classique etudiant");

		System.out.println(a.prix());
		
		System.out.println("Billet classique etudiant + popcorn");
		
		BilletExtra b= new SupplementPopcorn(a);
		
		System.out.println(b.prix());

		System.out.println("Billet classique etudiant + popcorn + boisson");

		BilletExtra c = new SupplementBoisson(b);

		System.out.println(c.prix());
	}
}
