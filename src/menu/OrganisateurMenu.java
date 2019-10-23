package menu;

import java.util.Scanner;

import menu.classement.ClassementCoureurMenu;
import menu.rallye.InscriptionEditionMenu;
import utils.ScanUtils;

public class OrganisateurMenu {

	public static void menu() {
		
	    System.out.print("Validation d'inscription (1) / Consultations des classements annuels des coureurs et historique des classements (2):");

	    int choice = ScanUtils.scanInt(1, 2, false);
	    

		switch (choice) {
		case 1:
			ValidationInscriptionMenu.menu();
		    	break;
		    case 2:
		    	//ConsultationclassementMenu.menu();
		    	break;
		    
		    default:
		        System.out.println("Veuillez choisir entre [1 , 2] ");
		}
	}
}
