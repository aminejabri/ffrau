package menu;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entity.utilisateur.Role;
import entity.utilisateur.Utilisateur;
import factory.DaoFactory;
import menu.classement.ClassementCoureurMenu;
import menu.rallye.InscriptionEditionMenu;
import utils.ScanUtils;

public class InscriptionMenu extends Menu {
	

	public static void menu() {


	    System.out.println("Veuillez renseigner les champs suivant : ");
	    
	    System.out.print("nom : ");
	    String nom = ScanUtils.scanString(20, false);

	    System.out.print("prenom : ");
	    String prenom = ScanUtils.scanString(20, false);

	    System.out.print("login : ");	    
	    String login = ScanUtils.scanString(20, false);

	    System.out.print("motDePasse : ");
	    String motDePasse = ScanUtils.scanString(20, false);

	    System.out.print("Role : ");
	    Role role = ScanUtils.scanRole();
	    

	    if (DaoFactory.getUtilisateurDao().findByLogin(login) == null ) {
		    try {
				
		    	DaoFactory.getUtilisateurDao().create(new Utilisateur(nom, prenom, login, motDePasse, role));
			    System.out.println("Vous êtes bien inscrit vous pouvez vous connecter");
		    	ConnectionMenu.menu();
		    } catch (Exception e) {
			    System.out.println("login deja existant");
			}

	    } else {
		    System.out.println("login deja existant");
		    NonConnecteMenu.menu();
	    }
	    	
	}
	


}
