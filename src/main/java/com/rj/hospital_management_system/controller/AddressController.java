package com.rj.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rj.hospital_management_system.dto.Address;
import com.rj.hospital_management_system.service.AddressService;
import com.rj.hospital_management_system.util.ResponseStructure;

@RestController
public class AddressController 
{
	@Autowired
	private AddressService service ;
	
	@PostMapping("/Address")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address)
	{
		return service.saveAddress(address) ;
	}
	
	@GetMapping("/Address")
	public ResponseEntity<ResponseStructure<Address>> findAddress(@PathVariable int id)
	{
		return service.findAddress(id) ;
	}
	
	@GetMapping("/findAllAddress")
	public ResponseEntity<ResponseStructure<List<Address>>> findAllAddress()
	{
		return service.findAllAddress() ;
	}
	
	@DeleteMapping("/Address")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@PathVariable int id)
	{
		return service.deleteAddress(id) ;
	}
	
	@PutMapping("/Address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int id,@RequestBody Address address)
	{
		return service.updateAddress(id, address) ;
	}
}
