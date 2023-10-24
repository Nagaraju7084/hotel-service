package com.boot.hotel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "hotels")
@Data
public class Hotel {

	@Id
	private String hotelId;
	private String hotelName;
	private String location;
	private String about;
	
}
