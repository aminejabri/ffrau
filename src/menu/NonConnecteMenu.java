package menu;

import utils.ScanUtils;

public class NonConnecteMenu extends Menu {

	public static void menu(){
			
	    System.out.print("Connectez vous (1) / Inscrivez vous (2) : ");

	    
	    int choice = ScanUtils.scanInt(1, 2, false);

	    switch (choice) {
	        case 1:
	        	ConnectionMenu.menu();
	        	return;
	        case 2:
	        	InscriptionMenu.menu();
	        	return;
	        default:
	            System.out.println("Veuillez choisir entre [1 , 2] ");
		
		}
	}
}
