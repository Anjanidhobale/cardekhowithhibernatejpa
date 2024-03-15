package com.jspiders.carDekho.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "car")
public class CarDTO {
	
	@Id
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String model;
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private String fuelType;
	@Column(nullable = false)
	private String color;
	@Column(nullable = false)
	private double price;
}
