package com.eShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;

	private String manufacturer;

	private String category;

	private String image;
	
	private float price;
	
	private int stockx;

	public Stock(String title, String manufacturer, String category, String image, float price, int stockx) {
		super();
		this.title = title;
		this.manufacturer = manufacturer;
		this.category = category;
		this.image = image;
		this.price=price;
		this.stockx=stockx;
	}
	
	

	public int getStockx() {
		return stockx;
	}



	public void setStockx(int stockx) {
		this.stockx = stockx;
	}



	public Stock() {
		
	}

	public float getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}