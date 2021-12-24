package com.tourcoreservice.response.events;

import java.util.List;

import com.tourcoreservice.pojo.events.EventPackagePojo;

public class EventPackageListResponse {

	List<EventPackagePojo> ePackagePojos;
	
	public List<EventPackagePojo> getePackagePojos() {
		return ePackagePojos;
	}
	public void setePackagePojos(List<EventPackagePojo> ePackagePojos) {
		this.ePackagePojos = ePackagePojos;
	}
	
}
	
