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
	
	
	public Camion( String immatriculation, Constructeur con, float poid) {
		super(    immatriculation,   con, TypeVehicule.CAMION);
		this.poid = poid;
	}


	public float getPoid() {
		return poid;
	}


	public void setPoid(float poid) {
		this.poid = poid;
	}


	@Override
	public Double calculerCoeff() {
		
		if(  2000 == poid ) {
			return 1.;
		}  else if (poid >= 2000)
			return Double.valueOf( 1 - 0.1 * (int) ((poid - 2000)/100));
		else 
			return Double.valueOf( 1 - 0.1 * (int) ((poid - 2000)/100));

	}

}
