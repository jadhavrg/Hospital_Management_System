package com.rj.hospital_management_system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rj.hospital_management_system.dto.Person;
import com.rj.hospital_management_system.service.PersonService;
import com.rj.hospital_management_system.util.ResponseStructure;

@RestController
public class PersonController 
{
	@Autowired
	private PersonService service ;
	
	@PostMapping("/Person")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person)
	{
		return service.savePerson(person) ;
	}
	
	@GetMapping("/Person")
	public ResponseEntity<ResponseStructure<Person>> findPerson(@Valid @RequestBody int id)
	{
		return service.findPerson(id) ;
	}
	
	@GetMapping("/findAllPersons")
	public ResponseEntity<ResponseStructure<List<Person>>> findAllPersons()
	{
		return service.findAllPersons() ;
	}
	
	@DeleteMapping("/Person")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@Valid @RequestBody int id)
	{
		return service.deletePerson(id) ;
	}
	
	@PutMapping("/Person")
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@Valid @RequestBody int id, @RequestBody Person person)
	{
		return service.updatePerson(id, person) ;
	}
}
