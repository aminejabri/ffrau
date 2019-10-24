package entity.declarations;

import entity.rallye.Speciale;
import entity.utilisateur.Coureur;

public abstract class Declaration {
	
	Coureur coureur;
	Speciale speciale;
	TypeDeclaration type;
	private int id;
	
	
	
	public Declaration(Coureur coureur, Speciale speciale, TypeDeclaration type) {
		super();
		this.coureur = coureur;
		this.speciale = speciale;
		this.type = type;
	}
	
	
	
	public Declaration(int id, Coureur coureur, Speciale speciale, TypeDeclaration type) {
		super();
		this.id = id;
		this.coureur = coureur;
		this.speciale = speciale;
		this.type = type;
	}
	
	public Coureur getCoureur() {
		return coureur;
	}
	public void setCoureur(Coureur coureur) {
		this.coureur = coureur;
	}
	public Speciale getSpeciale() {
		return speciale;
	}
	public void setSpeciale(Speciale speciale) {
		this.speciale = speciale;
	}
	public TypeDeclaration getType() {
		return type;
	}
	public void setType(TypeDeclaration type) {
		this.type = type;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
