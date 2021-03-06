package com.proje.insert2;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.proje.DBConnection;

public class Uygulama2 {

	public static void main(String[] args) {
		
		savePersonel(102, "�brahim", "Da�delen",1998, "b151210104");
		savePersonel(103, "mevl�t","Sevin�", 1997, "b15121010005");
		
	}
	
	public static void savePersonel(int personelId,String adi,String soyadi,int dogumYili,String personelNumarasi){
		
		String sorgu = "INSERT INTO personel(personelId,adi,soyadi,dogumYili,personelNumarasi) VALUES(?,?,?,?,?)";
		
		Logger logger = LogManager.getLogger();
		
		Connection connection = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, personelId);
			preparedStatement.setString(2, adi);
			preparedStatement.setString(3, soyadi);
			preparedStatement.setInt(4, dogumYili);
			preparedStatement.setString(5, personelNumarasi);
			
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
