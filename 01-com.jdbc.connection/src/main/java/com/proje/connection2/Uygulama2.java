package com.proje.connection2;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;

public class Uygulama2 {
	
	private static Connection connection = null;
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		
		openConnection();
		
		closeConnection();
		
	}
	
	private static void openConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.warn("Mysql Driver Bulunamadı.. Hata: " + e);
			return;
		}
			
		try {
			
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim","root","w4tchDC!iDa");
			logger.info("Mysql'e bağlandık");
		
		} catch (SQLException e) {
			logger.warn("Mysql'e bağlanırken hata oluştu. HATA: " + e);
			
		
		} 
	}
	
	private static void closeConnection(){
		
		if(connection != null){
			try {
				connection.close();
				logger.info("Mysql bağlantısı başarılı bir şekilde sonlandırıldı.");
			} catch (SQLException e) {
				logger.warn("Mysql bağlantısı sonlandırılırken bir hata meydana geldi.");
			
			}
		}
		
	}
}
