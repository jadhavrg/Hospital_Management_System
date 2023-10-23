package com.rj.hospital_management_system.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.hospital_management_system.dto.Hospital;
import com.rj.hospital_management_system.repo.HospitalRepo;

@Repository
public class HospitalDao 
{
	@Autowired
	private HospitalRepo repo ;
	
	public Hospital saveHospital(Hospital hospital)
	{
		return repo.save(hospital) ;
	}
	
	public Hospital findHospital(int id)
	{
		Optional<Hospital> optional = repo.findById(id) ;
		if (optional.isPresent())
		{
			return optional.get() ;
		}
		return null ;
	}
	
	public Hospital deleteHospital(int id)
	{
		Optional<Hospital> optional = repo.findById(id) ;
		if (optional.isEmpty())
		{
			return null ;
		}
		repo.deleteById(id); 
		return optional.get() ;
	}
	
	public Hospital updateHospital(int id, Hospital hospital)
	{
		Optional<Hospital> optional = repo.findById(id) ;
		if (optional.isPresent())
		{
			hospital.setId(id);
			return repo.save(hospital) ;
		}
		return null ;
	}
}
