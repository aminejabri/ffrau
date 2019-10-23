package entity.utilisateur;

public class Utilisateur {

	protected int id;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String password;
	protected Role role;
	

	
	
	public Utilisateur(String nom, String prenom, String login, String password, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.role = role;
		this.password = password;
	}
	
	public Utilisateur(int id, String nom, String prenom, String login, String password, Role role) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.role = role;
		this.password = password;
		this.role = role;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
