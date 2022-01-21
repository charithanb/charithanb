package com.tour.facade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.tour.service.AssetService;
import com.tour.service.HotelService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Asset;
import com.tourcoreservice.entity.Category;
import com.tourcoreservice.entity.Hotel;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.AssetPojo;
import com.tourcoreservice.pojo.tourpackage.HotelPartialPojo;
import com.tourcoreservice.pojo.tourpackage.HotelPojo;
import com.tourcoreservice.pojo.tourpackage.HotelUpdatePojo;
import com.tourcoreservice.response.tourpackage.HotelPojoListResponse;
import com.tourcoreservice.response.tourpackage.HotelPojoResponse;

@Component
public class HotelFacade {

	@Autowired
	HotelService hotelService;
	@Autowired
	AssetService assetService;

	public HotelPojoListResponse listAllHotel() {
		HotelPojoListResponse hotelListResponse = new HotelPojoListResponse();
		List<Hotel> HotelEntity = hotelService.listAllHotel();
		List<HotelPartialPojo> hotelPojo = ObjectMapperUtils.mapAll(HotelEntity, HotelPartialPojo.class);
		hotelListResponse.setHotelPojo(hotelPojo);
		return hotelListResponse;
	}

	public HotelPojoResponse getHotel(long id) {
		ifDataDoesNotExist(id);
		HotelPojoResponse hotelResponse = new HotelPojoResponse();
		Hotel hotelEntity = hotelService.getHotelById(id);
		HotelPojo hotelPojo = ObjectMapperUtils.map(hotelEntity, HotelPojo.class);
		hotelResponse.setHotelPojo(hotelPojo);
		return hotelResponse;
	}

	private void ifDataDoesNotExist(long id) {
		Hotel hotel = hotelService.getHotelById(id);
		if (ObjectUtils.isEmpty(hotel)) {
			throw new DataDoesNotExistException("Data doesn't exist");
		}

	}

	public HotelPojoResponse saveHotel(HotelPojo hotelPojo) {
		ifDataAlreadyExists(hotelPojo.getId());
		Hotel hotelEntity = ObjectMapperUtils.map(hotelPojo, Hotel.class);
		Set<Asset> assetEntity = new HashSet<>();
		for (Asset asset : hotelEntity.getImages()) {
			Asset savedAsset = assetService.saveAsset(asset);
			assetEntity.add(savedAsset);
		}
		if (!CollectionUtils.isEmpty(assetEntity)) {
			hotelEntity.setImages(assetEntity);
		}
		Hotel hotelserviceEntity = hotelService.saveHotel(hotelEntity);
		HotelPojo hotelservicePojo = ObjectMapperUtils.map(hotelserviceEntity, HotelPojo.class);
		return createDeleteUpdateResponse(hotelservicePojo, "Created successfully");
	}

	private void ifDataAlreadyExists(long id) {
		Hotel hotel = hotelService.getHotelById(id);
		if (!ObjectUtils.isEmpty(hotel)) {
			throw new DataAlreadyExistException("Data already exists");
		}

	}

	public HotelPojoResponse updateHotel(HotelUpdatePojo hotelPojo) {
		ifDataDoesNotExist(hotelPojo.getId());
		Hotel existingHotel = hotelService.getHotelById(hotelPojo.getId());
		Set<Category> category = existingHotel.getCategories();
		existingHotel = ifCategoryExists(existingHotel, category);
		ObjectMapperUtils.map(hotelPojo, existingHotel);
		Hotel hotelserviceEntity = hotelService.UpdateHotel(existingHotel);
		HotelPojo hotelservicePojo = ObjectMapperUtils.map(hotelserviceEntity, HotelPojo.class);
		return createDeleteUpdateResponse(hotelservicePojo, "Updated successfully");
	}

	private Hotel ifCategoryExists(Hotel existingHotel, Set<Category> categories) {
		if (!CollectionUtils.isEmpty(categories)) {
			existingHotel.getCategories().removeAll(categories);
			hotelService.saveHotel(existingHotel);
		}
		return existingHotel;

	}

	public HotelPojoResponse deleteHotel(long id) {
		ifDataDoesNotExist(id);
		hotelService.deleteHotel(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	private HotelPojoResponse createDeleteUpdateResponse(HotelPojo hotelservicePojo, String message) {
		HotelPojoResponse hotelResponce = new HotelPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		hotelResponce.setHotelPojo(hotelservicePojo);
		hotelResponce.setSuccessMessaages(successMessaages);
		return hotelResponce;
	}

	public HotelPojoResponse deleteAsset(long id, long hotelid) {
		Hotel hotel = hotelService.getHotelById(hotelid);
		Asset asset = assetService.getAssetById(id);
		hotel.getImages().remove(asset);
		hotelService.UpdateHotel(hotel);
		assetService.deleteAssetById(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public HotelPojoResponse addHotelImage(long id, AssetPojo assetPojo) {
		Hotel hotel = hotelService.getHotelById(id);
		Asset asset2 = ObjectMapperUtils.map(assetPojo, Asset.class);
		Asset savedAsset = assetService.saveAsset(asset2);
//		hotel.setImages(savedasset);
		Set<Asset> Existingassets = hotel.getImages();
		Existingassets.add(savedAsset);
		hotel.setImages(Existingassets);
		hotelService.UpdateHotel(hotel);
		return createDeleteUpdateResponse(null, "updated successfully");
	}
}
