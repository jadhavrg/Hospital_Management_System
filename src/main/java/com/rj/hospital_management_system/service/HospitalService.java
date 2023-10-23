package com.rj.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rj.hospital_management_system.dao.HospitalDao;
import com.rj.hospital_management_system.dto.Hospital;
import com.rj.hospital_management_system.exception.IdNotFound;
import com.rj.hospital_management_system.util.ResponseStructure;

@Service
public class HospitalService 
{
	@Autowired
	private HospitalDao dao ;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital)
	{
		ResponseStructure<Hospital> structure = new ResponseStructure<>() ;
		structure.setMessage("Data is inserted successfully.");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveHospital(hospital));
		
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> findHospital(int id)
	{
		Hospital hospital = dao.findHospital(id) ;
		ResponseStructure<Hospital> structure = new ResponseStructure<>() ;
		if (hospital != null)
		{
			structure.setMessage("Data is found.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHosEntity(int id) 
	{
		Hospital hospital = dao.deleteHospital(id) ;
		ResponseStructure<Hospital> structure = new ResponseStructure<>() ;
		if (hospital != null)
		{
			structure.setMessage("data is deleted.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital)
	{
		Hospital dbHospital = dao.deleteHospital(id) ;
		ResponseStructure<Hospital> structure = new ResponseStructure<>() ;
		if (dbHospital != null)
		{
			structure.setMessage("data is deleted.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateHospital(id, hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
}
