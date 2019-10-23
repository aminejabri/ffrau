package entity.utilisateur;

public class Constructeur {


	protected int id;
	protected Utilisateur utilisateur;
	private String pays;
	private String addresse;
	private String nom;
	
	public Constructeur(int id, String nom , String adrCon, String paysCon, Utilisateur utilisateur) {
		
		this.id = id;
		this.nom = nom;
		this.addresse = adrCon;
		this.pays = paysCon;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
