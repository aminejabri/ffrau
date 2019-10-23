package menu;

import java.util.List;
import java.util.Scanner;

import entity.inscription.EtatInscription;
import entity.inscription.Inscription;
import factory.DaoFactory;
import utils.ScanUtils;

public class ValidationInscriptionMenu {
	
	public static void menu() {
		
		System.out.println("consultez la liste d'inscription(1) / retour (2)");
		
		int choiceInc = ScanUtils.scanInt(0, 1, false);
		switch(choiceInc) {
		case 1:
			choisirInscription();
			
		case 2:
			OrganisateurMenu.menu();
		}
		
	}
	
	public static void choisirInscription() {

		System.out.println("la liste d'inscription");

			List<Inscription> inscriptions = DaoFactory.getInscriptionDao().findByEtat(EtatInscription.DEMANDEE);
					
			for (int i = 0; i < inscriptions.size() ; i++) {
				System.out.println(
						"insc num : " + inscriptions.get(i).getNumero() 
						+ " - coureur :" + inscriptions.get(i).getCoureur().getPrenom() 
						+" " + inscriptions.get(i).getCoureur().getPrenom()
						+" / (" + (i + 1)  + " )" ); 
				
			}
			
			System.out.println(" ");
			System.out.println("Choisissez une inscription en entrant le numéro d'inscription ");
			
			int choixInsc = ScanUtils.scanInt(1, inscriptions.size() , false);
			
			Inscription inscChosi = inscriptions.get(choixInsc - 1);
			
			System.out.println("incription numero : " + inscChosi.getNumero());

			// show coureur
			System.out.println(inscChosi.getCoureur());

			// show vehicule
			System.out.println(inscChosi.getVehicule());
			
			// show etat Validation
			System.out.println("état : " + inscChosi.getEtat());
			
			// 
			System.out.println("Valider (1) / Refuser (2) / retourner (3) : ");
			
			int choice_validation = ScanUtils.scanInt(1, 3, false);
			
			switch(choice_validation) {
			
			case 1:
				// update etat
				inscChosi.setEtat(EtatInscription.VALIDEE);
				DaoFactory.getInscriptionDao().update(inscChosi);
				break;
			case 2:
				inscChosi.setEtat(EtatInscription.REFUSEE);
				DaoFactory.getInscriptionDao().update(inscChosi);
				break;
			case 3:
				choisirInscription();
				return;
			}
			 

	}
}
		
		
		
