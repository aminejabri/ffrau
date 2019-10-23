package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import entity.utilisateur.Constructeur;
import entity.vehicule.Camion;
import entity.vehicule.Moto;
import entity.vehicule.TypeVehicule;
import entity.vehicule.Vehicule;
import entity.vehicule.Voiture;
import factory.DaoFactory;

public class VehiculeDao extends AbstractDao<Vehicule>{

	public VehiculeDao(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Vehicule obj) throws SQLIntegrityConstraintViolationException {
		try {
			PreparedStatement stm = connection.prepareStatement("insert into vehicule(veh_const_id, veh_immatriculation, veh_type, veh_puissance, veh_poid, veh_cylindre) values(?,?,?,?,?,?)");
			stm.setInt(1, obj.getConstructeur().getId());
			stm.setString(2, obj.getImmatriculation());
			stm.setString(3, obj.getType().name());
			
			if(obj instanceof Voiture) {
				stm.setFloat(4, ((Voiture) obj).getPuissance());
				stm.setString(5, null);
				stm.setString(6, null);
			}
			else if(obj instanceof Camion) {
				stm.setString(4, null);
				stm.setFloat(5, ((Camion) obj).getPoid());
				stm.setString(6, null);
			}
			else if(obj instanceof Moto) {
				stm.setString(4, null);
				stm.setString(5, null);
				stm.setFloat(6, ((Moto) obj).getCylindree());
			}
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Vehicule obj) {
		try {
			PreparedStatement stm = connection.prepareStatement("delete from vehicule where id = ?)");
			stm.setInt(1, obj.getId());
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Vehicule obj) {
		
		//veh_puissance,
		try {
			PreparedStatement stm = null;

			stm = connection.prepareStatement("update vehicule set veh_const_id = ? , veh_immatriculation = ?, ?  = ? ");
			stm.setInt(1, obj.getConstructeur().getId());
			stm.setString(2, obj.getImmatriculation());

			if(obj instanceof Voiture) {
				stm.setString(3, "veh_puissance");
				stm.setFloat(4, ((Voiture) obj).getPuissance());
			}
			else if(obj instanceof Camion) {
				stm.setString(3, "veh_poid");
				stm.setFloat(4, ((Camion) obj).getPoid());
			}
			else if(obj instanceof Moto) {
				stm.setString(3, "veh_cylindre");
				stm.setFloat(4, ((Moto) obj).getCylindree());
			}
			return stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Vehicule find(int id) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM vehicule where id = ?");
			stm.setInt(1, id);   //? commence par 1
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			Constructeur con = null;
			String immat = "";
			String type = "";
			float puissance = 0;
			float poid = 0;
			float cylindre = 0;
			
			while (rs.next()) {
				
				con = DaoFactory.getConstructeurDao().find(rs.getInt(2));  
				immat = rs.getString(3);
				type = rs.getString(4);
				puissance = rs.getFloat(5);
				poid = rs.getFloat(6);
				cylindre = rs.getFloat(7);
			}
			if(type == TypeVehicule.VOITURE.name()) {
				return new Voiture(id, immat, con, puissance);
			}
			else if(type == TypeVehicule.CAMION.name()) {
				return new Camion(id, immat, con, poid);
			}
			else {
				return new Moto(id, immat, con, cylindre);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Vehicule findByEditionAndCoureurId(int idEdition, int idCoureur) {
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement("SELECT * FROM vehicule v inner join inscription i on i.ins_veh_id = v.id where i.ins_edi_ral_id = ? and ins_cour_id = ?");
			stm.setInt(1, idEdition);   //? commence par 1
			stm.setInt(2, idCoureur);   //? commence par 1
			stm.execute();
			ResultSet rs = stm.getResultSet();
			
			Constructeur con = null;
			String immat = "";
			String type = "";
			float puissance = 0;
			float poid = 0;
			float cylindre = 0;
			int id = 0;
			
			while (rs.next()) {
				
				id = rs.getInt(1);
				con = DaoFactory.getConstructeurDao().find(rs.getInt(2));  
				immat = rs.getString(3);
				type = rs.getString(4);
				puissance = rs.getFloat(5);
				poid = rs.getFloat(6);
				cylindre = rs.getFloat(7);
			}
			if(type == TypeVehicule.VOITURE.name()) {
				return new Voiture(id, immat, con, puissance);
			}
			else if(type == TypeVehicule.CAMION.name()) {
				return new Camion(id, immat, con, poid);
			}
			else {
				return new Moto(id, immat, con, cylindre);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
