package entity.declarations;

import entity.rallye.Speciale;
import entity.utilisateur.Coureur;

public class Retour extends Declaration {

	public Retour(Coureur coureur, Speciale speciale) {
		super(coureur, speciale, TypeDeclaration.Retour);
		// TODO Auto-generated constructor stub
	}

	public Retour(int id, Coureur coureur, Speciale speciale) {
		super(id, coureur, speciale, TypeDeclaration.Retour);
		// TODO Auto-generated constructor stub
	}
}
