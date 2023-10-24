package com.boot.hotel.services;

import java.util.List;

import com.boot.hotel.dtos.HotelDto;

public interface HotelService {

	HotelDto createHotel(HotelDto hotelDto);
	HotelDto updateHotel(HotelDto hotelDto, String hotelId);
	HotelDto getHotelById(String hotelId);
	List<HotelDto> getAllHotels();
	void deleteHotelById(String hotelId);
}
