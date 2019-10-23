package entity.rallye.deroulement;

import entity.rallye.Speciale;
import entity.utilisateur.Coureur;

public class Courir {


	private Coureur coureur;
	private Speciale speciale;
	private Double temps;
	
	public Courir(Coureur coureur, Speciale speciale, Double temps) {
		super();
		this.coureur = coureur;
		this.speciale = speciale;
		this.temps = temps;
	}

	public Coureur getCoureur() {
		return coureur;
	}



	public void setCoureur(Coureur coureur) {
		this.coureur = coureur;
	}



	public Speciale getSpeciale() {
		return speciale;
	}



	public void setSpeciale(Speciale speciale) {
		this.speciale = speciale;
	}



	public Double getTemps() {
		return temps;
	}



	public void setTemps(Double temps) {
		this.temps = temps;
	}

}
