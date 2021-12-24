package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.CustomerPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class CustomerPojoResponse extends AbstractPojoResponse {

	CustomerPojo customerPojo;

	public CustomerPojo getCustomerPojo() {
		return customerPojo;
	}

	public void setCustomerPojo(CustomerPojo customerPojo) {
		this.customerPojo = customerPojo;
	}

}
