package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import entity.rallye.EditionRallye;
import entity.rallye.Etape;
import entity.utilisateur.Role;
import entity.utilisateur.Utilisateur;

public class UtilisateurDao extends AbstractDao<Utilisateur>{

	public UtilisateurDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Utilisateur utilisateur) throws SQLIntegrityConstraintViolationException {
		
		 try {
			 
			PreparedStatement stm = connection.prepareStatement("insert into utilisateur ("
					+ "user_nom , user_prenom , user_login , user_password , user_role"
					+ ") values (?,?,?,?,?)");
			
			stm.setString(1, utilisateur.getNom());
			stm.setString(2, utilisateur.getPrenom());
			stm.setString(3, utilisateur.getLogin());
			stm.setString(4, utilisateur.getPassword());
			stm.setString(5, utilisateur.getRole().name());
			return stm.execute();
					
		} catch (SQLException e) {
		
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilisateur obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("update utilisateur set user_nom = ? , user_prenom = ? , user_login = ? , user_password = ? , user_role = ?");
			stm.setString(1, obj.getNom());
			stm.setString(2, obj.getPrenom());
			stm.setString(3, obj.getLogin());
			stm.setString(4, obj.getPassword());
			stm.setString(5, obj.getRole().toString());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Utilisateur find(int id) {
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM utilisateur where id = ? ");
			stm.setInt(1, id);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			String nom = "";
			String prenom = "";
			String login = "";
			String psw = "";
			Role role = null;
			while (rs.next()) {
				
				nom = rs.getString(2);
				prenom = rs.getString(3);
				role = Role.valueOf(rs.getString(6));
				login = rs.getString(4);
				psw =  rs.getString(5);
			}
			
			if (id != 0) {
				return new Utilisateur(id ,nom, prenom, login, psw, role);

			} else {
				return null;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public Utilisateur findByLoginAndPwd(String login, String psw) {
		
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM utilisateur where user_login = ? and user_password = ?");
			stm.setString(1, login);
			stm.setString(2, psw);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			int id = 0;
			String nom = "";
			String prenom = "";
			Role role = null;
			while (rs.next()) {
				
				id = rs.getInt(1);
				nom = rs.getString(2);
				prenom = rs.getString(3);
				role = Role.valueOf(rs.getString(6));
			}
			
			if (id != 0) {
				return new Utilisateur(id ,nom, prenom, login, psw, role);

			} else {
				return null;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public Utilisateur findByLogin(String login) {
		
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM utilisateur where user_login = ?");
			stm.setString(1, login);
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			int id = 0;
			String nom = "";
			String prenom = "";
			String pwd = "";
			Role role = null;
			while (rs.next()) {
				
				id = rs.getInt(1);
				nom = rs.getString(2);
				prenom = rs.getString(3);
				pwd = rs.getString(5);
				role = Role.valueOf(rs.getString(6));
			}
			
			if (id != 0) {
				return new Utilisateur(id ,nom, prenom, login, pwd, role);

			} else {
				return null;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
