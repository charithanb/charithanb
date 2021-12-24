package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.AddressPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class AddressPojoResponse extends AbstractPojoResponse {

	public AddressPojo addressPojo;

	public AddressPojo getAddressPojo() {
		return addressPojo;
	}

	public void setAddressPojo(AddressPojo addressPojo) {
		this.addressPojo = addressPojo;
	}

}
