package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.ApproversRegionRepository;
import com.tourcoreservice.entity.ApproverRegion;

@Service
public class ApproversRegionService {

	@Autowired
	private ApproversRegionRepository approversRegionRepository;

	public ApproverRegion create(ApproverRegion approverRegion) {
		return approversRegionRepository.save(approverRegion);
	}

	public List<ApproverRegion> listAll() {
		return approversRegionRepository.findAll();
	}

	public ApproverRegion getyId(Long id) {
		return approversRegionRepository.findById(id).get();
	}

	public void deleteById(long id) {
		approversRegionRepository.deleteById(id);

	}

	public ApproverRegion Update(ApproverRegion approverRegion) {
		return approversRegionRepository.save(approverRegion);
	}

	public ApproverRegion findRegionByName(String regionName) {
		return approversRegionRepository.findByregionName(regionName);
	}

	public ApproverRegion getApproverByRegionName(String regionName) {
		return approversRegionRepository.findByregionName(regionName);
	}

}
