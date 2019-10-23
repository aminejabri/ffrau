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
	public Double calculerCoeff() {

		if( 280 <= puissance && puissance <= 300) {
			return 1.;
		}  else if (puissance >= 300)
			return Double.valueOf( 1 + 0.05 * (puissance - 300));
		else 
			return Double.valueOf( 1 + 0.05 * (puissance - 280));
	}

}
