package com.rj.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rj.hospital_management_system.dao.MedItemDao;
import com.rj.hospital_management_system.dto.MedItem;
import com.rj.hospital_management_system.exception.DataNotFound;
import com.rj.hospital_management_system.exception.IdNotFound;
import com.rj.hospital_management_system.util.ResponseStructure;

@Service
public class MedItemService 
{
	@Autowired
	private MedItemDao dao ;
	
	public ResponseEntity<ResponseStructure<MedItem>> saveMedItem(MedItem medItem) 
	{
		ResponseStructure<MedItem> structure = new ResponseStructure<>() ;
		structure.setMessage("Data is saved Successfully.");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(medItem);
		return new ResponseEntity<ResponseStructure<MedItem>>(structure,HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<MedItem>> findMedItem(int id) 
	{
		MedItem item = dao.findMedItem(id) ;
		ResponseStructure<MedItem> structure = new ResponseStructure<>() ;
		if (item != null) 
		{
			structure.setMessage("Data is found.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(item);
			return new ResponseEntity<ResponseStructure<MedItem>>(structure,HttpStatus.FOUND) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<MedItem>>> findAllMedItem() 
	{
		List<MedItem> items = dao.findAllMedItems() ;
		ResponseStructure<List<MedItem>> structure = new ResponseStructure<>() ;
		if (items.isEmpty()) 
		{
			throw new DataNotFound("Data is not available") ;
		}
		else
		{
			structure.setMessage("Data is available.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(items);
			return new ResponseEntity<ResponseStructure<List<MedItem>>>(structure, HttpStatus.FOUND) ;
		}
	}
	
	public ResponseEntity<ResponseStructure<MedItem>> deleteMedItem(int id) 
	{
		MedItem item = dao.deleteMedItem(id) ;
		ResponseStructure<MedItem> structure = new ResponseStructure<>() ;
		if (item != null) 
		{
			structure.setMessage("Data is deleted.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(item);
			return new ResponseEntity<ResponseStructure<MedItem>>(structure,HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<MedItem>> updateMedItem(int id, MedItem item) 
	{
		MedItem dbItem = dao.findMedItem(id) ;
		ResponseStructure<MedItem> structure = new ResponseStructure<>() ;
		if (dbItem != null) 
		{
			structure.setMessage("Data is updated.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateMedItem(id, item));
			return new ResponseEntity<ResponseStructure<MedItem>>(structure,HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
}
