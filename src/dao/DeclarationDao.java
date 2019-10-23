package dao;

import java.sql.Connection;

import entity.declarations.Declaration;

public class DeclarationDao extends AbstractDao<Declaration>{

	public DeclarationDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Declaration obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
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

}
