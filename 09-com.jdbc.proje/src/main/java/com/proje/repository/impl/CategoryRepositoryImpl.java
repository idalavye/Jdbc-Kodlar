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
import com.proje.model.Category;
import com.proje.model.queries.CategoryQueries;
import com.proje.repository.CategoryRepository;
public class CategoryRepositoryImpl implements CategoryRepository{
	

	private final Logger logger = LogManager.getLogger();
	
	private Connection connection = null;
	
	private PreparedStatement preparedStatement = null;
	
	private ResultSet resultSet = null;

	@Override
	public Category findCategoryById(int id) {
		connection = DBConnection.getConnection();
		
		Category category = null;
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(CategoryQueries.findCategoryByIdQuery);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				int categoryId = resultSet.getInt("categoryId");
				String categoryName = resultSet.getString("categoryName");
				
				category = new Category(categoryId, categoryName);
			}
		} catch (SQLException e) {
			logger.warn("Category aranýrken hata meydana geldi. HATA : " + e );
		}
		
		return category;
	}

	@Override
	public List<Category> findCategories() {
		connection = DBConnection.getConnection();
		
		List<Category> categories = new ArrayList<>();
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(CategoryQueries.findCategoriesQuery);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				
				int categoryId = resultSet.getInt("categoryId");
				String categoryName = resultSet.getString("categoryName");
				
				Category category = new Category(categoryId, categoryName);
				categories.add(category);
			}
		} catch (SQLException e) {
			logger.warn("Category listesi aranýrken hata meydana geldi. HATA : " + e );
		}
		
		return categories;
	}

}
