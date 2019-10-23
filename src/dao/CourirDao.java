package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import entity.rallye.Speciale;
import entity.rallye.deroulement.Courir;
import entity.utilisateur.Coureur;
import factory.DaoFactory;

public class CourirDao extends AbstractDao<Courir>{

	public CourirDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Courir obj) throws SQLIntegrityConstraintViolationException {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into courir ( couri_cour_id, couri_spe_id, couri_tmp_id) values(?,?,?)");
			stm.setInt(1, obj.getCoureur().getId());
			stm.setInt(2, obj.getSpeciale().getId());
			stm.setDouble(3, obj.getTemps());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Courir obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Courir obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public Courir find(int idCoureur, int idSpeciale) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM courir where couri_cour_id = ? and couri_spe_id = ? ");
			stm.setInt(1, idCoureur);   // 
			stm.setInt(1, idSpeciale);   // 
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			Double temps = 0.;
			Coureur coureur = DaoFactory.getCoureurDao().find(idCoureur);
			Speciale speciale = DaoFactory.getSpecialDao().find(idSpeciale);
			while (rs.next()) {
				temps = rs.getDouble(3);
			}
			
				return new Courir(coureur, speciale, temps);
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Courir find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Courir> findAllBySpecialId(int idSpeciale) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM courir where couri_spe_id = ? ");
			stm.setInt(1, idSpeciale);   // 
			stm.execute();
			ResultSet rs = stm.getResultSet();

			Speciale speciale = DaoFactory.getSpecialDao().find(idSpeciale);
			List<Courir> results = new ArrayList<>();
			while (rs.next()) {
				
				results.add(new Courir(DaoFactory.getCoureurDao().find(rs.getInt(1)), speciale, rs.getDouble(3)));
			}
			
				return results;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
