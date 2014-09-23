/**
 * 
 * @author Hammoud
 * @version 1.0
 */
package com.mycompany.model;

import java.io.Serializable;

import org.apache.wicket.markup.html.image.Image;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String desc;
	private double price;
	

	public Product(String id, String name, String desc, double price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		
	}


	public String getDesc() {
		return desc;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
