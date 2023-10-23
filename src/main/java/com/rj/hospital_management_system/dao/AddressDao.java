package com.rj.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.hospital_management_system.dto.Address;
import com.rj.hospital_management_system.repo.AddressRepo;

@Repository
public class AddressDao 
{
	@Autowired
	private AddressRepo repo ;
	
	public Address saveAddress(Address address)
	{
		return repo.save(address) ;
	}
	
	public Address findAddress(int id) 
	{
		Optional<Address> optional = repo.findById(id) ;
		if (optional.isPresent())
		{
			return optional.get() ;
		}
		return null ;
	}
	
	public List<Address> findAllAddress()
	{
		return repo.findAll() ;
	}
	
	public Address deleteAddress(int id) 
	{
		Optional<Address> optional = repo.findById(id) ;
		if (optional.isPresent())
		{
			repo.deleteById(id);
			return optional.get() ;		
		}
		else
		{
			return null ;
		}
	}
	
	public Address updateAddress(int id, Address address)
	{
		Optional<Address> optional = repo.findById(id) ;
		if (optional.isEmpty())
		{
			return null ;
		}
		address.setId(id); 
		return repo.save(address) ;
	}
}
