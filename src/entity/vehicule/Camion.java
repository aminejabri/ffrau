package entity.vehicule;

import entity.utilisateur.Constructeur;

public class Camion extends Vehicule {
	private float poid;
	
	public Camion() {
		
	}
	
	
	public Camion(int id, String immatriculation, Constructeur con, float poid) {
		super(  id,   immatriculation,   con, TypeVehicule.CAMION);
		this.poid = poid;
	}


	public float getPoid() {
		return poid;
	}


	public void setPoid(float poid) {
		this.poid = poid;
	}


	@Override
	float calculerCoeff() {
		// TODO Auto-generated method stub
		return 0;
	}

}
