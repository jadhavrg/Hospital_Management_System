package com.rj.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rj.hospital_management_system.dao.PersonDao;
import com.rj.hospital_management_system.dto.Person;
import com.rj.hospital_management_system.exception.DataNotFound;
import com.rj.hospital_management_system.exception.IdNotFound;
import com.rj.hospital_management_system.util.ResponseStructure;

@Service
public class PersonService 
{
	@Autowired
	private PersonDao dao ;
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) 
	{
		ResponseStructure<Person> structure = new ResponseStructure<>() ;
		structure.setMessage("Data is saved successfully..!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Person>> findPerson(int id) 
	{
		Person person = dao.findPerson(id) ;
		ResponseStructure<Person> structure = new ResponseStructure<>() ;
		if (person != null)
		{
			structure.setMessage("Data is found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Person>>> findAllPersons() 
	{
		List<Person> list = dao.findAllPersons() ;
		ResponseStructure<List<Person>> structure = new ResponseStructure<>() ;
		if (list.isEmpty()) 
		{
			throw new DataNotFound("Data is not avialable") ;
		}
		else
		{
			structure.setMessage("Data is available");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND) ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) 
	{
		Person person = dao.deletePerson(id) ;
		ResponseStructure<Person> structure = new ResponseStructure<>() ;
		if (person != null)
		{
			structure.setMessage("Data is deleted..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id, Person person) 
	{
		Person dbPerson = dao.findPerson(id) ;
		ResponseStructure<Person> structure = new ResponseStructure<>() ;
		if (dbPerson != null) 
		{
			structure.setMessage("Data is updated.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updatePerson(id, person));
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
}
