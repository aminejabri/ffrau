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

	
	public float getCylindree() {
		return cylindree;
	}

	public void setCylindree(float cylindree) {
		this.cylindree = cylindree;
	}


	@Override
	float calculerCoeff() {
		// TODO Auto-generated method stub
		return 0;
	}

}
