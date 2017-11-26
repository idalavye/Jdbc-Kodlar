package com.proje.service.impl;

import java.util.List;

import com.proje.model.User;
import com.proje.repository.UserRepository;
import com.proje.repository.impl.UserRepositoryImpl;
import com.proje.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public User saveUser(User user) {  //Controller bir user gönderiyor. Bu servis katmaný repository kýsmýna ulaþýp iþlemleri yapýyor. 
		return userRepository.saveUser(user); //ve en sonda controllera geri bir user gönderiyor. 
	}

	@Override
	public boolean saveUserProduct(int userId, int productId) {

		return userRepository.saveUserProduct(userId, productId);
	}

	@Override
	public User update(User user) {
		return userRepository.update(user);
	}

	@Override
	public boolean removeUser(int id) {
		return userRepository.removeUser(id);
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findUserById(id);
	}

	@Override
	public User findUsersProductsById(int id) {
		return userRepository.findUsersProductsById(id);
	}

	@Override
	public List<User> findUsers() {
		return userRepository.findUsers();
	}

}
