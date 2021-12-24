package com.tourcoreservice.pojo.tourpackage;

import java.util.List;

public class MainPlacePojo {
	private Long id;
	private String name;
	private TalukPojo taluk;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TalukPojo getTaluk() {
		return taluk;
	}

	public void setTaluk(TalukPojo taluk) {
		this.taluk = taluk;
	}

}
