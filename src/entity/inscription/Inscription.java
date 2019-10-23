package entity.inscription;

import entity.rallye.EditionRallye;
import entity.utilisateur.Coureur;
import entity.vehicule.Vehicule;

public class Inscription {

	int numero;
	Coureur coureur;
	Vehicule vehicule;
	EditionRallye editionRallye;
	
	EtatInscription etat;

	public Inscription(Coureur coureur, EditionRallye editionRallye, EtatInscription etat) {
		super();
		this.coureur = coureur;
		this.editionRallye = editionRallye;
		this.etat = etat;
	}

	public Inscription(int numero, Coureur coureur, Vehicule vehicule, EditionRallye editionRallye, EtatInscription etat) {
		super();
		this.numero = numero;
		this.coureur = coureur;
		this.vehicule = vehicule;
		this.editionRallye = editionRallye;
		this.etat = etat;
	}

	public Coureur getCoureur() {
		return coureur;
	}

	public void setCoureur(Coureur coureur) {
		this.coureur = coureur;
	}

	public EditionRallye getEditionRallye() {
		return editionRallye;
	}

	public void setEditionRallye(EditionRallye editionRallye) {
		this.editionRallye = editionRallye;
	}

	public EtatInscription getEtat() {
		return etat;
	}

	public void setEtat(EtatInscription etat) {
		this.etat = etat;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
}
