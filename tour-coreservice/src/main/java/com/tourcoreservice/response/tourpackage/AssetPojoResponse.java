package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.AssetPojo;

public class AssetPojoResponse extends AbstractPojoResponse{

	AssetPojo assetPojo;

	public AssetPojo getAssetPojo() {
		return assetPojo;
	}

	public void setAssetPojo(AssetPojo assetPojo) {
		this.assetPojo = assetPojo;
	}
}
