package menu;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.Scanner;


import entity.rallye.Rallye;
import factory.DaoFactory;
import menu.rallye.InscriptionEditionMenu;
import utils.ScanUtils;


public class CreationRallyeMenu extends Menu{

	public static void menu() {
	
	    System.out.println("Veuillez renseigner les champs suivant : ");
	    
	    System.out.print("nom du rallye : ");
	    String nom = ScanUtils.scanString(60, false);
	    
	    System.out.print("ville du rallye : ");
	    String ville = ScanUtils.scanString(200, false);
	    
	    System.out.print("pays du rallye : ");
	    String pays = ScanUtils.scanString(20, false);
	
	    try {
	    	
	    	Rallye rallye = DaoFactory.getRallyeDao().save(new Rallye(nom,ville,pays));
		    System.out.print("Rallye créé - Vous voulez rajouter une edition pour ce rallye ? oui (1) / retour (2)");
		    int reponse = ScanUtils.scanInt(1, 2, false);
		    switch (reponse) {
		    case 1:
		    	CreationEditionMenu.menu(rallye.getId());
			    System.out.println("Rallye créé avec success");
		    	break;

		    case 2 :
		    	
			    System.out.println("Rallye créé avec success");
		    	break;
		    }
		    		    
		    
	    } catch (Exception e) {

		    System.out.println("problème de création");

		}
	    
	    AgenceMenu.menu();
	}
}
