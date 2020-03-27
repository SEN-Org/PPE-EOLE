package applicationEole;

import java.util.HashMap;
import java.util.Map;


public class Regate {
	private int num;
	private String nomRegate;
	private String dateRegate;
	private int nbParticipants;
	private String lieuDepart;
	private String lieuArrivee;
	private int Distance;
	private Integer nbInscrit = 0;
	
	public Regate (String nomRegate, String dateRegate, String lieuDepart, String lieuArrivee, int Distance) {
		this.nomRegate = nomRegate;
		this.dateRegate = dateRegate;
		this.lieuDepart = lieuDepart;
		this.lieuArrivee = lieuArrivee;
		this.Distance = Distance;
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNbParticipants() {
		return nbParticipants;
	}

	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}

	public String getNomRegate() {
		return nomRegate;
	}

	public void setNomRegate(String nomRegate) {
		this.nomRegate = nomRegate;
	}

	public String getDateRegate() {
		return dateRegate;
	}

	public void setDateRegate(String dateRegate) {
		this.dateRegate = dateRegate;
	}

	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getLieuArrivee() {
		return lieuArrivee;
	}

	public void setLieuArrivee(String lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}

	public int getDistance() {
		return Distance;
	}

	public void setDistance(int distance) {
		Distance = distance;
	}

	public Integer getNbInscrit() {
		return nbInscrit;
	}

	public void setNbInscrit(Integer nbInscrit) {
		this.nbInscrit = nbInscrit;
	}
	
}