package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.account.accountservice.service.CustomerService;
import com.tourcoreservice.entity.Address;
import com.tourcoreservice.entity.Customer;
import com.tourcoreservice.entity.Role;
import com.tourcoreservice.entity.User;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.account.CustomerPojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.response.account.CustomerPojoListResponse;
import com.tourcoreservice.response.account.CustomerPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomerFacade {

	@Autowired
	CustomerService customerService;

	@Value("${customer.create.success}")
	private String customerCreatedSuccessfully;

	@Value("${customer.update.success}")
	private String updateSuccessfully;

	@Value("${customer.delete.success}")
	private String customerDeleteSuccessfully;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Value("${role.customer}")
	private String roleCustomer;

	public CustomerPojoResponse create(CustomerPojo customerPojo) {
		// exception handle
		ifCustomerExists(customerPojo.getId());
		Customer customer = ObjectMapperUtils.map(customerPojo, Customer.class);
		String hashPassword = passwordEncoder.encode(customerPojo.getPassword());
		customer.setPassword(hashPassword);
		customer = customerService.create(customer);
		customerPojo = ObjectMapperUtils.map(customer, CustomerPojo.class);
		return createDeleteUpdateResponse(customerCreatedSuccessfully, customerPojo);
	}

	private void ifCustomerExists(long id) {
		User customer = customerService.findById(id);
		if (!ObjectUtils.isEmpty(customer)) {
			throw new DataAlreadyExistException("Data already exists");
		}

	}

	private CustomerPojoResponse createDeleteUpdateResponse(String message, CustomerPojo customerPojo) {
		CustomerPojoResponse customerPojoResponse = new CustomerPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customerPojoResponse.setCustomerPojo(customerPojo);
		customerPojoResponse.setSuccessMessaages(successMessages);
		return customerPojoResponse;
	}

	public CustomerPojoListResponse get() {
		CustomerPojoListResponse customerPojoListResponse = new CustomerPojoListResponse();
		List<User> customerEntity = customerService.findAllCustomers(roleCustomer);
		List<CustomerPojo> customerPojoList = ObjectMapperUtils.mapAll(customerEntity, CustomerPojo.class);
		customerPojoListResponse.setCustomerPojo(customerPojoList);
		return customerPojoListResponse;
	}

	public CustomerPojoResponse update(CustomerPojo customerPojo) {
		ifCustomerDoesNotExist(customerPojo.getId());
		User userEntity = customerService.findById(customerPojo.getId());
		deleteExistingRoles(userEntity, userEntity.getRoles());
		deleteExistingAddresses(userEntity, userEntity.getAddresses());
		ObjectMapperUtils.map(customerPojo, userEntity);
		String hashPassword = passwordEncoder.encode(customerPojo.getPassword());
		userEntity.setPassword(hashPassword);
		userEntity = customerService.update(userEntity);
		customerPojo = ObjectMapperUtils.map(userEntity, CustomerPojo.class);
		return createDeleteUpdateResponse(updateSuccessfully, customerPojo);

	}

	private void ifCustomerDoesNotExist(long id) {
		User customer = customerService.findById(id);
		if(ObjectUtils.isEmpty(customer)) {
			throw new DataDoesNotExistException("Customer data doesn't exist");
		}
		
	}

	private void deleteExistingAddresses(User user, Set<Address> addresses) {
		user.getAddresses().removeAll(addresses);
		customerService.save(user);
	}

	private void deleteExistingRoles(User user, List<Role> roles) {
		user.getRoles().removeAll(roles);
		customerService.save(user);
	}

	public CustomerPojoResponse delete(long id) {
		ifCustomerDoesNotExist(id);
		User userEntity = customerService.findById(id);
		customerService.delete(userEntity);
		return createDeleteUpdateResponse(customerDeleteSuccessfully, null);
	}

	public CustomerPojoResponse getCustomerById(long customerId) {
		ifCustomerDoesNotExist(customerId);
		User userEntity = customerService.findById(customerId);
		CustomerPojo customerPojo = ObjectMapperUtils.map(userEntity, CustomerPojo.class);
		return createDeleteUpdateResponse("", customerPojo);
	}

}
