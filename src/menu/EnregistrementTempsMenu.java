package menu;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.inscription.Inscription;
import entity.rallye.EditionRallye;
import entity.rallye.Etape;
import entity.rallye.Rallye;
import entity.rallye.Speciale;
import entity.rallye.deroulement.Courir;
import entity.utilisateur.Coureur;
import entity.vehicule.Vehicule;
import factory.DaoFactory;
import factory.ServiceFactory;
import utils.ScanUtils;

public class EnregistrementTempsMenu extends Menu{

	public static void menu(){

		List<Rallye> rallyes = DaoFactory.getRallyeDao().findAll();
		
		for(int i = 0; i< rallyes.size(); i++) {
			System.out.println( rallyes.get(i).getNom() + " / ( "+ (i + 1)+ ")");
		}
		
		System.out.println("Veuillez saisir le num de rallye ");
	    System.out.println(" " );
	    
	    int idR = rallyes.get(ScanUtils.scanInt(1, rallyes.size(), false) -1).getId();
	             
	    
	    List<EditionRallye> lstEdition = DaoFactory.getEditionRallyeDao().findAllByRallyId(idR);
	    
	   
	    for (int i=0 ; i <lstEdition.size(); i ++) {
				System.out.println( "edition num-" + lstEdition.get(i).getNumEdition() + " / ( "+ (i + 1)+ ")");
			}
	
		System.out.println("Veuillez saisir le num d'edition ");
	    System.out.println();
    
		int numEdi = ScanUtils.scanInt(1, lstEdition.size(), false);

		EditionRallye edition = lstEdition.get(numEdi - 1);
		
		List<Etape> lstEtape = DaoFactory.getEtapeDao().findAllByEditionId(edition.getNumEdition());

		etapee :
		while(true) {
			
		
		    for (int i=0 ; i <lstEtape.size(); i ++) {
	
		    	System.out.println("ordre étape : " + lstEtape.get(i).getOrdreE() + " / ( "+ (i + 1)+ ")");
		    }
		    
			int ordre = lstEtape.get(ScanUtils.scanInt(1, lstEtape.size(), false) - 1).getOrdreE();
	
			Etape etape = DaoFactory.getEtapeDao().findByEditionIdAndOrdre(edition.getNumEdition(), ordre);
			
			
			List<Speciale> lstSpecial = DaoFactory.getSpecialDao().findAllByEtapeId(etape.getId());
	
		    
			
	
		    retour:
		    while(true) {
			    for (int i=0 ; i <lstSpecial.size(); i ++) {
	
			    	System.out.println("ordre spéciale : " + lstSpecial.get(i).getOrdre() + " / ( "+ (i + 1)+ ")");
			    }
		    	
			    System.out.println("Veuillez saisir l'ordre de spéciale / (0) pour retour");
			    
		
			    System.out.println(" " );
			    int choiOredre = ScanUtils.scanInt(0, lstSpecial.size(), false);
			    
			    if (choiOredre == 0) {
			    	continue etapee;
			    }
			    
			    int ordreS = lstSpecial.get(choiOredre - 1).getOrdre();
		
			    
			    Speciale speciale = DaoFactory.getSpecialDao().findByEtapeIdAndOrdre(etape.getId(), ordreS);
			    
			    List<Coureur> coureurs = DaoFactory.getCoureurDao().findByEditionId(edition.getNumEdition()); 
		    	
			    System.out.println("Liste des participants : ");
			    
			    for (int i=0 ; i <coureurs.size(); i ++) {
		
			    	System.out.println("coureur : " + coureurs.get(i).getNom() + " " + coureurs.get(i).getPrenom() + " / ( "+ (i + 1)+ ")");
			    }
			    
			    
			    
			    System.out.println("Veuillez enregistrer temps des coureur : Choisir coureur (1) / fin (2)/ retour (3) ");
			    int coureurOuFin = ScanUtils.scanInt(1, 3, false);
			   
			    if( coureurOuFin == 2)
			    	break etapee;
			    else if (coureurOuFin == 3) {
			    	continue etapee;
			    }  
			    while (coureurOuFin == 1 && coureurs.size() > 0) {
				
				    System.out.println("Choisir numero coureur ");
			    	int numCoureurChoisi = ScanUtils.scanInt(1, coureurs.size(), false);
			    	System.out.println("saisir temps ");
			    	Coureur coureurChoisi = coureurs.get(numCoureurChoisi - 1);
			    	int  tempssaisie = ScanUtils.scanInt(1, speciale.getChonometrage().intValue(), false);
			  
			    	try {
				
			    		Vehicule vehicule = DaoFactory.getVehiculeDao().findByEditionAndCoureurId(edition.getNumEdition(), coureurChoisi.getId());
			    		DaoFactory.getCourirDao().create(new Courir(coureurChoisi, speciale, 
			    				tempssaisie * vehicule.calculerCoeff())); // ajouter retour ici si retour alors + 10
			    		coureurs.remove(coureurChoisi);
				
					} catch (SQLException e) {
						if(e instanceof SQLIntegrityConstraintViolationException)
							System.out.println("temps deja saisie");
		
						else 
							System.out.println("Problème veuillez essayer plus tard");
					}
			    	
				    System.out.println("Veuillez enregistrer temps des coureur : Choisir coureur (1) / fin (2) / retour (3) ");
				    
				    coureurOuFin = ScanUtils.scanInt(1, 3, false);
				    
				    if (coureurOuFin == 1) {
					    for (int i=0 ; i <coureurs.size(); i ++) {
		
					    	System.out.println("coureur : " + coureurs.get(i).getNom() + " " + coureurs.get(i).getPrenom() + " / ( "+ (i + 1)+ ")");
					    }
				    } else if (coureurOuFin == 3) {
				    	continue retour;
				    } else if (coureurOuFin == 2) {
				    	break etapee;
				    }
			    }
	
		    }
		}

	    CommissaireMenu.menu();
	}
}

