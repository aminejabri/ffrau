package app;


import dispatcher.RoleDispatcher;
import entity.utilisateur.UtilisateurContexte;
import menu.NonConnecteMenu;

public class MainMenu {

	public static void main(String[] args) {
	    
	    if (!UtilisateurContexte.connecte()) {

	    	NonConnecteMenu.menu();
	    } 
	    
	    if (UtilisateurContexte.connecte()) {

	    	RoleDispatcher.dispatch();
	    } 

	}
}
