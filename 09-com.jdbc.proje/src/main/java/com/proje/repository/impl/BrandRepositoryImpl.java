package com.proje.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.proje.connection.DBConnection;
import com.proje.model.Brand;
import com.proje.model.queries.BrandQuery;
import com.proje.repository.BrandRepository;

public class BrandRepositoryImpl implements BrandRepository{

	private final Logger logger = LogManager.getLogger();
	
	private Connection connection = null;
	
	private PreparedStatement preparedStatement = null;
	
	private ResultSet resultSet = null;
	
	
	@Override
	public Brand saveBrand(int id) {
		connection = DBConnection.getConnection();
		
		Brand brand = null;
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(BrandQuery.findBrandByIdQuery);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				int brandId = resultSet.getInt("brandId");
				String brandName = resultSet.getString("brandName");
				
				brand = new Brand(brandId, brandName);
			}
			
		} catch (SQLException e) {
			
			logger.warn("Brand aran�rken hata meydana geldi. HATA : " + e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
		}
		return brand;
	}

	@Override
	public List<Brand> findBrands() {
		connection = DBConnection.getConnection();
		
		List<Brand> brands = new ArrayList<>();
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(BrandQuery.findBrandQuery);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				
				int brandId = resultSet.getInt("brandId");
				String brandName = resultSet.getString("brandName");
				
				Brand brand = new Brand(brandId, brandName);
				brands.add(brand);
			}
			
		} catch (SQLException e) {
			
			logger.warn("Brand listesi al�n�rken hata meydana geldi. HATA : " + e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
		}
		return brands;
	}

}
