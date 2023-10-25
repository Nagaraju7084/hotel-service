package com.boot.hotel.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.hotel.dtos.HotelDto;
import com.boot.hotel.entities.Hotel;
import com.boot.hotel.exceptions.HotelNotFoundException;
import com.boot.hotel.repositories.HotelRepository;
import com.boot.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public HotelDto createHotel(HotelDto hotelDto) {
		String randomHotelId = UUID.randomUUID().toString();
		hotelDto.setHotelId(randomHotelId);
		return entityToDto(hotelRepository.save(dtoToEntity(hotelDto)));
	}

	@Override
	public HotelDto updateHotel(HotelDto hotelDto, String hotelId) {
		Hotel dbHotel = hotelRepository.findById(hotelId).orElseThrow(
				()-> new HotelNotFoundException("Hotel","id",hotelId)
				);
		//BeanUtils.copyProperties(hotelDto, dbHotel);
		dbHotel.setHotelName(hotelDto.getHotelName());
		dbHotel.setLocation(hotelDto.getLocation());
		dbHotel.setAbout(hotelDto.getAbout());
		Hotel updatedHotel = hotelRepository.save(dbHotel);
		return entityToDto(updatedHotel);
	}

	@Override
	public HotelDto getHotelById(String hotelId) {
		return entityToDto(hotelRepository.findById(hotelId).orElseThrow(
				()-> new HotelNotFoundException("Hotel", "id", hotelId)
				));
	}

	@Override
	public List<HotelDto> getAllHotels() {
		return hotelRepository.findAll().stream().map(
				hotel -> entityToDto(hotel)).collect(Collectors.toList());
	}
	
	@Override
	public void deleteHotelById(String hotelId) {
		hotelRepository.deleteById(hotelId);
	}
	
	private Hotel dtoToEntity(HotelDto hotelDto) {
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(hotelDto, hotel);
		return hotel;
	}
	
	private HotelDto entityToDto(Hotel hotel) {
		HotelDto hotelDto = new HotelDto();
		BeanUtils.copyProperties(hotel, hotelDto);
		return hotelDto;
	}

}
