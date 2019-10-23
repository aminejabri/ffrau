package dispatcher;

import entity.utilisateur.Role;
import entity.utilisateur.UtilisateurContexte;
import menu.MenuByRole;

public class RoleDispatcher {


	public static void dispatch() {
	
		Role role = UtilisateurContexte.getUtilisateur().getRole();
		
		switch (role) {
			case AGENCE :
			MenuByRole.agenceMenu(); 
			
			case COUREUR:
			MenuByRole.coureurMenu();
				
			case COMMISSAIRE:
			MenuByRole.commissaireMenu();
				
			case CONSTRUCTEUR:
			MenuByRole.constructeurMenu();
				
			case ORGANISATEUR:
			MenuByRole.organisateurMenu(); 
				
			case JURY:
			MenuByRole.juryMenu();
		}
	}
}
