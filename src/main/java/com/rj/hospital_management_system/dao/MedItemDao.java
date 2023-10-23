package com.rj.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.hospital_management_system.dto.MedItem;
import com.rj.hospital_management_system.repo.MedItemRepo;

@Repository
public class MedItemDao 
{
	@Autowired
	private MedItemRepo repo ;
	
	public MedItem saveMedItem(MedItem medItem) 
	{
		return repo.save(medItem) ;
	}
	
	public MedItem findMedItem(int id) 
	{
		Optional<MedItem> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			return optional.get() ;
		}
		return null ;
	}
	
	public List<MedItem> findAllMedItems()
	{
		return repo.findAll() ;
	}
	
	public MedItem deleteMedItem(int id) 
	{
		Optional<MedItem> optional =repo.findById(id) ;
		if (optional.isPresent()) 
		{
			repo.deleteById(id);
			return optional.get() ;
		}
		return null ;
	}
	
	public MedItem updateMedItem(int id, MedItem medItem) 
	{
		Optional<MedItem> optional =repo.findById(id) ;
		if (optional.isPresent()) 
		{
			medItem.setId(id);
			return repo.save(medItem) ;
		}
		return null ;
	}
}
