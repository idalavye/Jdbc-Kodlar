package com.proje.model;

import java.util.Date;

public class Product {
	
	private int productId;
	
	private String productName;
	
	private double productPrice;
	
	private int avaible;
	
	private Date addDate;
	
	private Date updateDate;
	
	private Category category;
	
	private Brand brand;
	
	public Product() {
	}

	public Product(int productId, String productName, double productPrice, int avaible, Date addDate, Date updateDate,
			Category category, Brand brand) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.avaible = avaible;
		this.addDate = addDate;
		this.updateDate = updateDate;
		this.category = category;
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getAvaible() {
		return avaible;
	}

	public void setAvaible(int avaible) {
		this.avaible = avaible;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", avaible=" + avaible + ", addDate=" + addDate + ", updateDate=" + updateDate + ", category="
				+ category + ", brand=" + brand + "]";
	}
		
	

}
