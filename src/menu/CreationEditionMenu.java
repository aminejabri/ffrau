package menu;

import java.util.Date;
import java.util.List;
import java.util.Random;

import entity.rallye.EditionRallye;
import entity.rallye.Rallye;
import factory.DaoFactory;
import utils.ScanUtils;

public class CreationEditionMenu extends Menu {
 	
	
	public static void menu() {
		
		List<Rallye> rallyes = 	DaoFactory.getRallyeDao().findAll();
		
		for(int i = 0; i< 10; i++) {
			System.out.println( rallyes.get(i).getNom() + " / ( "+ (i + 1)+ ")");
		}
		
		System.out.println("Veuillez choisir un rallye en indiquangt son identifiant : ");
		int idRallye = ScanUtils.scanInt(1, rallyes.size(), false);
		menu(idRallye);
	}
	
	public static void menu(int idRallye) {

		
		System.out.println();

		System.out.println("Veuillez renseigner les champs suivant : ");
	    System.out.println();
	    
	    System.out.print("Date de début de l'edition du rallye : ");
	    Date debut = ScanUtils.scanDate();
	    System.out.println();

	    System.out.print("Date de Fin de l'edition du rallye : ");
	    Date fin = ScanUtils.scanDate();
	    
	    try  {
	    	
	    	EditionRallye edition = DaoFactory.getEditionRallyeDao().save(new EditionRallye(DaoFactory.getRallyeDao().find(idRallye), debut, fin));
	    	
	    	int ordre = 1;
	    	
	    	while (ordre != 0) {
	    		
	    		CreationEtapeMenu.menu(edition.getNumEdition(), ordre);
	    		
	    		System.out.println();
	    		ordre++;
	    		System.out.println("voulez vous créer la "+ ordre + "ème étape? (1) oui / non (0)");
	    		ordre = ScanUtils.scanInt(0, 1, false) == 0 ? 0 : ordre;
	    	}
	    	
	    	System.out.println("Edition bien enregistrée");

	    } catch(Exception e) {
	    	
	    	System.out.println(e);
	    	System.out.println("Probleme d'insertion");
	    }

		
	}
		
}