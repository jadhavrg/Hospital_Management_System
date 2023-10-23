package com.rj.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rj.hospital_management_system.dao.EncounterDao;
import com.rj.hospital_management_system.dto.Encounter;
import com.rj.hospital_management_system.exception.DataNotFound;
import com.rj.hospital_management_system.exception.IdNotFound;
import com.rj.hospital_management_system.util.ResponseStructure;

@Service
public class EncounterService
{
	@Autowired
	private EncounterDao dao ;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter) 
	{
		ResponseStructure<Encounter> structure = new ResponseStructure<>() ;
		structure.setMessage("Data is saved successfully.");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(encounter);
		return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter(int id) 
	{
		Encounter encounter = dao.getEncounter(id) ;
		ResponseStructure<Encounter> structure = new ResponseStructure<>() ;
		if (encounter != null) 
		{
			structure.setMessage("Data is found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.FOUND) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounter() 
	{
		List<Encounter> encounters = dao.getAllEncounter() ;
		ResponseStructure<List<Encounter>> structure = new ResponseStructure<>() ;
		if (encounters != null) 
		{
			structure.setMessage("Data is available");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounters);
			return new ResponseEntity<ResponseStructure<List<Encounter>>>(structure, HttpStatus.FOUND) ;
		}
		else
		{
			throw new DataNotFound("Data is not available") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) 
	{
		Encounter encounter = dao.deleteEncounter(id) ;
		ResponseStructure<Encounter> structure = new ResponseStructure<>() ;
		if (encounter != null) 
		{
			structure.setMessage("Data is deleted.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id, Encounter encounter) 
	{
		Encounter dbEncounter = dao.getEncounter(id) ;
		ResponseStructure<Encounter> structure = new ResponseStructure<>() ;
		if (dbEncounter != null) 
		{
			structure.setMessage("Data is updated.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEncounter(id, encounter));
			return new ResponseEntity<ResponseStructure<Encounter>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
}
