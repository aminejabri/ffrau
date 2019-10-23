package utils;

import entity.utilisateur.Utilisateur;
import entity.utilisateur.UtilisateurContexte;
import factory.DaoFactory;

public class ConnectionUtilite {

	
	public static void seConnecter(String login, String password) {
		
		Utilisateur utilisateur = DaoFactory.getUtilisateurDao().findByLoginAndPwd(login, password);
		
		if (utilisateur != null) {
			UtilisateurContexte.connecter(utilisateur);
		}
	}
}
