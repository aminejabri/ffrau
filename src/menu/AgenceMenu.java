package menu;


import utils.ScanUtils;

public class AgenceMenu {
 
public static void menu() {
		
	    System.out.print("Creation d'un nouveau rallye (1) /  Creation edition d'un rallye( 2) ");

	    
	    int choice = ScanUtils.scanInt(1, 2, false);

			switch (choice) {
	        case 1:
	        	CreationRallyeMenu.menu();
	        	return;
	        case 2:
	        	CreationEditionMenu.menu();
	        	return;
	        case 3:
	        	AjouterConstructeurMenu.menu();
	        	return;
	        default:
	            System.out.println("Veuillez choisir entre [1 , 2, 3] ");
		
			}

	}
}
