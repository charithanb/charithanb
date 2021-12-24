package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.AssetRepository;
import com.tourcoreservice.entity.Asset;

@Service
public class AssetService {

	@Autowired
	private AssetRepository assetRepository;

	public List<Asset> listAllAsset() {
		return assetRepository.findAll();
	}

	public Asset saveAsset(Asset asset) {
		return assetRepository.save(asset);
	}

	public Asset UpdateAsset(Asset asset) {
		return assetRepository.save(asset);
	}

	public Asset getAssetById(long id) {
		return assetRepository.findById(id).get();
	}

	public void deleteAssetById(long id) {
		assetRepository.deleteById(id);
	}

	public void deleteAsset(Asset asset) {
		assetRepository.delete(asset);

	}
}
