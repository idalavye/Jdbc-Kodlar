package com.proje.model.queries;

public class UserQueries {
	
	public static final String saveUserQuery = "insert into user(userId,firstName,lastName,birthOfDate,username) values (?,?,?,?,?)";
	
	public static final String saveUser_ProductQuery = "insert into user_product(userId,productId) values(?,?)"; 
	
	public static final String updateUserQuery = "update user set firstName =?,lastName=?,birthOfDate =?,username =? where userId=? ";
	
	public static final String deleteUser_ProductQuery = "delete from user_product where userId=?";
	public static final String deleteUserByIdQuery = "delete from user where userId =?";
	
	public static final String findUserById = "select * from user where userId=?";
	
	public static final String findUsersQuery = "select * from user";
	
	public static final String findUserProductQuery = " SELECT * FROM user u "
													+ "LEFT OUTER JOIN user_product up ON(u.userId = up.userId) "
													+ "LEFT JOIN product p ON(up.productId = p.productId) "
													+ "LEFT JOIN category c ON(p.categoryId = c.categoryId) "
													+ "LEFT JOIN brand b ON(p.brandId = b.brandId) "
													+ "WHERE u.userId=?";
	

}
