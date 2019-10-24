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
			break;
			
			case COUREUR:
			MenuByRole.coureurMenu();
			break;
				
			case COMMISSAIRE:
			MenuByRole.commissaireMenu();
			break;
				
			case CONSTRUCTEUR:
			MenuByRole.constructeurMenu();
			break;
				
			case ORGANISATEUR:
			MenuByRole.organisateurMenu(); 
			break;
				
			case JURY:
			MenuByRole.juryMenu();
			break;
		}
	}
}
