package com.tourcoreservice.pojo.tourpackage;

import java.util.Set;

public class AssetPojo {
	private long id;
	private String imagename;
	private String filetype;
	private String filesize;
	private byte[] image;
	private Set<TourpackagePojo> tourpackage;
	private String gcsurl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<TourpackagePojo> getTourpackage() {
		return tourpackage;
	}

	public void setTourpackage(Set<TourpackagePojo> tourpackage) {
		this.tourpackage = tourpackage;
	}

	public String getGcsurl() {
		return gcsurl;
	}

	public void setGcsurl(String gcsurl) {
		this.gcsurl = gcsurl;
	}

}
