package com.tourcoreservice.response.account;

import java.util.List;

import com.tourcoreservice.pojo.account.CustomerPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class CustomerPojoListResponse extends AbstractPojoResponse {

	List<CustomerPojo> customerPojo;

	public List<CustomerPojo> getCustomerPojo() {
		return customerPojo;
	}

	public void setCustomerPojo(List<CustomerPojo> customerPojo) {
		this.customerPojo = customerPojo;
	}

}
