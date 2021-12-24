package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.IterneryRepository;
import com.tourcoreservice.entity.Iternery;

@Service
public class IterneryService {

	@Autowired
	private IterneryRepository iterneryRepository;

	public Iternery create(Iternery iternery) {
		return iterneryRepository.save(iternery);
	}

	public List<Iternery> getAll() {

		return iterneryRepository.findAll();
	}

	public List<Iternery> findAllIterneryByPackId(long packid) {
		return iterneryRepository.findAllIterneryBypack(packid);
	}
	public Iternery findIterneryById(long id) {
		return iterneryRepository.findById(id);
	}

	public Iternery update(Iternery iternery) {

		return iterneryRepository.save(iternery);
	}

	public void delete(Iternery iternery) {
		iterneryRepository.delete(iternery);
	}

	public  List<Iternery> getIterneries() {
		// TODO Auto-generated method stub
		return iterneryRepository.findAll();
	}
}
