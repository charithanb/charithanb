package com.tour.facade;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Bucket;
import com.tour.service.AssetService;
import com.tour.service.IterneryService;
import com.tour.service.TourpackageService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Asset;
import com.tourcoreservice.entity.Facility;
import com.tourcoreservice.entity.Iternery;
import com.tourcoreservice.entity.Place;
import com.tourcoreservice.entity.Price;
import com.tourcoreservice.entity.Theme;
import com.tourcoreservice.entity.Tourpackage;
import com.tourcoreservice.pojo.tourpackage.FacilityPojo;
import com.tourcoreservice.pojo.tourpackage.InclusionPojo;
import com.tourcoreservice.pojo.tourpackage.IterneryPojo;
import com.tourcoreservice.pojo.tourpackage.LastDayinfoPojo;
import com.tourcoreservice.pojo.tourpackage.PricePojo;
import com.tourcoreservice.pojo.tourpackage.TourPackagePartialPojo;
import com.tourcoreservice.pojo.tourpackage.TourPackageUpdatePojo;
import com.tourcoreservice.pojo.tourpackage.TourpackagePojo;
import com.tourcoreservice.response.tourpackage.PackageIdPojoResponse;
import com.tourcoreservice.response.tourpackage.TourPackageDetailedPojoListResponse;
import com.tourcoreservice.response.tourpackage.TourpackagePojoListResponse;
import com.tourcoreservice.response.tourpackage.TourpackagePojoResponse;

@Component
public class Tourpackagefacade {

	@Autowired
	TourpackageService tourPackageService;

	@Autowired
	AssetService assetService;

	@Autowired
	IterneryService iterneryService;

	public TourpackagePojoListResponse listAllPackage() {
		TourpackagePojoListResponse tourpackageListResponse = new TourpackagePojoListResponse();
		List<Tourpackage> tourpackageEntity = tourPackageService.listAllPackage();
		List<TourPackagePartialPojo> tourPackagePojo = ObjectMapperUtils.mapAll(tourpackageEntity,
				TourPackagePartialPojo.class);
		tourpackageListResponse.setTourpackagePojo(tourPackagePojo);
		return tourpackageListResponse;
	}

	public TourpackagePojoResponse getPackage(long id) {
		TourpackagePojoResponse tourpackageResponse = new TourpackagePojoResponse();
		Tourpackage tourpackageEntity = tourPackageService.getPackageById(id);
		TourpackagePojo tourpackagePojo = ObjectMapperUtils.map(tourpackageEntity, TourpackagePojo.class);
		tourpackageResponse.setTourpackagePojo(tourpackagePojo);
		return tourpackageResponse;

	}

	public PackageIdPojoResponse savePackageMainDetails(TourpackagePojo tourPackagePojo) {
		PackageIdPojoResponse packageIdResponse = new PackageIdPojoResponse();
		Tourpackage tourpackage = ObjectMapperUtils.map(tourPackagePojo, Tourpackage.class);
		Tourpackage tourpackageEntity = tourPackageService.savePackage(tourpackage);
		TourpackagePojo tourpackagePojo = ObjectMapperUtils.map(tourpackageEntity, TourpackagePojo.class);
		packageIdResponse.setTourpackagePojo(tourpackagePojo.getId());
		return packageIdResponse;
	}

	public TourpackagePojoResponse updatePakage(TourPackageUpdatePojo pack) {
		TourpackagePojoResponse tourpackageResponse = new TourpackagePojoResponse();
		Tourpackage existingtourpackage = tourPackageService.getPackageById(pack.getId());
		Facility facility = existingtourpackage.getFacility();
		Theme theme = existingtourpackage.getTheme();
		ifTheameExists(existingtourpackage, theme);
		Place place = existingtourpackage.getPlace();
		ifPlaceExist(existingtourpackage, place);
		Price price = existingtourpackage.getPrice();
		existingtourpackage.setPrice(price);
		existingtourpackage.setFacility(facility);
		ObjectMapperUtils.map(pack, existingtourpackage);
		Tourpackage tourpackageEntity = tourPackageService.savePackage(existingtourpackage);
		TourpackagePojo tourpackagePojo = ObjectMapperUtils.map(tourpackageEntity, TourpackagePojo.class);
		tourpackageResponse.setTourpackagePojo(tourpackagePojo);
		return tourpackageResponse;
	}

	private void ifPlaceExist(Tourpackage existingtourpackage, Place place) {
		if (!ObjectUtils.isEmpty(place)) {
			place = null;
			existingtourpackage.setPlace(place);
			tourPackageService.savePackage(existingtourpackage);
		}

	}

	private void ifTheameExists(Tourpackage existingtourpackage, Theme theme) {
		if (!ObjectUtils.isEmpty(theme)) {
			theme = null;
			existingtourpackage.setTheme(theme);
			tourPackageService.savePackage(existingtourpackage);
		}

	}

