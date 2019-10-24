package entity.vehicule;

import entity.utilisateur.Constructeur;

public class Moto extends Vehicule{
	private float cylindree;
	
	public Moto() {
		super();
	}


	
	public Moto(int id, String immatriculation, Constructeur con, float cylindree) {
		super(  id,   immatriculation,   con, TypeVehicule.MOTO);
		this.cylindree = cylindree;
	}

	
	public Moto( String immatriculation, Constructeur con, float cylindree) {
		super(    immatriculation,   con, TypeVehicule.MOTO);
		this.cylindree = cylindree;
	}

	
	public float getCylindree() {
		return cylindree;
	}

	public void setCylindree(float cylindree) {
		this.cylindree = cylindree;
	}


	@Override
	public Double calculerCoeff() {
		
		if( 500 <= cylindree && cylindree <= 525) {
			return 1.;
		}  else if (cylindree >= 525)
			return Double.valueOf( 1 - 0.25 * (int) ((cylindree - 525)/25));
		else 
			return Double.valueOf( 1 - 0.25 * (int) ((cylindree - 500)/25));
	}

}
