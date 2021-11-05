package bice.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jamison Bice - jdbice CIS175 - Fall 2021 Sep 4, 2021
 */
@Entity
@Data
@NoArgsConstructor
public class Computer {
	@Id 
	@GeneratedValue 
	private long id;
	
	private String name;
	private char model;
	private short year ;
	private double price;
		/**
	 * @param id
	 * @param name
	 * @param model
	 * @param year
	 * @param price
	 */
	public Computer(long id, String name, char model, short year, double price) {
		this.id = id;
		this.name = name;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	/**
	 * @param name
	 * @param model
	 * @param year
	 * @param price
	 */
	public Computer(String name, char model, short year, double price) {
		this.name = name;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	

}
