package menu;

import utils.ScanUtils;

public class JuryMenu {


	public static void menu() {
		

		System.out.print("Consultation Classemenent(1)");
	
	    
	    int choice = ScanUtils.scanInt(1, 1, false);
	
			switch (choice) {
	        case 1:
	        	ConsultationClassementMenu.menu();
	        	return;
		
			}
	}
}
