package com.proje.connection3;

import com.mysql.jdbc.Connection;

public class Uygulama3 {
	
	public static void main(String[] args) {
		
		Connection connection = DBConnection.getConnection();
		
		DBConnection.closeConnection(connection);
		
	}

}
