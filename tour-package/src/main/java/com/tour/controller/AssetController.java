package com.tour.controller;

import java.io.IOException;
import java.net.URISyntaxException;

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

import com.tour.facade.AssetFacade;
import com.tourcoreservice.pojo.tourpackage.AssetPojo;
import com.tourcoreservice.response.tourpackage.AssetPojoListResponse;
import com.tourcoreservice.response.tourpackage.AssetPojoResponse;


@RestController
@RequestMapping("/asset")
public class AssetController {

	@Autowired
	AssetFacade assetFacade;

	@GetMapping
	public AssetPojoListResponse getAll() {
		return assetFacade.listAllAssets();
	}

	@GetMapping("/{id}")
	public AssetPojoResponse get(@PathVariable long id) {
		return assetFacade.getAssets(id);

	}

	@PostMapping("/{packageid}")
	public AssetPojoResponse create(@RequestParam("file") MultipartFile file, @PathVariable("packageid") long packageId) throws IOException, URISyntaxException {
		return assetFacade.saveAsset(file, packageId);
	}

	@PutMapping("/{id}")
	public AssetPojoResponse update(@RequestBody AssetPojo asset, @PathVariable long id) {
		asset.setId(id);
		return assetFacade.updateAsset(asset);

	}

	@DeleteMapping("/{id}/{packageid}")
	public void delete(@PathVariable long id, @PathVariable long packageid) {
		assetFacade.deleteAsset(id, packageid);
	}
	
}
