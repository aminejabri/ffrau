package menu;

import entity.rallye.Etape;
import entity.rallye.Speciale;
import factory.DaoFactory;
import utils.ScanUtils;

public class CreationSpecialeMenu {

	public static void menu(int etapeId, int ordre) {
		
		
	    System.out.println();
	    System.out.println("Création de la " + ordre + " ere \\ ème spéciale");
	    System.out.println();
	    System.out.println("Veuillez renseigner les champs suivant : ");
	    System.out.println();
	    
	    System.out.print("Distance ");
	    Integer distance = ScanUtils.scanInt(10, 1000, false);
	    
	    System.out.print("chrono");
	    Integer chrono = ScanUtils.scanInt(1, 1000, false);
	
	    try  {
	    	
	    	DaoFactory.getSpecialDao().save(new Speciale(ordre, distance.doubleValue() , chrono.doubleValue(), DaoFactory.getEtapeDao().find(etapeId)));
	    	
			System.out.println("Edition bien enregistrée");

	    } catch(Exception e) {
	    	System.out.println("Probleme d'insertion");
	    }
	
	}
}
