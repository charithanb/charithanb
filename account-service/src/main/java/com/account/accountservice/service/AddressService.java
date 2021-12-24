package com.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.accountservice.repository.AddressRepository;
import com.tourcoreservice.entity.Address;
import com.tourcoreservice.entity.User;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	public Address create(Address address) {
		return addressRepository.save(address);
	}

	
	public List<Address> listAll() {
		return addressRepository.findAll();
	}

	public void delete(long id) {
		addressRepository.deleteById(id);
	}


	public Address Update(Address address) {
		return addressRepository.save(address);
	}


	public Address getById(long id) {
		return addressRepository.findById(id).get();
	}

	
	

}
