package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.rallye.Etape;
import entity.rallye.Speciale;
import factory.DaoFactory;

public class SpecialeDao extends AbstractDao<Speciale>{

	public SpecialeDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Speciale obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into speciale(spe_ordrespe, spe_eta_id, spe_distancespe, spe_chronometrage) values(?,?,?,?)");
			stm.setInt(1, obj.getOrdreS());
			stm.setInt(2, obj.getEtape().getId());
			stm.setDouble(3, obj.getDistance());
			stm.setDouble(4, obj.getChonometrage());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Speciale obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("delete from speciale where id = ?");
			stm.setInt(1, obj.getId());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Speciale obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("update speciale set spe_ordrespe = ? , spe_eta_id = ? , spe_distancespe = ? , spe_chronometrage = ? ");
			stm.setInt(1, obj.getOrdreS());
			stm.setInt(2, obj.getEtape().getId());
			stm.setDouble(3, obj.getDistance());
			stm.setDouble(4, obj.getChonometrage());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Speciale find(int id) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM speciale where id = ?");
			stm.setInt(1, id);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			Etape etape = null;
			int ordre = 0;
			Double distance = 0.;
			Double chrono = 0.;
			while (rs.next()) {
				
				etape = DaoFactory.getEtapeDao().find(rs.getInt(2));
				ordre = rs.getInt(3);
				distance = rs.getDouble(4);
				chrono = rs.getDouble(5);
			}
			
			return new Speciale(id, ordre, distance, chrono, etape);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Speciale> findAllByEtapeId(int etapeId) {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM speciale where spe_eta_id = ?");
			stm.setInt(1, etapeId);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			List<Speciale> results = new ArrayList<>();
			
			while (rs.next()) {
				
				results.add(new Speciale(rs.getInt(1), rs.getInt(2), rs.getDouble(4), rs.getDouble(5)));		
			}
			
			return results;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}


	public Speciale findByEtapeIdAndOrdre(int etapeId, int ordre) {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM speciale where spe_eta_id = ? and spe_ordrespe = ?");
			stm.setInt(1, etapeId);
			stm.setInt(2, ordre);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			Speciale result = null;
			
			while (rs.next()) {
				
				result = new Speciale(rs.getInt(1), rs.getInt(2), rs.getDouble(4), rs.getDouble(5));		
			}
			
			return result;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}


}
