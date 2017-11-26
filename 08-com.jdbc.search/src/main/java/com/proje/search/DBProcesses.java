package com.proje.search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class DBProcesses {
	
	private static final Logger logger = LogManager.getLogger();
	
	public static Personel findPersonelById(int personelById){
		
		String sorgu = "SELECT * FROM personel WHERE personelId = ?";
		
		Connection connection = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		Personel personel = null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, personelById);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				int id = resultSet.getInt(1);
				String adi = resultSet.getString(2);
				String soyadi = resultSet.getString(3);
				int dogumYili = resultSet.getInt(4);
				String personelNumarasi = resultSet.getString(5);
				
				personel = new Personel(id, adi, soyadi, dogumYili, personelNumarasi);
				
			}
			
		} catch (SQLException e) {
			logger.warn("Personel bulunurken hata meydana geldi.");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
			
			if(resultSet != null){
				
				try {
					resultSet.close();
				} catch (SQLException e) {
					logger.warn("Hata" + e);
				}
			}
			
		}
		
		return personel;
	}

	public static List<Personel> findPersonels(){
		
		String sorgu = "SELECT * FROM personel";
		
		Connection connection = DBConnection.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<Personel> personels = new ArrayList<Personel>();
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sorgu);	
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int id = resultSet.getInt(1);
				String adi = resultSet.getString(2);
				String soyadi = resultSet.getString(3);
				int dogumYili = resultSet.getInt(4);
				String personelNumarasi = resultSet.getString(5);
				Personel personel = new Personel(id, adi, soyadi, dogumYili, personelNumarasi);
				personels.add(personel);
				
			}
			
		} catch (SQLException e) {
			logger.warn("Personeller bulunurken bir hata meydana geldi.");
		}
		finally {
			DBConnection.closeConnection(connection, preparedStatement);
			
			if(resultSet != null){
				
				try {
					resultSet.close();
				} catch (SQLException e) {
					logger.warn("Hata" + e);
				}
			}
		}
		
		return personels;
	}
}
