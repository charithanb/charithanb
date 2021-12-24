package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.account.accountservice.service.AddressService;
import com.account.accountservice.service.UserService;
import com.tourcoreservice.entity.Address;
import com.tourcoreservice.entity.User;
import com.tourcoreservice.pojo.account.AddressPojo;
import com.tourcoreservice.pojo.account.UserPojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.response.account.AddressPojoListResponse;
import com.tourcoreservice.response.account.AddressPojoResponse;
import com.tourcoreservice.response.account.UserPojoListResponse;
import com.tourcoreservice.response.account.UserPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class AddressFacade {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private UserService uaerService;
	
	@Value("${customer.create.success}")
	private String customerCreatedSuccessfully;

	@Value("${customer.update.success}")
	private String updateSuccessfully;

	@Value("${customer.delete.success}")
	private String customerDeleteSuccessfully;

	public AddressPojoResponse create(AddressPojo adressPojo) {
		Address address = ObjectMapperUtils.map(adressPojo, Address.class);
		address = addressService.create(address);
		adressPojo = ObjectMapperUtils.map(address, AddressPojo.class);
		return createDeleteUpdateResponse(adressPojo, customerCreatedSuccessfully);
	}

	private AddressPojoResponse createDeleteUpdateResponse(AddressPojo adressPojo,
			String message) {
		AddressPojoResponse addressPojoResponse = new AddressPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		addressPojoResponse.setAddressPojo(adressPojo);
		addressPojoResponse.setSuccessMessaages(successMessages);
		return addressPojoResponse;
	}

	public AddressPojoListResponse listAll() {
		AddressPojoListResponse addressPojoListResponse = new AddressPojoListResponse();
		List<Address> address = addressService.listAll();
		List<AddressPojo> addressPojo = ObjectMapperUtils.mapAll(address, AddressPojo.class);
		addressPojoListResponse.setAddressPojo(addressPojo);
		return addressPojoListResponse;
	}

	public AddressPojoResponse delete(long id) {
		addressService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	public AddressPojoResponse update(AddressPojo addressPojo) {
		Address address = addressService.getById(addressPojo.getId());
		deleteExisistingAddress(address, address.getUser().getId());
		ObjectMapperUtils.map(addressPojo, address);
		address = addressService.Update(address);
		addressPojo = ObjectMapperUtils.map(address, AddressPojo.class);
		return createDeleteUpdateResponse(addressPojo, "Updated successfully");
	}

	private void deleteExisistingAddress(Address address, long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
