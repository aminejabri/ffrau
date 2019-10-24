package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.rallye.EditionRallye;
import entity.rallye.Etape;
import entity.rallye.Rallye;
import entity.utilisateur.Coureur;
import factory.DaoFactory;

public class EditionRallyeDao extends AbstractDao<EditionRallye> {

	
	public EditionRallye save(EditionRallye obj) {
		
		try {
			PreparedStatement stm = connection.prepareStatement("insert into edition_rallye(edi_ral_id, edi_ral_date_deb, edi_ral_dare_fin) values(?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1, obj.getRallye().getId());
			stm.setDate(2, new java.sql.Date(obj.getDateDeb().getTime()) );
			stm.setDate(3, new java.sql.Date(obj.getDateFin().getTime()));
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next())
				obj.setNumEdition(rs.getInt(1));
			if (obj.getNumEdition() != 0) {
				
				return obj;
			} else {
				return null;
			}
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	
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
			
			int num = 0;
			Rallye rallye = new Rallye();
			Date debut = new Date();
			Date fin = new Date();
			List<Etape> etapes = DaoFactory.getEtapeDao().findAllByEditionId(id);
			while (rs.next()) {
				
				num = rs.getInt(1);
				rallye = DaoFactory.getRallyeDao().find(rs.getInt(2));
				debut = rs.getDate(3);
				fin = rs.getDate(4);
				
			}
			
			return new EditionRallye(num, rallye, debut, fin, etapes);
			
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

	public Map<Integer, Coureur> recuperClassementEtape(EditionRallye obj) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT c.couri_cour_id, ");
			sb.append("       Sum(c.couri_tmp_id) AS tempsParEdition  ");
			sb.append("FROM   speciale s,  ");
			sb.append("       etape e,  ");
			sb.append("		edition_rallye ed,  ");
			sb.append("       courir c  ");
			sb.append("WHERE  s.spe_eta_id = e.id  ");
			sb.append("       AND s.id = c.couri_spe_id ");
			sb.append("       AND e.eta_edi_id = ed.id ");
			sb.append("and ed.id = ? ");
			sb.append("GROUP  BY c.couri_cour_id  ");
			sb.append("ORDER  BY 2 ASC ");

			PreparedStatement stm = connection.prepareStatement(sb.toString());
			stm.setInt(1, obj.getNumEdition());
			
			stm.execute();
			ResultSet rs  = stm.getResultSet();
			
			Map<Integer, Coureur> resultats = new HashMap<>();
			while(rs.next())
				resultats.put(rs.getRow(), DaoFactory.getCoureurDao().find(rs.getInt(1)));
			
			return resultats;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

}
