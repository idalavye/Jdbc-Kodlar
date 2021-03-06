package com.proje.statement3;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBConnection3 {

	private static final Logger logger = LogManager.getLogger();
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.warn("Mysql Driver Bulunamadı.. Hata: " + e);
		}
		
		Connection connection = null;
		
		try {
			
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-egitim","root","w4tchDC!iDa");
			logger.info("Mysql'e bağlandık");
		
		} catch (SQLException e) {
			logger.warn("Mysql'e bağlanırken hata oluştu. HATA: " + e);
			
		
		} 
		
		return connection;
	}
	
	public static void closeConnection(Connection connection, Statement statement){
		if(connection != null){
			try {
				connection.close();
				logger.info("Mysql bağlantısı başarılı bir şekilde sonlandırıldı.");
			} catch (SQLException e) {
				logger.warn("Mysql bağlantısı sonlandırılırken bir hata meydana geldi.");
			
			}
		}
		
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				
				logger.warn("Statement kapatılırken hata meydana geldi.");
			}
		}
	}
}
