package com.proje.insert1;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.proje.DBConnection;

public class Uygulama1 {
	
	public static void main(String[] args) {
		
		String sorgu = "INSERT INTO personel(personelId,adi,soyadi,dogumYili,personelNumarasi) VALUES(?,?,?,?,?)";
		
		Logger logger = LogManager.getLogger();
		
		Connection connection = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, 101);
			preparedStatement.setString(2, "�brahim");
			preparedStatement.setString(3, "Da�delen");
			preparedStatement.setInt(4, 1997);
			preparedStatement.setString(5, "b151210104");
			
			preparedStatement.executeUpdate();
			
			logger.info("Personel ba�ar�yla eklendi.");
			
		} catch (SQLException e) {
			logger.warn("Personel eklenirken hata olu�tu.");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
	}

}
