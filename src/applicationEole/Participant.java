package applicationEole;

public class Participant {
	
	private int idParticipant, tempsReel,tempsCompense, classeVoilier, ratingVoilier;
	private String nom, prenom, nomVoilier, tempsCompenseString;
	
	public Participant(Skipper skipper, Voilier voilier) {
		
		this.idParticipant = Bdd.nbParticipants()+1;	
		this.nom = skipper.getNom();
		this.prenom = skipper.getPrenom();
		this.nomVoilier = voilier.getNom();
		this.classeVoilier = voilier.getCategorie();
		this.ratingVoilier = voilier.getRating();
		this.tempsCompenseString = "";
		
	}

	public int getTempsReel() {
		return tempsReel;
	}

	public void setTempsReel(int tempsRealise) {
		this.tempsReel = tempsRealise;
	}

	public int getClasseVoilier() {
		return classeVoilier;
	}

	public void setClasseVoilier(int categorieVoilier) {
		this.classeVoilier = categorieVoilier;
	}

	public int getRatingVoilier() {
		return ratingVoilier;
	}

	public void setRatingVoilier(int rating) {
		this.ratingVoilier = rating;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomVoilier() {
		return nomVoilier;
	}

	public void setNomVoilier(String nomVoilier) {
		this.nomVoilier = nomVoilier;
	}
	
	
	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}
	
	

	public String getTempsCompenseString() {
		return tempsCompenseString;
	}

	public void setTempsCompenseString(String tempsCompenseString) {
		this.tempsCompenseString = tempsCompenseString;
	}

	public int getTempsCompense() {
		return tempsCompense;
	}

	public void setTempsCompense(int tempsCompense) {
		this.tempsCompense = tempsCompense;
	}


	public String toString() {
		return idParticipant+" "+nom+" "+prenom+" "+nomVoilier+" "+classeVoilier+" "+ratingVoilier;
		
	}

}
