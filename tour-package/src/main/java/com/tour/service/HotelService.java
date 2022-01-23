package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.HotelRepository;
import com.tourcoreservice.entity.Hotel;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> listAllHotel() {
        return hotelRepository.findAll();
    }
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
    }
	
	public Hotel UpdateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	public Hotel getHotelById(long id) {
        return hotelRepository.findById(id);
    }
	
	public void deleteHotel(long id) {
		hotelRepository.deleteById(id);
    }

}
