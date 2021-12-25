package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.ApproverRepository;
import com.tourcoreservice.entity.Approver;

@Service
public class ApproverService {

	@Autowired
	private ApproverRepository approverRepository;

	public Approver create(Approver approver) {
		return approverRepository.save(approver);
	}

	public List<Approver> listAll() {
		return approverRepository.findAll();
	}

	public Approver getApproverById(Long id) {
		return approverRepository.findById(id).get();
	}

	public void deleteApprover(long id) {
		approverRepository.deleteById(id);

	}

	public Approver Update(Approver approver) {
		return approverRepository.save(approver);
	}

}
