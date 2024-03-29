package service;

import java.util.Map;

import entity.rallye.EditionRallye;
import entity.rallye.Etape;
import entity.utilisateur.Coureur;
import entity.vehicule.Camion;
import entity.vehicule.Moto;
import entity.vehicule.TypeVehicule;
import entity.vehicule.Vehicule;
import entity.vehicule.Voiture;
import factory.DaoFactory;

public class ClassementService {

	Map <Integer, Coureur> classement;
	


	public Map <Integer, Coureur> recupererClassementEtape(Etape etape) {
		
		return DaoFactory.getEtapeDao().recuperClassementEtape(etape);
	}
	
	public Map <Integer, Coureur> recupererClassementEdition(EditionRallye edition) {
		
		return DaoFactory.getEditionRallyeDao().recuperClassementEtape(edition);
	}
	
}
