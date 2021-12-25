package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.ApproverHirarchyService;
import com.tourcoreservice.entity.ApproverHirarchy;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.ApproverHirarchyPojo;
import com.tourcoreservice.response.orders.ApproverHirarchyPojoListResponse;
import com.tourcoreservice.response.orders.ApproverHirarchyPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class ApproverHirarchyFacade {

	@Autowired
	private ApproverHirarchyService approverHirarchyService;

	public ApproverHirarchyPojoResponse create(ApproverHirarchyPojo approverHirarchyPojo) {
		ApproverHirarchy approverHirarchy = ObjectMapperUtils.map(approverHirarchyPojo, ApproverHirarchy.class);
		approverHirarchy = approverHirarchyService.create(approverHirarchy);
		approverHirarchyPojo = ObjectMapperUtils.map(approverHirarchy, ApproverHirarchyPojo.class);
		return createDeleteUpdateResponse(approverHirarchyPojo, "Order created Successfully ");
	}

	private ApproverHirarchyPojoResponse createDeleteUpdateResponse(ApproverHirarchyPojo approverHirarchyPojo,
			String message) {
		ApproverHirarchyPojoResponse approverHirarchyPojoResponse = new ApproverHirarchyPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		approverHirarchyPojoResponse.setApproverHirarchyPojo(approverHirarchyPojo);
		approverHirarchyPojoResponse.setSuccessMessaages(successMessages);
		return approverHirarchyPojoResponse;
	}

	public ApproverHirarchyPojoListResponse listAll() {
		ApproverHirarchyPojoListResponse approverHirarchyPojoListResponse = new ApproverHirarchyPojoListResponse();
		List<ApproverHirarchy> approverHirarchy = approverHirarchyService.listAll();
		List<ApproverHirarchyPojo> approverHirarchyPojo = ObjectMapperUtils.mapAll(approverHirarchy,
				ApproverHirarchyPojo.class);
		approverHirarchyPojoListResponse.setApproverHirarchyPojo(approverHirarchyPojo);
		return approverHirarchyPojoListResponse;
	}

	public ApproverHirarchyPojoResponse getApproverHirarchyByid(Long id) {
		ApproverHirarchyPojoResponse approverHirarchyPojoResponse = new ApproverHirarchyPojoResponse();
		ApproverHirarchy approverHirarchy = approverHirarchyService.getApproverHirarchyById(id);
		ApproverHirarchyPojo approverHirarchyPojo = ObjectMapperUtils.map(approverHirarchy, ApproverHirarchyPojo.class);
		approverHirarchyPojoResponse.setApproverHirarchyPojo(approverHirarchyPojo);
		return approverHirarchyPojoResponse;
	}

	public ApproverHirarchyPojoResponse delete(long id) {
		approverHirarchyService.deleteApproverHirarchy(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public ApproverHirarchyPojoResponse update(ApproverHirarchyPojo approverHirarchyPojo) {
		ApproverHirarchy approverHirarchy = approverHirarchyService
				.getApproverHirarchyById(approverHirarchyPojo.getId());
		ObjectMapperUtils.map(approverHirarchyPojo, approverHirarchy);
		approverHirarchy = approverHirarchyService.Update(approverHirarchy);
		approverHirarchyPojo = ObjectMapperUtils.map(approverHirarchy, ApproverHirarchyPojo.class);
		return createDeleteUpdateResponse(approverHirarchyPojo, "Updated successfully");
	}
}
