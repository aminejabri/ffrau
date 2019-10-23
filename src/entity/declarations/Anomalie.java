package entity.declarations;

import java.util.Date;

public class Anomalie extends Declaration{
	protected	String typeA;
	protected	String descriptionA;
	
	public Anomalie(Date heureD, String typeA, String descriptionA) {
		super(heureD);
		this.typeA = typeA;
		this.descriptionA = descriptionA;
	}

	public String getTypeA() {
		return typeA;
	}

	public void setTypeA(String typeA) {
		this.typeA = typeA;
	}

	public String getDescriptionA() {
		return descriptionA;
	}

	public void setDescriptionA(String descriptionA) {
		this.descriptionA = descriptionA;
	}
	
}
