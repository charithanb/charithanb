package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.facade.IterneryFacade;
import com.tourcoreservice.pojo.tourpackage.AssetPojo;
import com.tourcoreservice.pojo.tourpackage.IterneryPojo;
import com.tourcoreservice.response.tourpackage.IterneryPojoListResponse;
import com.tourcoreservice.response.tourpackage.IterneryPojoResponse;

@RestController
@RequestMapping("/iternery")
public class IterneryController {

	@Autowired
	private IterneryFacade iterneryFacade;

	@PostMapping
	public IterneryPojoResponse create(@RequestBody IterneryPojo iterneryPojo) {
		return iterneryFacade.create(iterneryPojo);
	}

	@GetMapping
	public IterneryPojoListResponse get() {
		return iterneryFacade.getAll();
	}

	@GetMapping("/{id}")
	public IterneryPojoListResponse getbyPackId(@PathVariable long id) {
		
		return iterneryFacade.getByPackageID(id);
		
	}
	@PutMapping
	public IterneryPojoResponse update(@RequestBody IterneryPojo iterneryPojo) {
		return iterneryFacade.update(iterneryPojo);

	}
	@PostMapping("/image/{id}")
	public void addIterneryImage(@RequestBody AssetPojo asset, @PathVariable long id) {
		iterneryFacade.addIternryImage(id,asset);
	}
	@DeleteMapping("/{id}/{iterneryid}")
	public void deleteAsset(@PathVariable long id,@PathVariable long iterneryid) {
		iterneryFacade.deleteAsset(id,iterneryid);
	}
	@DeleteMapping("{id}")
	public IterneryPojoResponse delete(@PathVariable("id") long Id) {
		return iterneryFacade.delete(Id);
		
	}
}