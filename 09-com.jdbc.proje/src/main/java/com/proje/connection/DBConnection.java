package com.proje.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBConnection {

	private static final Logger logger = LogManager.getLogger();

	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	// Bir kere �al���yor birdaha �al��m�yor.
	static {// De�i�meyecek de�erler ve sadece birkez �al��cak de�erler varsa
			// bunun i�inde tan�mlayabiliriz.

		Properties properties = new Properties();

		try {
			InputStream inputStream = new FileInputStream("src/main/resources/database.properties");
			properties.load(inputStream);

			driver = properties.getProperty("db_driver");
			url = properties.getProperty("db_url");
			username = properties.getProperty("db_user");
			password = properties.getProperty("db_password");

		} catch (IOException e) {

			logger.warn("database.propertie dosyas�na ba�lan�rken bir hata meydana geldi.");

		}
	}
	
	public static Connection getConnection(){
		
		Connection connection = null;
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			logger.warn("Drivera ba�lan�rken bir hata meydana geldi.");
		}
		
		try {
			connection = (Connection) DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			logger.warn("Ba�lant� olu�urken bir hata meydana geldi.");
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
		
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				logger.warn("Connection kapat�l�rken bir hata meydana geldi.");
			}
		}
		
		if(preparedStatement != null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.warn("preparedStatement kapat�l�rken bir hata meydana geldi.");
			}
		}
		
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.warn("resultSet kapat�l�rken bir hata meydana geldi.");
			}
		}
	}
}
