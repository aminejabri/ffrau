package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import entity.utilisateur.Constructeur;
import entity.utilisateur.Coureur;
import entity.utilisateur.Utilisateur;
import entity.vehicule.Camion;
import entity.vehicule.Moto;
import entity.vehicule.TypeVehicule;
import entity.vehicule.Voiture;
import factory.DaoFactory;

public class CoureurDao extends AbstractDao<Coureur>{

	public CoureurDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Coureur obj) throws SQLIntegrityConstraintViolationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Coureur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Coureur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coureur find(int id) {
		PreparedStatement stm;
		try {
				stm = connection.prepareStatement("SELECT * FROM coureur where id = ?");
				stm.setInt(1, id);   //? commence par 1
				stm.execute();
				ResultSet rs = stm.getResultSet();
				
				int idCour = 0;
				String nom = "";
				String prenom = "";
				Date naissance = null;
				String groupeSang = "";
				String rhesus = "";
				Utilisateur user= null;
				while (rs.next()) {
					
					idCour = rs.getInt(1);
					user = DaoFactory.getUtilisateurDao().find(rs.getInt(2));
					nom = rs.getString(3);
					prenom = rs.getString(4);
					naissance = rs.getDate(5);
					groupeSang = rs.getString(6);
					rhesus = rs.getString(7);
				}
				
				if (idCour != 0)
					return new Coureur(idCour, user, nom, prenom, naissance, groupeSang, rhesus);
				else
					return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
