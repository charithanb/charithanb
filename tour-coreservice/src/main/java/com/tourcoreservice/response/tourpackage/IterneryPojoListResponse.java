package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.IterneryPojo;

public class IterneryPojoListResponse  extends AbstractPojoResponse{
	public List<IterneryPojo> iterneryListPojo;

	public List<IterneryPojo> getIterneryListPojo() {
		return iterneryListPojo;
	}

	public void setIterneryListPojo(List<IterneryPojo> iterneryListPojo) {
		this.iterneryListPojo = iterneryListPojo;
	}

}
