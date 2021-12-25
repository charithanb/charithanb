package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.ApproverHirarchyRepository;
import com.tourcoreservice.entity.ApproverHirarchy;

@Service
public class ApproverHirarchyService {

	@Autowired
	private ApproverHirarchyRepository approverHirarchyRepository;

	public ApproverHirarchy create(ApproverHirarchy approverHirarchy) {
		return approverHirarchyRepository.save(approverHirarchy);
	}

	public List<ApproverHirarchy> listAll() {
		return approverHirarchyRepository.findAll();
	}

	public ApproverHirarchy getApproverHirarchyById(Long id) {
		return approverHirarchyRepository.findById(id).get();
	}

	public void deleteApproverHirarchy(long id) {
		approverHirarchyRepository.deleteById(id);
	}

	public ApproverHirarchy Update(ApproverHirarchy approverHirarchy) {
		return approverHirarchyRepository.save(approverHirarchy);
	}

}
