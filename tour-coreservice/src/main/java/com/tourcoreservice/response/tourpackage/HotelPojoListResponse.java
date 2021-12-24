package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.HotelPartialPojo;

public class HotelPojoListResponse extends AbstractPojoResponse{

	List<HotelPartialPojo> hotelPojo;

	public List<HotelPartialPojo> getHotelPojo() {
		return hotelPojo;
	}

	public void setHotelPojo(List<HotelPartialPojo> hotelPojo) {
		this.hotelPojo = hotelPojo;
	}

	
	
}
