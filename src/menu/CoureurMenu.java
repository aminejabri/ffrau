package menu;

import java.util.Scanner;

import menu.classement.ClassementCoureurMenu;
import menu.rallye.InscriptionEditionMenu;

public class CoureurMenu {

	public static void menu() {
		
	    System.out.print("Inscription à un rallye (1) / Consultation classement(2) : ");

	    Scanner scanner = new Scanner(System.in);
	    
	    int choice = -1;

		while (choice != 1 || choice != 2) {
			choice = scanner.nextInt();
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
}
