package com.proje.model.queries;

public class ProductQueries {
	
	public static final String saveProductQuery = "insert into product(productId,productName,productPrice,avaible,addDate, updateDate,categoryId,brandId) values(?,?,?,?,?,?,?,?)";

	public static final String updateProductQuery = "update product set productName =?,productPrice =?,avaible =?, updateDate =? ,categoryId =?,brandId =? where productId =?";
	
	public static final String deleteUser_ProductQuery = "delete from user_product where productId=? ";
	public static final String deleteProduct = "delete from product where productId =?";
	
	public static final String findProductById = "SELECT * FROM product p LEFT JOIN category c on(p.categoryId = c.categoryId) LEFT JOIN brand b on(p.brandId = b.brandId) WHERE productId = ?";
	
	public static final String findProductsQuery = "SELECT * FROM product p LEFT JOIN category c on(p.categoryId = c.categoryId) LEFT JOIN brand b on(p.brandId = b.brandId)";
}
 