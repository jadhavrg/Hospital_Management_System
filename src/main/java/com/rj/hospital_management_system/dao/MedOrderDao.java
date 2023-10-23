package com.rj.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rj.hospital_management_system.dto.MedOrder;
import com.rj.hospital_management_system.repo.MedOrderRepo;

@Repository
public class MedOrderDao 
{
	@Autowired
	private MedOrderRepo repo ;
	
	public MedOrder saveMedOrder(MedOrder medOrder) 
	{
		return repo.save(medOrder) ;
	}
	
	public MedOrder findMedOrder(int id) 
	{
		Optional<MedOrder> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			return optional.get() ;
		}
		return null ;
	}
	
	public List<MedOrder> findAllMedOrder() 
	{
		return repo.findAll() ;
	}
	
	public MedOrder deleteMedOrder(int id) 
	{
		Optional<MedOrder> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			repo.deleteById(id);
			return optional.get() ;
		}
		return null ;
	}
	
	public MedOrder updateMedOrder(int id, MedOrder medOrder) 
	{
		Optional<MedOrder> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			medOrder.setId(id);
			return repo.save(medOrder) ;
		}
		return null ;
	}
}
