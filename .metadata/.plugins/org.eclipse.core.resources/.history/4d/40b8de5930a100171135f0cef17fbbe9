package com.proje.prepareStatement;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBConnection {
	
	private static final Logger logger = LogManager.getLogger();
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.warn("Mysql Driver Bulunamadý.. Hata: " + e);
		}
		
		Connection connection = null;
		
		try {
			
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim","root","w4tchDC!iDa");
			logger.info("Mysql'e baðlandýk");
		
		} catch (SQLException e) {
			
			logger.warn("Mysql'e baðlanýrken hata oluþtu. HATA: " + e);
					
		} 
		
		return connection;
	}
	
	public static void closeConnection(Connection connection, PreparedStatement statement){
		if(connection != null){
			try {
				connection.close();
				logger.info("Mysql baðlantýsý baþarýlý bir þekilde sonlandýrýldý.");
			} catch (SQLException e) {
				logger.warn("Mysql baðlantýsý sonlandýrýlýrken bir hata meydana geldi.");
			
			}
		}
		
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				
				logger.warn("PreparedStatement kapatýlýrken hata meydana geldi.");
			}
		}
	}

}
