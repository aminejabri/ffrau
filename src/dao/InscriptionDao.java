package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.inscription.EtatInscription;
import entity.inscription.Inscription;
import entity.rallye.EditionRallye;
import entity.utilisateur.Coureur;
import entity.vehicule.Vehicule;
import factory.DaoFactory;

public class InscriptionDao extends AbstractDao<Inscription>{

	public InscriptionDao(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Inscription obj) {
		return false;
	}

	@Override
	public boolean delete(Inscription obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("delete from inscription where ins_num = ?");
			stm.setInt(1, obj.getNumero());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Inscription obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("update inscription set ins_etat = ? where ins_num = ?");
			stm.setString(1, obj.getEtat().name());
			stm.setInt(2, obj.getNumero());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Inscription find(int id) {
//		PreparedStatement stm;
//		try {
//			stm = connection.prepareStatement("SELECT * FROM inscription where ins_num = ?");
//			stm.setInt(1, id);
//			stm.execute();
//			ResultSet rs = stm.getResultSet();
//			
//			Coureur coureur = new Coureur();
//			Vehicule vehicule = null;
//			EditionRallye edition = new EditionRallye();
//			EtatInscription etat = null;
//			
//			
//			while (rs.next()) {
//				coureur =  DaoFactory.getCoureurDao().find(id);  
//				vehicule = new VehiculeDao(FrauConnection.getInstance()).find(rs.getInt(4));
//				edition = new EditionRallyeDao(FrauConnection.getInstance()).find(rs.getInt(5));  
//				etat = EtatInscription.valueOf(rs.getString(2));
//			}
//			
//			return new Inscription(coureur,vehicule, edition, etat);
//			
//		} catch (SQLException e) {		
//			e.printStackTrace();
//			return null;
//		}
		return null;
	}
	
	public Inscription find(int coureurId, int editionId) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM inscription where ins_cour_id = ? and ins_edi_ral_id = ?");
			stm.setInt(1, coureurId);
			stm.setInt(2, editionId);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			int numInsc = 0;
			Coureur coureur = null;
			Vehicule vehicule = null;
			EditionRallye edition = new EditionRallye();
			EtatInscription etat = null;
			
			
			while (rs.next()) {
				numInsc = rs.getInt(1) ;
				coureur =  DaoFactory.getCoureurDao().find(coureurId);  
				vehicule = DaoFactory.getVehiculeDao().find(rs.getInt(4));
				edition = DaoFactory.getEditionRallyeDao().find(editionId);  
				etat = EtatInscription.valueOf(rs.getString(2));
			}
			if(numInsc != 0) {
				
				return new Inscription(numInsc, coureur, vehicule, edition, etat);
			}
			
			else {
				return null;
			}
		} catch (SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}

	
	public List<Inscription> findByEtat(EtatInscription etat) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM inscription where ins_etat = ?");
			stm.setString(1, etat.name());
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			List<Inscription> results = new ArrayList<>();
					
			while (rs.next()) {
				
				results.add(new Inscription(rs.getInt(1),
						DaoFactory.getCoureurDao().find(rs.getInt(3)), 
						DaoFactory.getVehiculeDao().find(rs.getInt(4)),
						DaoFactory.getEditionRallyeDao().find(rs.getInt(5)),
						etat));
			}
			
			return results;
			
		} catch (SQLException e) {		
			
			e.printStackTrace();
			return null;
		}
	}

}
