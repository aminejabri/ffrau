package factory;

import dao.ConstructeurDao;
import dao.CoureurDao;
import dao.EditionRallyeDao;
import dao.EtapeDao;
import dao.InscriptionDao;
import dao.RallyeDao;
import dao.SpecialeDao;
import dao.UtilisateurDao;
import dao.VehiculeDao;
import utils.FrauConnection;

public class DaoFactory {

	
	static EditionRallyeDao editionDao;
	static VehiculeDao vehiculeDao;
	static EtapeDao etapeDao;
	static RallyeDao rallyeDao;
	static UtilisateurDao utilisateurDao;
	static SpecialeDao specialeDao;
	static CoureurDao coureurDao;
	static InscriptionDao inscriptionDao;
	static ConstructeurDao constructeurDao;
	
	public static ConstructeurDao getConstructeurDao() {
		
		if (constructeurDao == null) {
			constructeurDao = new ConstructeurDao(FrauConnection.getInstance());
		}
		
		return constructeurDao;
	}

	public static RallyeDao getRallyeDao() {
		
		if (rallyeDao == null) {
			rallyeDao = new RallyeDao(FrauConnection.getInstance());
		}
		
		return rallyeDao;
	}

	public static VehiculeDao getVehiculeDao() {
		
		if (vehiculeDao == null) {
			vehiculeDao = new VehiculeDao(FrauConnection.getInstance());
		}
		
		return vehiculeDao;
	}

	public static EditionRallyeDao getEditionRallyeDao() {
		
		if (editionDao == null) {
			editionDao = new EditionRallyeDao(FrauConnection.getInstance());
		}
		
		return editionDao;
	}
	
	public static EtapeDao getEtapeDao() {
		
		if (etapeDao == null) {
			etapeDao = new EtapeDao(FrauConnection.getInstance());
		}

		return etapeDao;
	}
	
	public static UtilisateurDao getUtilisateurDao() {
		
		if (utilisateurDao == null) {
			utilisateurDao = new UtilisateurDao(FrauConnection.getInstance());
		}
		
		return utilisateurDao;
	}
	
	public static SpecialeDao getSpecialDao() {
		
		if (specialeDao == null) {
			specialeDao = new SpecialeDao(FrauConnection.getInstance());
		}
		
		return specialeDao;
	}
	
	public static CoureurDao getCoureurDao() {
		
		if (coureurDao == null) {
			coureurDao = new CoureurDao(FrauConnection.getInstance());
		}
		
		return coureurDao;
	}
	
	public static InscriptionDao getInscriptionDao() {
		
		if (inscriptionDao == null) {
			inscriptionDao = new InscriptionDao(FrauConnection.getInstance());
		}
		
		return inscriptionDao;
	}
}
