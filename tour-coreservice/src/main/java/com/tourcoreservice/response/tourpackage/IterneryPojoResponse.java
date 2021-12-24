package com.tourcoreservice.response.tourpackage;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.IterneryPojo;

public class IterneryPojoResponse  extends AbstractPojoResponse{
	public IterneryPojo iterneryPojo;

	public IterneryPojo getIterneryPojo() {
		return iterneryPojo;
	}

	public void setIterneryPojo(IterneryPojo iterneryPojo) {
		this.iterneryPojo = iterneryPojo;
	}

}