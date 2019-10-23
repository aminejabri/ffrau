package entity.vehicule;

import entity.rallye.TypeRallye;
import entity.utilisateur.Constructeur;

public abstract class Vehicule {
	
	protected int id;
	protected String immatriculation;
	protected Constructeur constructeur;
	protected TypeVehicule type;
	
	public Vehicule() {
		
	}
	
	public TypeVehicule getType() {
		return type;
	}


	public void setType(TypeVehicule type) {
		this.type = type;
	}

	public Vehicule(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Vehicule(int id, String immatriculation, Constructeur con, TypeVehicule type) {
		
		this.id = id;
		this.immatriculation = immatriculation;
		this.constructeur = con;
		this.type = type;
	}

	
	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	abstract float calculerCoeff();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	@Override
	public String toString() {
		return "Vehicule [immatriculation=" + immatriculation + ", constructeur=" + constructeur.getNom() + ", type=" + type
				+ "]";
	}
	
	
}
