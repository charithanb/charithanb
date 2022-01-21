package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.facade.HotelFacade;
import com.tourcoreservice.pojo.tourpackage.AssetPojo;
import com.tourcoreservice.pojo.tourpackage.HotelPojo;
import com.tourcoreservice.pojo.tourpackage.HotelUpdatePojo;
import com.tourcoreservice.response.tourpackage.HotelPojoListResponse;
import com.tourcoreservice.response.tourpackage.HotelPojoResponse;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	HotelFacade hotelFacade;

	@GetMapping
	public HotelPojoListResponse getAll() {
		return hotelFacade.listAllHotel();
	}

	@GetMapping("/{id}")
	public HotelPojoResponse get(@PathVariable long id) {
		return hotelFacade.getHotel(id);

	}

	@PostMapping
	public HotelPojoResponse create(@RequestBody HotelPojo hotel) {
		return hotelFacade.saveHotel(hotel);
	}

	@PutMapping("/{id}")
	public HotelPojoResponse update(@RequestBody HotelUpdatePojo hotel, @PathVariable long id) {
		hotel.setId(id);
		return hotelFacade.updateHotel(hotel);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		hotelFacade.deleteHotel(id);
	}

	@DeleteMapping("/{id}/{Hotelid}")
	public void delete(@PathVariable long id, @PathVariable long Hotelid) {
		hotelFacade.deleteAsset(id, Hotelid);
	}

	@PostMapping("/image/{id}")
	public void addHotelImage(@RequestBody AssetPojo asset, @PathVariable long id) {
		hotelFacade.addHotelImage(id, asset);
	}
}
