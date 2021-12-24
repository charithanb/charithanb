package com.tourcoreservice.pojo.generic;

import java.util.List;

public class AbstractPojoResponse {
	List<ResponseMessagePojo> successMessaages;
	List<ResponseMessagePojo> erorrMessagePojo;

	public List<ResponseMessagePojo> getSuccessMessaages() {
		return successMessaages;
	}

	public void setSuccessMessaages(List<ResponseMessagePojo> successMessaages) {
		this.successMessaages = successMessaages;
	}

	public List<ResponseMessagePojo> getErorrMessagePojo() {
		return erorrMessagePojo;
	}

	public void setErorrMessagePojo(List<ResponseMessagePojo> erorrMessagePojo) {
		this.erorrMessagePojo = erorrMessagePojo;
	}

}
