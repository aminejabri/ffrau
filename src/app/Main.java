package app;
import java.sql.SQLIntegrityConstraintViolationException;

import entity.utilisateur.Utilisateur;
import factory.DaoFactory;

public class Main {

	
	public static void main(String[] args) {

		Utilisateur  user = DaoFactory.getUtilisateurDao().find(1);		
		
	}
}
