package utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import entity.utilisateur.Role;

public class ScanUtils {
	
	static Scanner scanner2 = new Scanner(System.in);

	
	
	
	public static Role scanRole() {
		
	    boolean correctInput = false;
		
		while (!correctInput) {
			
			try {
				
				return Role.valueOf(scanner2.nextLine().toUpperCase());
				
			} catch (Exception e) {
				System.out.println("Valeur possibles : " + new ArrayList< Role>(Arrays.asList(Role.values())) );
			}
	    					
		}
		return null;
	}

	public static String scanString(int sizeLimit, boolean vide) {
	    
	    boolean correctInput = false;
		
	    String result = "";
	    
		while (!correctInput) {
			
			result = scanner2.nextLine();
	    	
			if ( result.length() <= sizeLimit && (vide || (!vide && result.length() > 0))) {
				correctInput = true;
			} else {
				if (result.length() > sizeLimit) { 
					
					System.out.println("taille limite de champs est : " + sizeLimit);
				} else if (!vide && result.length() == 0){
					
					System.out.println("ce champs ne peut pas �tre vide : ");
				}
				
			}
		}
		
		return result;
	}

	public static Date  scanDate() {
	    
		
		System.out.println("jour : ");
		int jour = scanInt(1, 31, false);
		
		System.out.println("mois : ");
		int mois = scanInt(1, 12, false);

		System.out.println("annee : ");
		int annee = scanInt(1970, 2100, false);

	
	    return new GregorianCalendar(annee, mois, jour).getTime();
	}

	public static int scanInt(int min, int max, boolean vide) {
	    
	    boolean correctInput = false;
		
	    String result = "";
		int intReslut = Integer.MIN_VALUE;

		while (!correctInput) {
			
			result = scanner2.nextLine();
			try {
			
				intReslut = Integer.parseInt(result);
			
			} catch (Exception e) {
				
				correctInput = false;
			}
			
			if ( !vide && (intReslut >= min && intReslut <= max)  || vide ) {
				correctInput = true;
			} else {
					
					
					System.out.println("ce champs doit être entre : " + min +" et " + max);
				}
				
			}
		
		return intReslut;
	}


}
