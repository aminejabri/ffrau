package menu;

import java.util.Date;

import dao.EtapeDao;
import entity.rallye.EditionRallye;
import entity.rallye.Etape;
import entity.rallye.Speciale;
import factory.DaoFactory;
import utils.ScanUtils;

public class CreationEtapeMenu {

	public static void menu() {
		
	}
	
	public static void menu(int editionId, int ordreEtape) {
		
		
	    System.out.println("Création de la " + ordreEtape + " ere \\ ème éptape");
	    System.out.println();
	    System.out.println("Veuillez renseigner les champs suivant : ");
	    System.out.println();
	    
	    System.out.print("Distance ");
	    Integer distance = ScanUtils.scanInt(10, 1000, false);
	    
	    System.out.print("niveau");
	    Integer niveau = ScanUtils.scanInt(1, 5, false);
	
	    try  {
	    	
			Etape etape = DaoFactory.getEtapeDao().save(new Etape(ordreEtape, distance.doubleValue() , niveau.toString(), DaoFactory.getEditionRallyeDao().find(editionId)));
	    	
	    	int ordre = 1;
	    	
	    	while (ordre != 0) {
	    		
	    		CreationSpecialeMenu.menu(etape.getId(), ordre);
	    		
	    		ordre++;
	    		System.out.println("voulez vous créer la "+ ordre + " ere \\ ème spéciale? (1) oui / non (0) : ");
	    		ordre = ScanUtils.scanInt(0, 1, false) == 0 ? 0 : ordre;
	    	}
	    	
	    	System.out.println("Etape bien enregistrée");

	    } catch(Exception e) {
	    	
	    	e.getStackTrace();
	    	System.out.println("Probleme d'insertion 10");
	    }
	
	}
}
