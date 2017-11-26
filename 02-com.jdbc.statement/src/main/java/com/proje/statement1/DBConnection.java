package com.proje.statement1;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;

public class DBConnection {

	private static final Logger logger = LogManager.getLogger();
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.warn("Mysql Driver Bulunamad�.. Hata: " + e);
		}
		
		Connection connection = null;
		
		try {
			
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim","root","w4tchDC!iDa");
			logger.info("Mysql'e ba�land�k");
		
		} catch (SQLException e) {
			logger.warn("Mysql'e ba�lan�rken hata olu�tu. HATA: " + e);
			
		
		} 
		
		return connection;
	}
	
	public static void closeConnection(Connection connection){
		if(connection != null){
			try {
				connection.close();
				logger.info("Mysql ba�lant�s� ba�ar�l� bir �ekilde sonland�r�ld�.");
			} catch (SQLException e) {
				logger.warn("Mysql ba�lant�s� sonland�r�l�rken bir hata meydana geldi.");
			
			}
		}
	}
}