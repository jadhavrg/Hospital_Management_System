package com.rj.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.hospital_management_system.dto.Person;
import com.rj.hospital_management_system.repo.PersonRepo;

@Repository
public class PersonDao 
{
	@Autowired
	private PersonRepo repo ;
	
	public Person savePerson(Person person) 
	{
		return repo.save(person) ;
	}
	
	public Person findPerson(int id) 
	{
		Optional<Person> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			return optional.get() ;
		}
		return null ;
	}
	
	public List<Person> findAllPersons() 
	{
		return repo.findAll() ;
	}
	
	public Person deletePerson(int id) 
	{
	 Optional<Person> optional = repo.findById(id) ;
	 if (optional.isEmpty()) 
	 {
		 return null ;
	 }
	 repo.deleteById(id);
	 return optional.get() ;
	}
	
	public Person updatePerson(int id, Person person) 
	{
		Optional<Person> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			person.setId(id);
			return repo.save(person) ;
		}
		return null ;
	}
}
