package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import entity.rallye.Speciale;
import entity.utilisateur.Constructeur;
import entity.utilisateur.Role;
import entity.utilisateur.Utilisateur;
import entity.vehicule.Camion;
import entity.vehicule.Moto;
import entity.vehicule.TypeVehicule;
import entity.vehicule.Voiture;
import factory.DaoFactory;

public class ConstructeurDao extends AbstractDao<Constructeur>{

	public ConstructeurDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Constructeur obj) throws SQLIntegrityConstraintViolationException {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into constructeur ( cons_nom, cons_uti_id, cons_adr, cons_pays) values(?,?,?,?)");
			stm.setString(1, obj.getNom());
			stm.setInt(2, obj.getUtilisateur().getId());
			stm.setString(3, obj.getAddresse());
			stm.setString(4, obj.getPays());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Constructeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Constructeur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Constructeur find(int id) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM constructeur where id = ?");
			stm.setInt(1, id);   //? commence par 1
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			int idConst = 0;
			String nom = "";
			String pays = "";
			String addresse = "";
			Utilisateur user= null;
			while (rs.next()) {
				
				idConst = rs.getInt(1);
				nom = rs.getString(2);
				addresse = rs.getString(5);
				pays = rs.getString(5);
				user = DaoFactory.getUtilisateurDao().find(rs.getInt(3));
			}
			
			if (idConst != 0)
				return new Constructeur(id, nom, addresse, pays, user);
			else
				return null;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Constructeur>  findAll() {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM constructeur");
			stm.execute();
			ResultSet rs = stm.getResultSet();
			List<Constructeur> results = new ArrayList<>();
			
			while (rs.next()) {
				
				results.add(new Constructeur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), new Utilisateur("", "", "", "", Role.CONSTRUCTEUR)) );		
			}
			
			return results;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
