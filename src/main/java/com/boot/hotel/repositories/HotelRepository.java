package com.boot.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
