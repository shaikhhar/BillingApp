package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getDbCon(){
	       try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/daraz","root","");
			return con;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
