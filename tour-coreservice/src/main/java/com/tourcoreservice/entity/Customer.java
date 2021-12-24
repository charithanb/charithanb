package com.tourcoreservice.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CUSTOMER")  
public class Customer extends User {
private long customerId;

public long getCustomerId() {
	return customerId;
}

public void setCustomerId(long customerId) {
	this.customerId = customerId;
}

	
}
