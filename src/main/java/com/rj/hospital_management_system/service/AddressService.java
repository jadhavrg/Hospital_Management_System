package com.rj.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rj.hospital_management_system.dao.AddressDao;
import com.rj.hospital_management_system.dto.Address;
import com.rj.hospital_management_system.exception.DataNotFound;
import com.rj.hospital_management_system.exception.IdNotFound;
import com.rj.hospital_management_system.util.ResponseStructure;

@Service
public class AddressService 
{
	@Autowired
	private AddressDao dao ;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		ResponseStructure<Address> structure = new ResponseStructure<>() ;
		structure.setMessage("Data is saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Address>> findAddress(int id)
	{
		Address address = dao.findAddress(id) ;
		ResponseStructure<Address> structure = new ResponseStructure<>() ;
		if (address != null)
		{
			structure.setMessage("data is Found.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.FOUND) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress()
	{
		List<Address> addresses = dao.findAllAddress() ;
		ResponseStructure<List<Address>> structure = new ResponseStructure<>() ;
		if (addresses.isEmpty()) 
		{
			throw new DataNotFound("Data is not available") ;
		}
		else
		{
			structure.setMessage("Dta is available");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(addresses);
			return new ResponseEntity<ResponseStructure<List<Address>>>(structure, HttpStatus.FOUND) ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id)
	{
		Address address = dao.deleteAddress(id) ;
		ResponseStructure<Address> structure = new ResponseStructure<>() ;
		if (address != null) 
		{
			structure.setMessage("Data is deleted.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found.") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address)
	{
		Address dbAddress = dao.findAddress(id) ;
		ResponseStructure<Address> structure = new ResponseStructure<>() ;
		if (dbAddress != null) 
		{
			structure.setMessage("Data is updated successfully.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found.") ;
		}
	}
}
