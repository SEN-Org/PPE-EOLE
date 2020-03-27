package applicationEole;

import java.util.ArrayList;

public class Bdd {
	
	
	private static ArrayList<Participant> listeParticipants = new ArrayList<Participant>();
	private static ArrayList<Regate> listeRegates = new ArrayList<Regate>();
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Création des méthodes pour les participants
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public static void AjoutParticipantBdd(Participant participant) {
		listeParticipants.add(participant);
	}
	
	
	public static void SupprimeParticipantBdd(int numParticipant) {
		
		listeParticipants.remove(numParticipant);
		if(listeParticipants.isEmpty() == false) {
			for(int i = numParticipant; i < listeParticipants.size(); i++) {
				listeParticipants.get(i).setIdParticipant(listeParticipants.get(i).getIdParticipant()-1);
			}
		}
		
	}
	
	public static int nbParticipants(){
		return listeParticipants.size();
	}
	
	
	public static  Participant getParticipant(int numParticipant) {
		return listeParticipants.get(numParticipant);
	}
	
	
	public static void modifParticipantBdd(int numParticipant, String nom, String prenom, String nomVoilier, int categorieVoilier, int rating) {
		listeParticipants.get(numParticipant).setNom(nom);
		listeParticipants.get(numParticipant).setPrenom(prenom);
		listeParticipants.get(numParticipant).setNomVoilier(nomVoilier);
		listeParticipants.get(numParticipant).setClasseVoilier(categorieVoilier);
		listeParticipants.get(numParticipant).setRatingVoilier(rating);

	}
	
	public static  ArrayList<Participant> getListeParticipants() {
		return listeParticipants;
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Création des méthodes pour les Régates
//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public static void AjoutRegateBdd(Regate regate) {
		listeRegates.add(regate);
	}
	
	public static int nbRegate(){
		return listeRegates.size();
	}
	
	public static  Regate getRegate(int numRegate) {
		return listeRegates.get(numRegate);
	}
	
	public static void modifRegateBdd(String nomRegate, String dateRegate, String lieuDepart, String lieuArrivee, int Distance) {
		listeRegates.get(0).setNomRegate(nomRegate);
		listeRegates.get(0).setDateRegate(dateRegate);
		listeRegates.get(0).setLieuDepart(lieuDepart);
		listeRegates.get(0).setLieuArrivee(lieuArrivee);
		listeRegates.get(0).setDistance(Distance);

	}
	
	public static void SupprimeRegateBdd(int numParticipant) {
		
		listeRegates.remove(numParticipant);
		
	}
	
}
