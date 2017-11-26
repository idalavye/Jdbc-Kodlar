package com.proje.update;

import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class DBProcesses {
	
	private static final Logger logger = LogManager.getLogger();
	
	public static Personel updatePersonel(Personel personel){
		
		String sorgu = "UPDATE personel SET adi =?, soyadi=?, dogumYili=?,personelNumarasi=? WHERE personelId=?";
		
		Connection connection = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setString(1, personel.getAdi());
			preparedStatement.setString(2, personel.getSoyadi());
			preparedStatement.setInt(3, personel.getDogumYili());
			preparedStatement.setString(4, personel.getOkulNumarasi());
			preparedStatement.setInt(5, personel.getPersonelId());
			
			preparedStatement.executeUpdate();
			
			logger.info(personel.getPersonelId() + " li personel güncellendi.");
			
		} catch (SQLException e) {
			logger.warn(personel.getPersonelId() + " li personel eklenirken hata meydana geldi. ");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
		}
		
		return personel;
	}

}
