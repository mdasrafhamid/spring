package com.capg.sb1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String title;
	private String description;
	private int numberInStock;
	private int dailyRentalRate;
	
	public Movie() {
		super();
	}
	
	public Movie(String title, String description, int numberInStock, int dailyRentalRate) {
		super();
		this.title = title;
		this.description = description;
		this.numberInStock = numberInStock;
		this.dailyRentalRate = dailyRentalRate;
	}
	
	public Movie(long id, String title, String description, int numberInStock, int dailyRentalRate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.numberInStock = numberInStock;
		this.dailyRentalRate = dailyRentalRate;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberInStock() {
		return numberInStock;
	}

	public void setNumberInStock(int numberInStock) {
		this.numberInStock = numberInStock;
	}

	public int getDailyRentalRate() {
		return dailyRentalRate;
	}

	public void setDailyRentalRate(int dailyRentalRate) {
		this.dailyRentalRate = dailyRentalRate;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", numberInStock="
				+ numberInStock + ", dailyRentalRate=" + dailyRentalRate + "]";
	}

	
	
	
}
