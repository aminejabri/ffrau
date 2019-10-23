package dao;


import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;

import utils.FrauConnection;

public abstract class AbstractDao<T> {
	  protected Connection connection = null;
	   
	  public AbstractDao(Connection connection){
	    this.connection = connection;
	  }
	   
	  public abstract boolean create(T obj) throws SQLIntegrityConstraintViolationException;

	  public abstract boolean delete(T obj);

	  public abstract boolean update(T obj);

	  public abstract T find(int id);

}
