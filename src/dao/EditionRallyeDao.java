package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.rallye.EditionRallye;
import entity.rallye.Etape;
import entity.rallye.Rallye;
import factory.DaoFactory;

public class EditionRallyeDao extends AbstractDao<EditionRallye> {

	
	public EditionRallyeDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(EditionRallye obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into edition_rallye(edi_ral_id, edi_ral_date_deb, edi_ral_dare_fin) values(?,?,?)");
			stm.setInt(1, obj.getRallye().getId());
			stm.setDate(2, (java.sql.Date) obj.getDateDeb());
			stm.setDate(3, (java.sql.Date) obj.getDateFin());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(EditionRallye obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("delete from edition_rallye where id = ?");
			stm.setInt(1, obj.getNumEdition());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(EditionRallye obj) {
		
		try {
		
			PreparedStatement stm = connection.prepareStatement("update edition_rallye set edi_ral_id = ? , edi_ral_date_deb = ? , edi_ral_dare_fin = ?");
			stm.setInt(1, obj.getRallye().getId());
			stm.setDate(2, (java.sql.Date) obj.getDateDeb());
			stm.setDate(3, (java.sql.Date) obj.getDateFin());
			return stm.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false; 
		}
	}
	
	@Override
	public EditionRallye find(int id) {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM edition_rallye where id = ?");
			stm.setInt(1, id);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			Rallye rallye = new Rallye();
			Date debut = new Date();
			Date fin = new Date();
			List<Etape> etapes = DaoFactory.getEtapeDao().findAllByEditionId(id);
			while (rs.next()) {
				
				rallye = DaoFactory.getRallyeDao().find(rs.getInt(2));
				debut = rs.getDate(3);
				fin = rs.getDate(4);
				
			}
			
			return new EditionRallye(rallye, debut, fin, etapes);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public List<EditionRallye> findAllByRallyId(int rallyeId) {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM edition_rallye where edi_ral_id = ?");
			stm.setInt(1, rallyeId);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			List<EditionRallye> results = new ArrayList<>();
			
			while (rs.next()) {
				
				results.add(new EditionRallye(rs.getInt(1), rs.getDate(3), rs.getDate(4), 
						DaoFactory.getEtapeDao().findAllByEditionId(rs.getInt(1))));		
			}
			
			return results;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
