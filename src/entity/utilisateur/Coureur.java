package entity.utilisateur;

import java.util.Date;

public class Coureur {

	protected int id;
	protected Utilisateur utilisateur;
	protected String nom;
	protected String prenom;
	protected Date dtNais;
	protected String groupeSang;
	protected String rhesus;
	
	
	

	public Coureur(int id, Utilisateur utilisateur, String nom, String prenom, Date dtNais, String groupeSang,
			String rhesus) {
		super();
		this.id = id;
		this.utilisateur = utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.dtNais = dtNais;
		this.groupeSang = groupeSang;
		this.rhesus = rhesus;
	}

	public void setDtNais(Date dtNais) {
		this.dtNais = dtNais;
	}

	public void setGroupeSang(String groupeSang) {
		this.groupeSang = groupeSang;
	}

	public void setRhesus(String rhesus) {
		this.rhesus = rhesus;
	}

	public Date getDtNais() {
		return dtNais;
	}

	public String getGroupeSang() {
		return groupeSang;
	}

	public String getRhesus() {
		return rhesus;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Coureur [nom=" + nom + ", prenom=" + prenom + ", dtNais=" + dtNais + ", groupeSang=" + groupeSang
				+ ", rhesus=" + rhesus + "]";
	}
	
	
}
