package com.tour.facade;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.services.storage.Storage;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.tour.service.AssetService;
import com.tour.service.TourpackageService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Asset;
import com.tourcoreservice.entity.Tourpackage;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.AssetPojo;
import com.tourcoreservice.response.tourpackage.AssetPojoListResponse;
import com.tourcoreservice.response.tourpackage.AssetPojoResponse;

@Component
public class AssetFacade {

	@Autowired
	private AssetService assetService;

	@Autowired
	private TourpackageService tourPackageService;

	public AssetPojoListResponse listAllAssets() {
		AssetPojoListResponse assetListResponse = new AssetPojoListResponse();
		List<Asset> assetEntity = assetService.listAllAsset();
		List<AssetPojo> assetPojo = ObjectMapperUtils.mapAll(assetEntity, AssetPojo.class);
		assetListResponse.setAssetpojo(assetPojo);
		return assetListResponse;
	}

	public AssetPojoResponse getAssets(long id) {
		AssetPojoResponse assetResponse = new AssetPojoResponse();
		Asset assetEntity = assetService.getAssetById(id);
		AssetPojo assetPojo = ObjectMapperUtils.map(assetEntity, AssetPojo.class);
		assetResponse.setAssetPojo(assetPojo);
		return assetResponse;

	}

	public AssetPojoResponse saveAsset(MultipartFile file, long packageId) throws IOException, URISyntaxException {
		Asset assetEntity = new Asset();
		assetEntity.setFiletype(file.getContentType());
		assetEntity.setFilesize(String.valueOf(file.getSize()));
		assetEntity.setImagename(file.getName());
		Gcs googleCloudStorage = new Gcs("test", "tour-package");
		// Bucket require globally unique names, so you'll probably need to change this
		Bucket bucket = googleCloudStorage.getBucket("western-bucket");
		String gcsurl = googleCloudStorage.uploadFile(file);
		assetEntity.setGcsurl(gcsurl);
		Asset assetServiceEntity = assetService.saveAsset(assetEntity);
		Tourpackage tourpackage = tourPackageService.getPackageById(packageId);
		Set<Asset> assets = tourpackage.getImages();
		assets.add(assetServiceEntity);
		tourpackage.setImages(assets);
		tourPackageService.savePackage(tourpackage);
		AssetPojo assetPojo = ObjectMapperUtils.map(assetServiceEntity, AssetPojo.class);
		return createDeleteUpdateResponse(assetPojo, "Created successfully");
	}

	public AssetPojoResponse updateAsset(AssetPojo asset) {

		Asset assetEntity = ObjectMapperUtils.map(asset, Asset.class);
		Asset assetServiceEntity = assetService.UpdateAsset(assetEntity);
		AssetPojo assetPojo = ObjectMapperUtils.map(assetServiceEntity, AssetPojo.class);
		return createDeleteUpdateResponse(assetPojo, "Updated successfully");
	}

	public AssetPojoResponse deleteAsset(long id, long packageid) {
		Tourpackage tourpackage = tourPackageService.getPackageById(packageid);
		Asset asset = assetService.getAssetById(id);
		tourpackage.getImages().remove(asset);
		tourPackageService.UpdatePackage(tourpackage);
		assetService.deleteAssetById(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	private AssetPojoResponse createDeleteUpdateResponse(AssetPojo assetPojo, String message) {
		AssetPojoResponse assetResponse = new AssetPojoResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		assetResponse.setAssetPojo(assetPojo);
		assetResponse.setSuccessMessaages(successMessaages);
		return assetResponse;
	}

}
