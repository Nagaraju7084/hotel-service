package com.boot.hotel.exceptions;

public class HotelNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	public HotelNotFoundException(String resourceName, String fieldName, String fieldValue) {
		String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
}
