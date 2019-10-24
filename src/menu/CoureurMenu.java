package menu;

import java.util.Scanner;


import menu.classement.ClassementCoureurMenu;
import menu.rallye.InscriptionEditionMenu;
import utils.ScanUtils;

public class CoureurMenu {

	public static void menu() {
		
	    System.out.print("Inscription à un rallye (1) / Consultation classement(2) : ");

	    
	    int choice = ScanUtils.scanInt(1, 2, false);

			switch (choice) {
	        case 1:
	        	InscriptionEditionMenu.menu();
	        	return;
	        case 2:
	        	ClassementCoureurMenu.menu();
	        	return;
	        default:
	            System.out.println("Veuillez choisir entre [1 , 2] ");
		
			}
		}

}
