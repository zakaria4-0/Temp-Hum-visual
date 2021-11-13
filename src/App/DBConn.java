package App;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class DBConn {
	private static Connection conn;
	public static Connection ConnectDB() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakaria","root","");
		
		 
     } catch (Exception e) {
         
         e.printStackTrace();
     }
		
		return conn;
		}

	
}




