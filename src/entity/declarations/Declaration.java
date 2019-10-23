package entity.declarations;

import entity.rallye.Speciale;
import entity.utilisateur.Coureur;

public abstract class Declaration {
	
	Coureur coureur;
	Speciale speciale;
	TypeDeclaration type;
	
	
	
	public Declaration(Coureur coureur, Speciale speciale, TypeDeclaration type) {
		super();
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
	
	
	
}
