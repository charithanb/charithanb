package com.tourcoreservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
public class Image {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Lob
    byte[] content;

    
    String name;
    
    @Lob
    String base64;
    
    @Lob
    String description;
    
    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
	  private Set<Blog> blog;
    
    
    
    
	


	public Set<Blog> getBlog() {
		return blog;
	}


	public void setBlog(Set<Blog> blog) {
		this.blog = blog;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBase64() {
		return base64;
	}


	public void setBase64(String base64) {
		this.base64 = base64;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public byte[] getContent() {
		return content;
	}


	public void setContent(byte[] content) {
		this.content = content;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

}
