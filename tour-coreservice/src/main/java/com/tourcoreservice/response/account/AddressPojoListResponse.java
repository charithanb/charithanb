package com.tourcoreservice.response.account;

import java.util.List;

import com.tourcoreservice.pojo.account.AddressPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class AddressPojoListResponse extends AbstractPojoResponse {
	public List<AddressPojo> addressPojo;

	public List<AddressPojo> getAddressPojo() {
		return addressPojo;
	}

	public void setAddressPojo(List<AddressPojo> addressPojo) {
		this.addressPojo = addressPojo;
	}

	

}
