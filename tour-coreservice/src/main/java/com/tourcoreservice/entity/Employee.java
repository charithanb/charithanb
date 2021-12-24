package com.tourcoreservice.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("EMPLOYEE")  
public class Employee  extends User{
private long employeeId;

public long getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(long employeeId) {
	this.employeeId = employeeId;
}

}
