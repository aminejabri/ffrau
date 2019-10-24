package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.declarations.Abandon;
import entity.declarations.Anomalie;
import entity.declarations.Declaration;
import entity.declarations.Retour;
import entity.declarations.TypeDeclaration;
import factory.DaoFactory;

public class DeclarationDao extends AbstractDao<Declaration>{

	public DeclarationDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Declaration obj) throws Exception {
			
		try {
				PreparedStatement stm = connection.prepareStatement("insert into declaration(dec_spe_id, dec_cour_id, dec_type) values(?,?,?)");
				stm.setInt(1,  obj.getSpeciale().getId());
				stm.setInt(2,  obj.getCoureur().getId());
				stm.setString(3,  obj.getType().name());
				return stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public boolean delete(Declaration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Declaration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Declaration find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public List<Declaration> findByEditionAndCoureur(int specialeId, int coureurId) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM declaration where dec_spe_id = ? and dec_cour_id = ?");
			stm.setInt(1, specialeId);
			stm.setInt(2, coureurId);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			List<Declaration> results = new ArrayList<>();
			
			TypeDeclaration type  = null;
			
			while (rs.next()) {
				
				type = TypeDeclaration.valueOf(rs.getString(3));
				
				switch(type)  {
				case Abandon : results.add( new Abandon( DaoFactory.getCoureurDao().find(coureurId), DaoFactory.getSpecialDao().find(specialeId)));break;
				case Anomalie : results.add( new Anomalie(DaoFactory.getCoureurDao().find(coureurId), DaoFactory.getSpecialDao().find(specialeId),rs.getString(4)));break;
				case Retour : results.add( new Retour( DaoFactory.getCoureurDao().find(coureurId), DaoFactory.getSpecialDao().find(specialeId)));break;
					
				}
			
			}	
				return results;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}

}
