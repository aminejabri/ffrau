package entity.vehicule;

import entity.utilisateur.Constructeur;

public class Voiture  extends Vehicule{
	private float puissance;
	
	public Voiture() {
		
	}
	
	public Voiture(int id, String immatriculation, Constructeur con, float puissance) {
		super(  id,   immatriculation,   con,   TypeVehicule.VOITURE);
		this.puissance = puissance;
	}
	
	

	public float getPuissance() {
		return puissance;
	}

	public void setPuissance(float puissance) {
		this.puissance = puissance;
	}

	@Override
	float calculerCoeff() {
		// TODO Auto-generated method stub
		return 0;
	}

}
