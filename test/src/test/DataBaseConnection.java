package test;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseConnection{
		final static private String url = "jdbc:mysql://localhost:3306/";
		final static private String driver = "com.mysql.jdbc.Driver";
		final static private String db = "new"; 
		final static private String pass = "root";
		final static private String user = "root";
		
		public static Connection javaConnection()
		{
			Connection conne=null;
			try {
				Class.forName(driver).newInstance();
				conne = (Connection) DriverManager.getConnection(url + db,user, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conne;
			
		}
		
		
		
}


