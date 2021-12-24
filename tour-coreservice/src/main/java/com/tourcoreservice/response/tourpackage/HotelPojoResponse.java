package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.HotelPojo;

public class HotelPojoResponse extends AbstractPojoResponse{

	HotelPojo hotelPojo;

	public HotelPojo getHotelPojo() {
		return hotelPojo;
	}

	public void setHotelPojo(HotelPojo hotelPojo) {
		this.hotelPojo = hotelPojo;
	}
}
