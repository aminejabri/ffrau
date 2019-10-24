package menu.rallye;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import entity.inscription.EtatInscription;
import entity.inscription.Inscription;
import entity.rallye.EditionRallye;
import entity.rallye.Rallye;
import entity.utilisateur.Constructeur;
import entity.utilisateur.Coureur;
import entity.utilisateur.Utilisateur;
import entity.utilisateur.UtilisateurContexte;
import entity.vehicule.Camion;
import entity.vehicule.Moto;
import entity.vehicule.TypeVehicule;
import entity.vehicule.Vehicule;
import entity.vehicule.Voiture;
import factory.DaoFactory;
import menu.CoureurMenu;
import utils.ScanUtils;

public class InscriptionEditionMenu {

	public static void menu() {
		
		System.out.println("la liste des rallyes");

		List<Rallye> rallyes = DaoFactory.getRallyeDao().findAll();

		for (int i = 0; i < rallyes.size() ; i++) {
			System.out.println(rallyes.get(i).getNom() + "( " + (i + 1) + " ) ");
		}
		
		System.out.println(" ");
		System.out.println("Choisissez un rallye en entrant le num équivalent ");
		
		int ralchoisi = ScanUtils.scanInt(1, rallyes.size() , false) - 1;
		
		System.out.println("la liste des éditions");

		List<EditionRallye> editions = DaoFactory.getEditionRallyeDao().findAllByRallyId(rallyes.get(ralchoisi).getId());

		if (editions.size() == 0) {
			System.out.println("aucune edition en cours");
		} else {
			for (int i = 0; i < editions.size() ; i++) {
				System.out.println(editions.get(i).getNumEdition() + "( " + (i+1) + " ) ");
			}

			System.out.println(" ");
			System.out.println("Choisissez une edition ");
			
			int edichoisi = ScanUtils.scanInt(1, editions.size() , false) - 1;
			
			Coureur coureur = DaoFactory.getCoureurDao().findByUtilId(UtilisateurContexte.getUtilisateur().getId());
			if(coureur == null) {
				coureur = inscrireCoureur();
			} 
			System.out.println(" ");
			System.out.println("Coureur inscrit : " + DaoFactory.getCoureurDao().findByUtilId(UtilisateurContexte.getUtilisateur().getId()));
			
			Vehicule vehicule = inscrireVehicule();
			System.out.println("vehicule inscrit : " + DaoFactory.getVehiculeDao().find(vehicule.getId()));

			try {
				
				Inscription inscription = DaoFactory.getInscriptionDao().save(new Inscription(coureur, vehicule,editions.get(edichoisi), EtatInscription.DEMANDEE));
				System.out.println();
				System.out.println("Vous êtes bien inscrit à cette édition voici votre numero d'inscription : " + inscription.getNumero());
				System.out.println();
				System.out.println("Votre inscription est entrain de validation ");
				
				
			} catch (Exception e) {
				if(e instanceof SQLIntegrityConstraintViolationException)
					System.out.println(" vous êtes deja inscri à cette edition");
				else 
					System.out.println("probleme, veuillez ressayer plus tard");
			}
			CoureurMenu.menu();
		}

	}

	private static Vehicule inscrireVehicule() {
		
	    System.out.println("étape 2 : renseinger vehicule ");

	    System.out.print("choisir construceur: ");
	    
	    List<Constructeur> constructeurs = DaoFactory.getConstructeurDao().findAll();
		for (int i = 0; i < constructeurs.size() ; i++) {
			System.out.println(constructeurs.get(i).getNom() + "( " + (i+1) + " ) ");
		}
	    
	    Constructeur constructeur =constructeurs.get (ScanUtils.scanInt(1, constructeurs.size(), false) - 1);
	    
	    System.out.print("saisir Matricule :");
		   
	    String immatricule = ScanUtils.scanString(200, false);

	    System.out.print("choisir type: Moto (1),Voiture (2), Camion(3)   ");
	   
	    int t = ScanUtils.scanInt(1,3, false);

	    TypeVehicule type =  t == 1 ? TypeVehicule.MOTO : t == 2 ?  TypeVehicule.VOITURE : TypeVehicule.CAMION ;
	  
	    float poids;
	    float cylindre;
	    float puissance;
	    
	    Vehicule vehicule = null;
	    
	    switch(type) {
	    case MOTO:  
	    	System.out.print("saisir cylindre :"); 
	    	cylindre = ScanUtils.scanInt(400,600, false);
	    	vehicule = new Moto( immatricule, constructeur, cylindre);
	    	break;
	    case VOITURE: 
	    	System.out.print("saisir puissance :"); 
	    	puissance = ScanUtils.scanInt(260,400, false);
	    	vehicule = new Voiture( immatricule, constructeur, puissance);
	    	break;

	    case CAMION:
	    	System.out.print("saisir poid :"); 
	    	poids = ScanUtils.scanInt(1000,3000, false);
	    	vehicule = new Camion(immatricule, constructeur, poids);
	    	break;
	    }
	    
	    try {
			return DaoFactory.getVehiculeDao().save(vehicule);
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("probleme inscription vehicule");
			e.printStackTrace();
			return null ;
		}
	    
	}

	private static Coureur inscrireCoureur() {
	    System.out.println("étape 1 : renseinger coureur info");
	    

	    System.out.print("dateNaissence : ");
	    Date naissence = ScanUtils.scanDate();

	    System.out.print("groupe sanguin : 'O' (1) ,'A'(2),'B' (3)");	    
	    int groupe = ScanUtils.scanInt(1,3, false);
	    String groupeS = groupe == 1 ? "O" : groupe == 2 ?  "A" : "B" ;
	    
	    System.out.print("rhesus : 'PLUS'(1),'MOIN' (2)");
	    int rhesus = ScanUtils.scanInt(1,2, false);
	    String rhesuss = rhesus == 1 ? "PLUS" : "MOIN";
	    
	    Utilisateur user = UtilisateurContexte.getUtilisateur();
	    return DaoFactory.getCoureurDao().save(new Coureur(user, user.getNom(), user.getPrenom(), naissence, groupeS, rhesuss));

	}
}
