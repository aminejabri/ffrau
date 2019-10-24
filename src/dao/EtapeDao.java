package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.rallye.EditionRallye;
import entity.rallye.Etape;
import entity.rallye.Rallye;
import entity.utilisateur.Coureur;
import factory.DaoFactory;

public class EtapeDao extends AbstractDao<Etape>{

	
	public EtapeDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Etape obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into etape(eta_edi_id, eta_ordre, eta_distance, eta_niveau) values(?,?,?,?)");
			stm.setInt(1, obj.getEdition().getNumEdition());
			stm.setInt(2, obj.getOrdreE());
			stm.setDouble(3, obj.getDistanceE());
			stm.setString(4, obj.getNiveau());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Etape obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("delete from etape where id = ? ");
			stm.setInt(1, obj.getId());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Etape obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("update etape set eta_edi_id = ? , eta_ordre = ? , eta_distance = ? , eta_niveau = ? ");
			stm.setInt(1, obj.getEdition().getNumEdition());
			stm.setInt(2, obj.getOrdreE());
			stm.setDouble(3, obj.getDistanceE());
			stm.setString(4, obj.getNiveau());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Etape find(int id) {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM etape where id = ?");
			stm.setInt(1, id);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			EditionRallye edition = new EditionRallye();
			int idEtape = 0;
			int order = 0;
			Double duratation = 0.;
			String niveau = "";
			while (rs.next()) {
				
				idEtape = rs.getInt(1);
				edition = DaoFactory.getEditionRallyeDao().find(rs.getInt(2));
				order = rs.getInt(3);
				duratation = rs.getDouble(4);
				niveau = rs.getString(5);
			}
			
			return new Etape(idEtape ,order, duratation, niveau, edition, DaoFactory.getSpecialDao().findAllByEtapeId(id));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public List<Etape> findAllByEditionId(int editionId) {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM etape where eta_edi_id = ?");
			stm.setInt(1, editionId);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			List<Etape> results = new ArrayList<>();
			
			while (rs.next()) {
				
				results.add(new Etape(rs.getInt(1), rs.getInt(3), rs.getDouble(4), rs.getString(5), 
						DaoFactory.getSpecialDao().findAllByEtapeId(rs.getInt(3))));		
			}
			
			return results;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public Etape findByEditionIdAndOrdre(int editionId, int ordre) {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM etape where eta_edi_id = ? and eta_ordre = ?");
			stm.setInt(1, editionId);
			stm.setInt(2, ordre);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			Etape results = null;
			
			while (rs.next()) {
				
				results = new Etape(rs.getInt(1), rs.getInt(3), rs.getDouble(4), rs.getString(5), 
						DaoFactory.getSpecialDao().findAllByEtapeId(rs.getInt(3)));		
			}
			
			return results;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public Etape save(Etape obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into etape(eta_edi_id, eta_ordre, eta_distance, eta_niveau) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setInt(1, obj.getEdition().getNumEdition());
			stm.setInt(2, obj.getOrdreE());
			stm.setDouble(3, obj.getDistanceE());
			stm.setString(4, obj.getNiveau());
			
			stm.execute();
			ResultSet rs = stm.getGeneratedKeys();
			
			if(rs.next())
				obj.setId(rs.getInt(1)); 
			
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public Map<Integer, Coureur> recuperClassementEtape(Etape obj) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT c.couri_cour_id, ");
			sb.append("       Sum(c.couri_tmp_id) AS tempsParEdition  ");
			sb.append("FROM   speciale s,  ");
			sb.append("       etape e,  ");
			sb.append("       courir c  ");
			sb.append("WHERE  s.spe_eta_id = e.id  ");
			sb.append("       AND s.id = c.couri_spe_id ");
			sb.append("and e.id = ? ");
			sb.append("GROUP  BY c.couri_cour_id  ");
			sb.append("ORDER  BY 2 ASC ");

			PreparedStatement stm = connection.prepareStatement(sb.toString());
			stm.setInt(1, obj.getId());
			
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