	@Transactional
	public void deletePackage(long id) {
		Tourpackage existingtourpackage = tourPackageService.getPackageById(id);
		List<Iternery> existingIternery = iterneryService.getIterneries();
		deleteExistingIterneries(existingIternery, id);
		Set<Asset> exstingAssets = existingtourpackage.getImages();
		Set<Asset> assetsSet = new HashSet<>();
		assetsSet.addAll(exstingAssets);
		existingtourpackage.getImages().removeAll(exstingAssets);

		for (Asset asset : assetsSet) {
			assetService.deleteAsset(asset);
		}

		tourPackageService.deletePackage(existingtourpackage);

	}

	private void deleteExistingIterneries(List<Iternery> existingIternery, long id) {
		for (Iternery iternery : existingIternery) {
			if (iternery.getTourpackage().getId() == id) {
				iterneryService.delete(iternery);
			}
		}

	}
	
	public void updatelastday(LastDayinfoPojo lastDayinfoPojo, long id) {
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		tourpackage.setLastdayDiscription(lastDayinfoPojo.getLastdayDiscription());
		tourpackage.setLastdayheading(lastDayinfoPojo.getLastdayheading());
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
	}

	// price
	public PackageIdPojoResponse createPrice(long id, PricePojo pricePojo) {
		PackageIdPojoResponse packageIdResponse = new PackageIdPojoResponse();
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		Price price = ObjectMapperUtils.map(pricePojo, Price.class);
		price = tourPackageService.savePrice(price);
		tourpackage.setPrice(price);
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
		packageIdResponse.setTourpackagePojo(tourpackage.getId());
		return packageIdResponse;

	}

	public PackageIdPojoResponse createFacility(long id, FacilityPojo facilityPojo) {
		PackageIdPojoResponse packageIdResponse = new PackageIdPojoResponse();
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		Facility facility = ObjectMapperUtils.map(facilityPojo, Facility.class);
		facility = tourPackageService.saveFacity(facility);
		tourpackage.setFacility(facility);
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
		packageIdResponse.setTourpackagePojo(tourpackage.getId());
		return packageIdResponse;
	}

	public PackageIdPojoResponse createInclusion(long id, InclusionPojo inclusionPojo) {
		PackageIdPojoResponse packageIdResponse = new PackageIdPojoResponse();
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		// Inclusion inclusion = ObjectMapperUtils.map(inclusionPojo, Inclusion.class);
		tourpackage.setInclusion(inclusionPojo.getInclusion());
		tourpackage.setExclusion(inclusionPojo.getExclusion());
		tourpackage.setAdditionalinfo(inclusionPojo.getAdditionalinfo());
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
		packageIdResponse.setTourpackagePojo(tourpackage.getId());
		return packageIdResponse;
	}

	public PackageIdPojoResponse createImage(long id, MultipartFile file) throws IOException, URISyntaxException {
		PackageIdPojoResponse packageIdResponse = new PackageIdPojoResponse();
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		Asset asset = new Asset();
		asset.setFiletype(file.getContentType());
		asset.setFilesize(String.valueOf(file.getSize()));
		asset.setImagename(file.getName());
		
		Gcs googleCloudStorage = new Gcs("src/main/resources/apt-footing-323918-bffa896f7493.json", "tour-package");
		// Bucket require globally unique names, so you'll probably need to change this
		Bucket bucket = googleCloudStorage.getBucket("western-bucket");
		String gcsurl = googleCloudStorage.uploadFile(file);
		asset.setGcsurl(gcsurl);
		Set<Asset> assetset = new HashSet<Asset>();
		assetset.add(asset);
		tourpackage.setImages(assetset);
		tourpackage = tourPackageService.UpdatePackage(tourpackage);
		packageIdResponse.setTourpackagePojo(tourpackage.getId());
		return packageIdResponse;
	}

	public Set<Asset> getPackImage(long id) {
		Tourpackage tourpackage = tourPackageService.getPackageById(id);
		Set<Asset> asset = tourpackage.getImages();

		return asset;
	}

	public List<IterneryPojo> getIterneries(long packageId) {
		List<IterneryPojo> iterneriesPojoList = new ArrayList<>();
		List<Iternery> iterneryList = iterneryService.getIterneries();
		List<Iternery> iterneriesList = new ArrayList<Iternery>();
		for (Iternery iternery : iterneryList) {
			if (iternery.getTourpackage().getId() == packageId) {
				iterneriesList.add(iternery);
			}
		}
		iterneriesPojoList = ObjectMapperUtils.mapAll(iterneriesList, IterneryPojo.class);
		return iterneriesPojoList;
	}

	public TourPackageDetailedPojoListResponse listAllDetailedPackages() {
		TourPackageDetailedPojoListResponse tourpackageListResponse = new TourPackageDetailedPojoListResponse();
		List<Tourpackage> tourpackageEntity = tourPackageService.listAllPackage();
		List<TourpackagePojo> tourPackagePojo = ObjectMapperUtils.mapAll(tourpackageEntity, TourpackagePojo.class);
		tourpackageListResponse.setTourpackagePojo(tourPackagePojo);
		return tourpackageListResponse;
	}

	

	

	
}
