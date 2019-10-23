package menu;


import entity.utilisateur.UtilisateurContexte;
import utils.ConnectionUtilite;
import utils.ScanUtils;

public class ConnectionMenu extends Menu{
	
	public static void menu() {
	
		while(!UtilisateurContexte.connecte()) {
			
			seConnecter();
			if (!UtilisateurContexte.connecte()) {
				System.out.println(" login ou mot de passe incorrecte" );
			}
		}
		
		System.out.println(" Bonjour Monsieur : " + UtilisateurContexte.getUtilisateur().getNom());
		Menu.menu();
	}

	public static void seConnecter() {
		

		System.out.println(" Login : ");
		String login = ScanUtils.scanString(100, false);

		System.out.println(" Mot de passe : ");
		String password = ScanUtils.scanString(100, false);
		
		ConnectionUtilite.seConnecter(login, password);
		
	}
	
}
