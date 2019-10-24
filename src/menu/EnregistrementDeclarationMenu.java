package menu;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.declarations.Declaration;
import entity.declarations.Retour;
import entity.inscription.Inscription;
import entity.rallye.EditionRallye;
import entity.rallye.Etape;
import entity.rallye.Rallye;
import entity.rallye.Speciale;
import entity.declarations.Abandon;
import entity.declarations.Anomalie;
import entity.utilisateur.Coureur;
import factory.DaoFactory;
import utils.ScanUtils;

public class EnregistrementDeclarationMenu extends Menu{

	public static void menu(){

		List<Rallye> rallyes = DaoFactory.getRallyeDao().findAll();
		
		for(int i = 0; i< rallyes.size(); i++) {
			System.out.println( rallyes.get(i).getNom() + " / ( "+ (i + 1)+ ")");
		}
		
		System.out.println("Veuillez saisir le num de rallye ");
	    System.out.println(" " );
	    
	    int idR = ScanUtils.scanInt(1, rallyes.size(), false);
	    
	    
	    List<EditionRallye> lstEdition = DaoFactory.getEditionRallyeDao().findAllByRallyId(rallyes.get(idR -1).getId());
	    
	   
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
		
		
		List<Speciale> lstSpecial = DaoFactory.getSpecialDao().findAllByEtapeId(etape.getId());

	    
		
	    for (int i=0 ; i <lstSpecial.size(); i ++) {

	    	System.out.println("ordre spéciale : " + lstSpecial.get(i).getOrdre() + " / ( "+ (i + 1)+ ")");
	    }

	    System.out.println("Veuillez saisir l'ordre de spéciale");

	    System.out.println(" " );
	    int ordreS = lstSpecial.get(ScanUtils.scanInt(1, lstSpecial.size(), false) - 1).getOrdre();
	    
	    Speciale speciale = DaoFactory.getSpecialDao().findByEtapeIdAndOrdre(etape.getId(), ordreS);
	    
	    List<Coureur> coureurs = DaoFactory.getCoureurDao().findByEditionId(edition.getNumEdition()); 
    	
	    System.out.println("Liste des participants : ");
	    
	    for (int i=0 ; i <coureurs.size(); i ++) {

	    	System.out.println("coureur : " + coureurs.get(i).getNom() + " " + coureurs.get(i).getPrenom() + " / ( "+ (i + 1)+ ")");
	    }
	    
	    
	    
	    System.out.println(" Choisir coureur (1) / fin (2) ");
	    int coureurOuFin = ScanUtils.scanInt(1, 2, false);
	   
	    while (coureurOuFin == 1 ) {
		
		    System.out.println("Choisir numero coureur ");
	    	int numCoureurChoisi = ScanUtils.scanInt(1, coureurs.size(), false);
	    	Coureur coureurChoisi = coureurs.get(numCoureurChoisi - 1);
	    	
		    System.out.println("Veuillez selectionner le type de declaration : Abandon (1) / Retour(2) / Anomalie(3)");

	    	int typeDec = ScanUtils.scanInt(1, 3, false);

	    	try {
	    		switch (typeDec) {
	    		
	    		case 1 :
		    		DaoFactory.getDeclarationDao().create(new Abandon(coureurChoisi, speciale));
	    			break;
	    		case 2: 
	    			
		    		DaoFactory.getDeclarationDao().create(new Retour(coureurChoisi, speciale));
	    			break;
	    		case 3:

	    			System.out.println("Veuillez saisir une description");
	    		    String desct = ScanUtils.scanString(100, true);
		    		DaoFactory.getDeclarationDao().create(new Anomalie(coureurChoisi, speciale, desct));
	    			break;
	    		}
	    		
		
			} catch ( Exception e) {

				if (e instanceof SQLIntegrityConstraintViolationException)
				{
					System.out.println("declaration deja inscrite");
				} else
					System.out.println("Problème veuillez essayer plus tard");
			}
	    	
		    System.out.println("Choisir coureur (1) / fin (2) ");
		    coureurOuFin = ScanUtils.scanInt(1, 2, false);
		    
		    if (coureurOuFin == 1) {
			    for (int i=0 ; i <coureurs.size(); i ++) {

			    	System.out.println("coureur : " + coureurs.get(i).getNom() + " " + coureurs.get(i).getPrenom() + " / ( "+ (i + 1)+ ")");
			    }
			    
		    }
		    
	    }
	    CommissaireMenu.menu();
	    
	    	
	    
	    /*
	    for (int i=0 ; i <lstSpeciale.size(); i ++) {
	    	
	    }

		
	    //choisir spéciale de l'étape de l'�dition rallye  => afficher tous les coureurs participés
	    System.out.println(" " );
	    System.out.println("Veuillez choisir la spéciale de l'étape ");
	    System.out.println(" " );
	    
	    System.out.print("Ordre spéciale : ");
	    System.out.println(" " );
	  //  int ordreS = ScanUtils.scanInt(0, 20, false);
	    
	    
	    List<Courir> lstCourir = DaoFactory.getCourirDao().findAllBySpecialId(ordreS);//
	    
	    for (int i=0 ; i <lstCourir.size(); i ++) {
	    	
	    			    	
	    	System.out.println("Num coureur : " + lstCourir.get(i).getCoureur().getPrenom() );
	    }
        
		
	    //choisir coureur et ajouter les anomalies
	    System.out.println(" " );
	    System.out.println("Veuillez choisir le coureur participé ");
	    System.out.println(" " );
	    
	    System.out.print("Numéro coureur : ");
	    int idC = ScanUtils.scanInt(0, 20, false);
	    
	    System.out.println(" " );
	    System.out.println("Veuillez choisir le type des anomalies ");
	    System.out.println("Anomalies (1) / Coureur abandonné (2)/ Coureur retour (3) : ");
	    String typeA ;
	    		    
	    Scanner scanner = new Scanner(System.in);
	    
	    int choice = -1 ; 

		while (choice != 1 || choice != 2 || choice != 3) {
			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
	            System.out.println("Veuillez choisir entre [1 , 2, 3] ");
			}
			switch (choice) {
	        case 1:
	        	typeA = "anomalie";
	        	System.out.println(" " );
	        	System.out.println("Veuillez compl�ter la d�scription : ");
			    String descriptionA = ScanUtils.scanString(20, false);
			    
			    //DaoFactory.getDeclarationDao().insertDeclaration(typeA, descriptionA);
			    
	        	return;
	        case 2:
	        	typeA = "coureur abandonn�";
	        	System.out.println(" " );
	        	System.out.println("Veuillez compléter la d�scription : ");
			    descriptionA = ScanUtils.scanString(20, false);

			    //DaoFactory.getDeclarationDao().insertDeclaration(typeA, descriptionA);
	        	return;
	        case 3:
	            typeA = "coureur retour";
	            System.out.println(" " );
	            System.out.println("Veuillez compléter la d�scription : ");
			    descriptionA = ScanUtils.scanString(20, false);
			    
			    //DaoFactory.getDeclarationDao().insertDeclaration(typeA, descriptionA);
	        	return;
	        default:
	            System.out.println("Veuillez choisir entre [1 , 2, 3] ");
		
			}
		}*/
	}
}

