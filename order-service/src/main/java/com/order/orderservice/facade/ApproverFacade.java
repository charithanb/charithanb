package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.ApproverService;
import com.tourcoreservice.entity.Approver;
import com.tourcoreservice.entity.User;
import com.tourcoreservice.pojo.account.UserPojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.ApproverPojo;
import com.tourcoreservice.response.orders.ApproverPojoListResponse;
import com.tourcoreservice.response.orders.ApproverPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class ApproverFacade {

	@Autowired
	private ApproverService approverService;

	public ApproverPojoResponse create(ApproverPojo approverPojo) {
		Approver approver = ObjectMapperUtils.map(approverPojo, Approver.class);
		approver = approverService.create(approver);
		approverPojo = ObjectMapperUtils.map(approver, ApproverPojo.class);
		return createDeleteUpdateResponse(approverPojo, "Approver created Successfully ");
	}

	private ApproverPojoResponse createDeleteUpdateResponse(ApproverPojo approverPojo, String message) {
		ApproverPojoResponse approverPojoResponse = new ApproverPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		approverPojoResponse.setApproverPojo(approverPojo);
		approverPojoResponse.setSuccessMessaages(successMessages);
		return approverPojoResponse;
	}

	public ApproverPojoListResponse listAll() {
		ApproverPojoListResponse approverPojoListResponse = new ApproverPojoListResponse();
		List<Approver> approver = approverService.listAll();
		List<ApproverPojo> approverPojo = ObjectMapperUtils.mapAll(approver, ApproverPojo.class);
		approverPojoListResponse.setApproverPojo(approverPojo);
		return approverPojoListResponse;
	}

	public ApproverPojoResponse getByid(Long id) {
		ApproverPojoResponse approverPojoResponse = new ApproverPojoResponse();
		Approver approver = approverService.getApproverById(id);
		ApproverPojo approverPojo = ObjectMapperUtils.map(approver, ApproverPojo.class);
		approverPojoResponse.setApproverPojo(approverPojo);
		return approverPojoResponse;
	}

	public ApproverPojoResponse delete(long id) {
		approverService.deleteApprover(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	public ApproverPojoResponse update(ApproverPojo approverPojo) {
		Approver approver = approverService.getApproverById(approverPojo.getId());
		ObjectMapperUtils.map(approverPojo, approver);
		approver = approverService.Update(approver);
		approverPojo = ObjectMapperUtils.map(approver, ApproverPojo.class);
		return createDeleteUpdateResponse(approverPojo, "Updated successfully");
	}

	public UserPojo findById(long id) {
		Approver approver = approverService.getApproverById(id);
		User employee = approver.getEmployee();
		UserPojo employeePojo = ObjectMapperUtils.map(employee, UserPojo.class);
		return employeePojo;
	}

}
