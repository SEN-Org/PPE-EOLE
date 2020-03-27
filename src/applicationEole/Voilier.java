package applicationEole;

public class Voilier {
	String nom;
	int categorie;
	int rating;
	Skipper skipper;

	public Voilier(String nom, int categorie, int rating, Skipper skipper) {
		this.nom = nom;
		this.categorie = categorie;
		this.rating = rating;
		this.skipper = skipper;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int classe) {
		this.categorie = classe;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Skipper getSkipper() {
		return skipper;
	}

	public void setSkipper(Skipper skipper) {
		this.skipper = skipper;
	}
	
	
}
