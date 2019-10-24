package entity.rallye;

import java.util.ArrayList;
import java.util.List;

public class Rallye {
	private int id;
	private String nom;
	private String ville;
	private String pays;
	

	private List<EditionRallye> lstEditions;
	
	
	
	public List<EditionRallye> getLstEditions() {
		return lstEditions;
	}

	public void setLstEditions(List<EditionRallye> lstEditions) {
		this.lstEditions = lstEditions;
	}

	public Rallye() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rallye(String nom, String ville, String pays) {
		this.nom = nom;
		this.ville = ville;
		this.pays = pays;
		this.lstEditions = new ArrayList<EditionRallye>();
	}
	

	public Rallye(int id, String nom, String ville, String pays) {
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.pays = pays;
	}
	public Rallye(String nom, String ville, String pays, List<EditionRallye> lstEditions) {
		this.nom = nom;
		this.ville = ville;
		this.pays = pays;
		this.lstEditions = lstEditions;
	}
	
	public Rallye(int id, String nom, String ville, String pays, List<EditionRallye> lstEditions) {
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.pays = pays;
		this.lstEditions = lstEditions;
	}

   	//organiser une nouvelle �dition de rallye
	public void ajouterEditionR(EditionRallye e) {
		this.lstEditions.add(e);
	}
	
	//r�cup�rer une �dition si numEdition, rallye donn�e
	public EditionRallye recupererEdition(int numEdition) {

			return lstEditions.stream().filter(x-> x.getNumEdition() == numEdition).findFirst().get();
	}
	
	public List<EditionRallye> recupererEditionsParAnnee(){

		return null;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}


}
