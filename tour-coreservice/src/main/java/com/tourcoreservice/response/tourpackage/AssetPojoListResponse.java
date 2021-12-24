package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.AssetPojo;

public class AssetPojoListResponse extends AbstractPojoResponse{

	List<AssetPojo>  assetpojo;

	public List<AssetPojo> getAssetpojo() {
		return assetpojo;
	}

	public void setAssetpojo(List<AssetPojo> assetpojo) {
		this.assetpojo = assetpojo;
	}
}
