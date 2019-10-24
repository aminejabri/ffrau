package entity.declarations;


import entity.rallye.Speciale;
import entity.utilisateur.Coureur;

public class Abandon extends Declaration {

	public Abandon(Coureur coureur, Speciale speciale) {
		super(coureur, speciale, TypeDeclaration.Abandon);
		// TODO Auto-generated constructor stub
	}
	
	public Abandon(int id, Coureur coureur, Speciale speciale) {
		super(id, coureur, speciale, TypeDeclaration.Abandon);
		// TODO Auto-generated constructor stub
	}

}
