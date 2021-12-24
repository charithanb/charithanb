package com.events.westernevents.facad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.events.westernevents.service.EventPackageService;
import com.tourcoreservice.entity.events.EventPackages;
import com.tourcoreservice.pojo.events.EventPackagePojo;
import com.tourcoreservice.response.events.EventPackageListResponse;
import com.tourcoreservice.response.events.EventPackageResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class EventPackageFacad {

	@Autowired
	EventPackageService eService;
	
	public EventPackageListResponse listAll() {
		EventPackageListResponse eListResponse = new EventPackageListResponse();
		List<EventPackages> ePackages = eService.listAll();
		List<EventPackagePojo> ePackagePojos = ObjectMapperUtils.mapAll(ePackages, EventPackagePojo.class);
		eListResponse.setePackagePojos(ePackagePojos);
		return eListResponse;
	}
	
	
	
	
	public EventPackageResponse getPackage(long id) {
		EventPackageResponse eResponse = new EventPackageResponse();
		EventPackages ePackages = eService.getById(id);
		EventPackagePojo ePackagePojo = ObjectMapperUtils.map(ePackages,EventPackagePojo.class);
		eResponse.setePackagePojo(ePackagePojo);
		return eResponse;
	}

	public EventPackageResponse savePackage(EventPackagePojo ePojo) {
		EventPackageResponse eResponse = new EventPackageResponse();
		EventPackages ePackages = ObjectMapperUtils.map(ePojo, EventPackages.class);
		EventPackages ePackages2 = eService.create(ePackages);
		EventPackagePojo ePackagePojo = ObjectMapperUtils.map(ePackages2,EventPackagePojo.class);
		eResponse.setePackagePojo(ePackagePojo);
		return eResponse;
	}

	public EventPackageResponse updatePackage(EventPackagePojo ePojo) {
		EventPackageResponse eResponse = new EventPackageResponse();
		EventPackages ePackages = ObjectMapperUtils.map(ePojo, EventPackages.class);
		EventPackages ePackages2 = eService.Update(ePackages);
		EventPackagePojo ePackagePojo = ObjectMapperUtils.map(ePackages2,EventPackagePojo.class);
		eResponse.setePackagePojo(ePackagePojo);
		return eResponse;
	}

	public void delete(long id) {
		
		eService.delete(id);
	}
}
