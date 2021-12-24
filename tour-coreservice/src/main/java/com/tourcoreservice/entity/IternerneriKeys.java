package com.tourcoreservice.entity;

import java.io.Serializable;

public class IternerneriKeys implements Serializable {

	private long id;
	private long day;
	
	public IternerneriKeys() {
		
	}

	public IternerneriKeys(long id, long day) {
		super();
		this.id = id;
		this.day = day;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (day ^ (day >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IternerneriKeys other = (IternerneriKeys) obj;
		if (day != other.day)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
