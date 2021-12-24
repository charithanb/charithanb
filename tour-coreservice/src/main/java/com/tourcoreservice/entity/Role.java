package com.tourcoreservice.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String name;

	private String code;

	@ManyToMany(targetEntity = User.class, mappedBy = "roles", cascade = CascadeType.DETACH)
	private List<User> users;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "roles_priviges")
	private List<Privilege> privileges;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "parent_id")
	private Role parentGroup;

	@OneToMany(mappedBy = "parentGroup")
	private Set<Role> childGroup;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public Role getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(Role parentGroup) {
		this.parentGroup = parentGroup;
	}

	public Set<Role> getChildGroup() {
		return childGroup;
	}

	public void setChildGroup(Set<Role> childGroup) {
		this.childGroup = childGroup;
	}

}
