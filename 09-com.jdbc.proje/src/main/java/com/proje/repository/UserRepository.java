package com.proje.repository;

import java.util.List;

import com.proje.model.User;

public interface UserRepository {
	
	User saveUser(User user);
	
	boolean saveUserProduct(int userId,int productId);
	
	User update(User user);
	
	boolean removeUser(int id);
	
	User findUserById(int id);
	
	User findUsersProductsById(int id);
	
	List<User> findUsers();

}
