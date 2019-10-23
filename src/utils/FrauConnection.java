package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FrauConnection {
	  
	/**
	  * URL de connection
	  */
	  private static String url = "jdbc:mysql://localhost:3306/ffrau";

	  /**
	  * Nom du user
	  */
	  private static String user = "root";

	  /**
	  * Mot de passe du user
	  */
	  private static String passwd = "aminebirk";

	  /**
	  * Objet Connection
	  */
	  private static Connection connect;

	  /**
	  * M�thode qui va retourner notre instance
	  * et la cr�er si elle n'existe pas...
	  * @return
	  */
	  public static Connection getInstance(){
	    if(connect == null){
	      try {
	        connect = DriverManager.getConnection(url, user, passwd);
	      } catch (SQLException e) {
	    	  System.out.println(e);
	      }
	    }		
	    return connect;	
	  }
}

 