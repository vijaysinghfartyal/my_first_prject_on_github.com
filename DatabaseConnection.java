package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection conn = null;
    public static Connection  getConnection() {
		 System.out.println("GetConnection ==== ");
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","vijay7248");
			System.out.println("Conn success "+conn);
			
		} catch (Exception e) {
           e.printStackTrace();
		}
		 
    	
    	return conn;

	}

	public static void main(String[] args) {
		System.out.println(DBConection.getConnection());

	}

}