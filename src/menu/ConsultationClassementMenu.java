package menu;

import utils.ScanUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.rallye.*;
import factory.DaoFactory;
import factory.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class ConsultationClassementMenu {
	public static void main(String[] args) {

        System.out.println("classement par etape (1) / classement par édition (2)");

		
	    int choice = ScanUtils.scanInt(1, 2, false);

	    switch (choice) {
	        case 1:
	        	classementEtape();
	        	return;
	        case 2:
	        	classementEdition();
	        	return;
		
		}

		
	}
	
	public static void classementEtape() {

        System.out.println("Liste Rallye");

		List<Rallye> rallyes = DaoFactory.getRallyeDao().findAll();
		
		System.out.println("Veuillez num rallye ");
		
		for(int i = 0; i< 10; i++) {
			System.out.println( rallyes.get(i).getNom() + " / ( "+ (i + 1)+ ")");
		}
		
		System.out.println("Veuillez saisir le num de rallye ");
	    System.out.println(" " );
	    
	    int idR = ScanUtils.scanInt(1, rallyes.size(), false);
	             
	    
	    List<EditionRallye> lstEdition = DaoFactory.getEditionRallyeDao().findAllByRallyId(idR);
	    
	   
	    for (int i=0 ; i <lstEdition.size(); i ++) {
				System.out.println( "edition num-" + lstEdition.get(i).getNumEdition() + " / ( "+ (i + 1)+ ")");
			}
	
		System.out.println("Veuillez saisir le num d'edition ");
	    System.out.println();
    
		int numEdi = ScanUtils.scanInt(1, lstEdition.size(), false);

		EditionRallye edition = lstEdition.get(numEdi - 1);
		

		List<Etape> lstEtape = DaoFactory.getEtapeDao().findAllByEditionId(edition.getNumEdition());

		
	    for (int i=0 ; i <lstEtape.size(); i ++) {

	    	System.out.println("ordre étape : " + lstEtape.get(i).getOrdreE() + " / ( "+ (i + 1)+ ")");
	    }
	    
		int ordre = lstEtape.get(ScanUtils.scanInt(1, lstEdition.size(), false) - 1).getOrdreE();

		Etape etape = DaoFactory.getEtapeDao().findByEditionIdAndOrdre(edition.getNumEdition(), ordre);
		
		ServiceFactory.getClassementService().recupererClassementEtape(etape);
		
	}
	
	public static void classementEdition() {

		System.out.println("Liste Rallye");

		List<Rallye> rallyes = DaoFactory.getRallyeDao().findAll();
		
		System.out.println("Veuillez num rallye ");

		for(int i = 0; i< 10; i++) {
			System.out.println( rallyes.get(i).getNom() + " / ( "+ (i + 1)+ ")");
		}
		
		System.out.println("Veuillez saisir le num de rallye ");
	    System.out.println(" " );
	    
	    int idR = ScanUtils.scanInt(1, rallyes.size(), false);
	             
	    
	    List<EditionRallye> lstEdition = DaoFactory.getEditionRallyeDao().findAllByRallyId(idR);
	    
	   
	    for (int i=0 ; i <lstEdition.size(); i ++) {
				System.out.println( "edition num-" + lstEdition.get(i).getNumEdition() + " / ( "+ (i + 1)+ ")");
			}
	
		System.out.println("Veuillez saisir le num d'edition ");
	    System.out.println();
    
		int numEdi = ScanUtils.scanInt(1, lstEdition.size(), false);

		EditionRallye edition = lstEdition.get(numEdi - 1);
		
		ServiceFactory.getClassementService().recupererClassementEdition(edition);
		
	}
}
