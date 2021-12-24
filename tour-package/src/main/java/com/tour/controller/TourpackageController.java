package com.tour.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tour.facade.Tourpackagefacade;
import com.tourcoreservice.entity.Asset;
import com.tourcoreservice.pojo.tourpackage.FacilityPojo;
import com.tourcoreservice.pojo.tourpackage.InclusionPojo;
import com.tourcoreservice.pojo.tourpackage.IterneryPojo;
import com.tourcoreservice.pojo.tourpackage.LastDayinfoPojo;
import com.tourcoreservice.pojo.tourpackage.PricePojo;
import com.tourcoreservice.pojo.tourpackage.TourPackageUpdatePojo;
import com.tourcoreservice.pojo.tourpackage.TourpackagePojo;
import com.tourcoreservice.response.tourpackage.PackageIdPojoResponse;
import com.tourcoreservice.response.tourpackage.TourPackageDetailedPojoListResponse;
import com.tourcoreservice.response.tourpackage.TourpackagePojoListResponse;
import com.tourcoreservice.response.tourpackage.TourpackagePojoResponse;

@RestController
@RequestMapping("/package")
public class TourpackageController {
	
	@Autowired
	Tourpackagefacade tourPackageFacade;
	
	@GetMapping
	public  TourpackagePojoListResponse allPackages() {
        return tourPackageFacade.listAllPackage();
    }
	@GetMapping("/detailed")
	public TourPackageDetailedPojoListResponse allDetailedPackages() {
		return tourPackageFacade.listAllDetailedPackages();
	}
	
	 
	@GetMapping("/{id}")
    public TourpackagePojoResponse getpackge(@PathVariable long id) {
        return tourPackageFacade.getPackage(id);
        
    }
	@GetMapping("/image/{id}")
	public Set<Asset> getpackgeAsset(@PathVariable long id) {
        return tourPackageFacade.getPackImage(id); 
    }
    @PostMapping
    public PackageIdPojoResponse create(@RequestBody TourpackagePojo tourPackagePojo) {
    	return tourPackageFacade.savePackageMainDetails(tourPackagePojo);
    }
    @PutMapping("lastday/{id}")
    public void  Iternrylastday(@RequestBody LastDayinfoPojo lastDayinfoPojo,@PathVariable long id) {
    	lastDayinfoPojo.setId(id);
    	tourPackageFacade.updatelastday(lastDayinfoPojo,id);
    }
    @PutMapping("/{id}")
    public TourpackagePojoResponse update(@RequestBody TourPackageUpdatePojo pack, @PathVariable long id) {
    	pack.setId(id);
    	return tourPackageFacade.updatePakage(pack);
       
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    	 tourPackageFacade.deletePackage(id);
    }
    
    //price
    
    @PostMapping("/price/{id}")
    public PackageIdPojoResponse craetePrice(@PathVariable long id,@RequestBody PricePojo pricePojo) {
    	return tourPackageFacade.createPrice(id,pricePojo);
    } 
    
    @PostMapping("/facilty/{id}")
    public PackageIdPojoResponse createFacity(@PathVariable long id,@RequestBody FacilityPojo  facilityPojo) {
    	return tourPackageFacade.createFacility(id,facilityPojo);
    }
    
    @PostMapping("/inclusion/{id}")
    public PackageIdPojoResponse createInclusion(@PathVariable long id,@RequestBody InclusionPojo inclusionPojo) {
    	return tourPackageFacade.createInclusion(id,inclusionPojo);
    }
//    @PostMapping("/maindeatails/{id}")
//    public PackageIdResponse updatemaindetails(@PathVariable long id,@RequestBody ) {
//    	
//    }
    @PostMapping("/image/{id}")
    public PackageIdPojoResponse createImage(@PathVariable long id,@RequestParam("file") MultipartFile file) throws IOException, URISyntaxException {
    	return tourPackageFacade.createImage(id,file);
    }
    @GetMapping("/iterneries/{packageid}")
    public List<IterneryPojo>  getIterneries(@PathVariable("packageid") long packageId) {
    	return tourPackageFacade.getIterneries(packageId);
    }
}