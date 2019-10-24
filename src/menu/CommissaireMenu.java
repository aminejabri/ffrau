package menu;

import utils.ScanUtils;

public class CommissaireMenu {

	public static void menu(){
		
		System.out.print("Enregister temps (1) /  enregistrer Declaration( 2) ");
	
	    
	    int choice = ScanUtils.scanInt(1, 2, false);
	
			switch (choice) {
	        case 1:
	        	EnregistrementTempsMenu.menu();
	        	return;
	        case 2:
	        	EnregistrementDeclarationMenu.menu();
	        	return;

	        default:
	            System.out.println("Veuillez choisir entre [1 , 2, 3] ");
			
			}
	}
}
