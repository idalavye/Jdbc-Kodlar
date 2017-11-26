package com.proje.delete;

import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class DBProcesses {
	
	private static final Logger logger = LogManager.getLogger();
	
	public static void deletePersonelById(int personelId){
		
		String sorgu = "DELETE FROM personel WHERE personelId =?";
		
		Connection connection = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, personelId);
			
			preparedStatement.executeUpdate();
			
			logger.info(personelId + " li personel baþarýyla silindi.");
			
		} catch (SQLException e) {
			logger.warn(personelId + " li personel silinirken bir hata meydana geldi.");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		
	}
	
	public static void deletePersonelByAdi(String adi){
		
		String sorgu = "DELETE FROM personel WHERE adi =?";
		
		Connection connection = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, adi);
			
			preparedStatement.executeUpdate();
			
			logger.info(adi + "  adlý personel baþarýyla silindi.");
			
		} catch (SQLException e) {
			logger.warn(adi + " adlý personel silinirken bir hata meydana geldi.");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}
}
