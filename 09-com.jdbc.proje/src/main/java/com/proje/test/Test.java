package com.proje.test;

//import java.sql.Date;
import java.util.List;

import com.proje.model.*;

import com.proje.service.BrandService;
import com.proje.service.CategoryService;
import com.proje.service.ProductService;
import com.proje.service.UserService;
import com.proje.service.impl.BrandServiceImpl;
import com.proje.service.impl.CategoryServiceImpl;
import com.proje.service.impl.ProductServiceImpl;
import com.proje.service.impl.UserServiceImpl;

public class Test {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		BrandService brandService = new BrandServiceImpl();
		
		CategoryService categoryService = new CategoryServiceImpl();
		
		ProductService productService = new ProductServiceImpl();
		
		UserService userService = new UserServiceImpl();
		
		List<Brand> brands = brandService.findBrands();
		for (Brand brand : brands) {
			System.out.println(brand);
		}
		
		
//		Brand brand = brandService.saveBrand(1);
//		System.out.println(brand);
		
		
//		List<Category> categories = categoryService.findCategories();
//		for (Category category : categories) {
//			System.out.println(category);
//		}
		
		
//		Category category = categoryService.findCategoryById(2);
//		System.out.println(category);
		
		
//		List<Product> products = productService.findProducts();
//		for (Product product : products) {
//			System.out.println(product);  
//			System.out.println(product.getCategory().getCategoryName());
//		}

		
//		Product product = productService.findProductById(2);
//		System.out.println(product);
		
		
//		List<User> users = userService.findUsers();
//		for (User user : users) {
//			System.out.println(user);
//		}
		
		
//		User user = userService.findUserById(1);
//		System.out.println(user);
		
//		User user = userService.findUsersProductsById(1);
//		System.out.println(user);
//		List<Product> products = user.getProducts();
//		System.out.println("Kullan�c�n�n payla�t��� �r�nler.");
//		
//		for (Product product : products) {
//			System.out.println("\t" + product);
//		}
		
		
//		User user = new User(3, "�skender", "��r�k", new Date(new java.util.Date().getTime()), "iskobey");
//		userService.saveUser(user);
		
//		Product product = new Product(5, "Monster", 10000, 1, new java.util.Date(), null, null, null);
//		
//		Category category = categoryService.findCategoryById(2);
//		product.setCategory(category);
//		
//		Brand brand = brandService.saveBrand(1);
//		product.setBrand(brand);
//		
//		productService.saveProduct(product);
		
		
//		userService.saveUserProduct(2, 5);
		
//		Product product = productService.findProductById(5);
//		product.setProductName("Monster Abra");
//		productService.updateProduct(product);
//		
	}

}
