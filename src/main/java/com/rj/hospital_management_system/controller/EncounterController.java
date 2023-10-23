package com.rj.hospital_management_system.controller;

import java.util.List;

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

import com.rj.hospital_management_system.dto.Encounter;
import com.rj.hospital_management_system.service.EncounterService;
import com.rj.hospital_management_system.util.ResponseStructure;

@RestController
public class EncounterController 
{
	@Autowired
	private EncounterService service ;
	
	@PostMapping("/Encounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter) 
	{
		return service.saveEncounter(encounter) ;
	}
	
	@GetMapping("/Encounter")
	public ResponseEntity<ResponseStructure<Encounter>> getEncounter( @PathVariable int id) 
	{
		return service.getEncounter(id) ;
	}
	
	@GetMapping("/findAllEncounter")
	public ResponseEntity<ResponseStructure<List<Encounter>>> getALLEncounter() 
	{
		return service.getAllEncounter() ;
	}
	
	@DeleteMapping("/Encounter")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@PathVariable int id) 
	{
		return service.deleteEncounter(id) ;
	}
	
	@PutMapping("/Encounter")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@PathVariable int id, @Valid @RequestBody Encounter encounter) 
	{
		return service.updateEncounter(id, encounter) ;
	}
}
