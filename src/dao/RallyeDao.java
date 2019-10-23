package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.rallye.EditionRallye;
import entity.rallye.Rallye;
import factory.DaoFactory;

public class RallyeDao extends AbstractDao<Rallye> {

	
	public RallyeDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Rallye obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into rallye(ral_nom, ral_ville, ral_pays) values(?,?,?)");
			stm.setString(1, obj.getNom());
			stm.setString(2, obj.getVille());
			stm.setString(3, obj.getPays());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Rallye obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("update rallye set id = ? ");
			stm.setInt(1, obj.getId());
			return stm.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		return false;
		}
	}

	@Override
	public boolean update(Rallye obj) {
		try {
				PreparedStatement stm = connection.prepareStatement("update rallye set ral_nom = ? , ral_ville = ? , ral_pays = ?");
				stm.setString(1, obj.getNom());
				stm.setString(2, obj.getVille());
				stm.setString(3, obj.getPays());
				return stm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public Rallye find(int id) {

		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM rallye where id = ?");
			stm.setInt(1, id);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			String nom = "";
			String ville = "";
			String pays = "";
			int idRallye = 0;
			while (rs.next()) {
				nom = rs.getString(2);
				ville = rs.getString(3);
				pays = rs.getString(4);
				idRallye = rs.getInt(1);
			}
			
			if (idRallye == 0) {
				
				return null;
			} else {
				return new Rallye(nom, ville, pays, DaoFactory.getEditionRallyeDao().findAllByRallyId(idRallye));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public List<Rallye> findAll() {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM rallye ");
			stm.execute();
			ResultSet rs = stm.getResultSet();
			List<Rallye> results = new ArrayList<>();
			
			while (rs.next()) {
				
				results.add(new Rallye(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));		
			}
			
			return results;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}



}
