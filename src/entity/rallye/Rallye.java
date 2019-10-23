package entity.rallye;

import java.util.ArrayList;
import java.util.List;

public class Rallye {
	private int id;
	private String nom;
	private String ville;
	private String pays;
	

	private List<EditionRallye> lstEditions;
	
	
	
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
	
	public Rallye(String nom, String ville, String pays, List<EditionRallye> lstEditions) {
		this.nom = nom;
		this.ville = ville;
		this.pays = pays;
		this.lstEditions = lstEditions;
	}

   	//organiser une nouvelle édition de rallye
	public void ajouterEditionR(EditionRallye e) {
		this.lstEditions.add(e);
	}
	
	//récupérer une édition si numEdition, rallye donnée
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
