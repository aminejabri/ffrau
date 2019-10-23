package entity.utilisateur;

public class UtilisateurContexte {

	private static boolean connected = false;
	
	private static Utilisateur  utilisateur;
	
	public static void connecter(Utilisateur user) {
		
		utilisateur = user;
		connected = true;
	}
	
	public static void deconnecter(Utilisateur user) {
		
		utilisateur = null;
		connected = false;
	}
	
	public static Utilisateur getUtilisateur() {
		
		return utilisateur;
	}
	
	public static boolean connecte() {
		
		return connected;
	}
}
