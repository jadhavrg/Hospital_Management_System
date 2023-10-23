package com.rj.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.hospital_management_system.dto.Encounter;
import com.rj.hospital_management_system.repo.EncounterRepo;

@Repository
public class EncounterDao
{
	@Autowired
	private EncounterRepo repo ;
	
	public Encounter saveEncounter(Encounter encounter) 
	{
		return repo.save(encounter) ;
	}
	
	public Encounter getEncounter(int id) 
	{
		Optional<Encounter> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			return optional.get() ;
		}
		return null ;
	}
	
	public List<Encounter> getAllEncounter() 
	{
		return repo.findAll() ;
	}
	
	public Encounter deleteEncounter(int id) 
	{
		Optional<Encounter> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			repo.deleteById(id);
			return optional.get() ;
		}
		return null ;
	}
	
	public Encounter updateEncounter(int id, Encounter encounter) 
	{
		Optional<Encounter> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			encounter.setId(id);
			return repo.save(encounter);
		}
		return null ;
	}
}
