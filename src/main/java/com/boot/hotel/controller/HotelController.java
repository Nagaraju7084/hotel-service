package com.boot.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.hotel.dtos.HotelDto;
import com.boot.hotel.services.HotelService;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/hotels")
	public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto){
		return new ResponseEntity<HotelDto>(hotelService.createHotel(hotelDto), HttpStatus.CREATED);
	}

	@PutMapping("/hotels/{hotelId}")
	public ResponseEntity<HotelDto> updateHotel(@RequestBody HotelDto hotelDto, @PathVariable String hotelId){
		return new ResponseEntity<HotelDto>(hotelService.updateHotel(hotelDto, hotelId), HttpStatus.OK);
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<HotelDto> getHotelById(@PathVariable String hotelId){
		return new ResponseEntity<HotelDto>(hotelService.getHotelById(hotelId), HttpStatus.OK);
	}
	
	@GetMapping("/hotels")
	public ResponseEntity<List<HotelDto>> getAllHotels(){
		return new ResponseEntity<List<HotelDto>>(hotelService.getAllHotels(), HttpStatus.OK);
	}
	
	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<?> deleteHotelById(@PathVariable String hotelId){
		hotelService.deleteHotelById(hotelId);
		return new ResponseEntity("hotel deleted successfully...", HttpStatus.OK);
	}
	
}
