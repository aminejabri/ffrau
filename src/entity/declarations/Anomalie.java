package entity.declarations;

import java.util.Date;

import entity.rallye.Speciale;
import entity.utilisateur.Coureur;

public class Anomalie extends Declaration{
	protected	String typeA;
	protected	String description;
	

	public Anomalie(Coureur coureur, Speciale speciale, String description) {
		super(coureur, speciale, TypeDeclaration.Anomalie);
		
		this.description = description;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String descriptionA) {
		this.description = descriptionA;
	}
	
}
