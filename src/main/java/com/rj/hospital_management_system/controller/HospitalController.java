package com.rj.hospital_management_system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rj.hospital_management_system.dto.Hospital;
import com.rj.hospital_management_system.service.HospitalService;
import com.rj.hospital_management_system.util.ResponseStructure;

@RestController
//@RequestMapping("/hospital")
public class HospitalController 
{
	@Autowired
	private HospitalService service ;
	
	@PostMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital)
	{
		return service.saveHospital(hospital) ;
	}
	
	@GetMapping("/hospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> findHospital(@PathVariable int id)
	{
		return service.findHospital(id) ;
	}
	
	@DeleteMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) 
	{
		return service.deleteHosEntity(id) ;
	}
	
	@PutMapping("/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@Valid int id, Hospital hospital)
	{
		return service.updateHospital(id, hospital) ;
	}
}
