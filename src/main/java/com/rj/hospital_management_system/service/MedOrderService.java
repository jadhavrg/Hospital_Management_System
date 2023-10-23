package com.rj.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rj.hospital_management_system.dao.MedOrderDao;
import com.rj.hospital_management_system.dto.MedOrder;
import com.rj.hospital_management_system.exception.DataNotFound;
import com.rj.hospital_management_system.exception.IdNotFound;
import com.rj.hospital_management_system.util.ResponseStructure;

@Service
public class MedOrderService 
{
	@Autowired
	private MedOrderDao dao ;
	
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder) 
	{
		ResponseStructure<MedOrder> structure = new ResponseStructure<>() ;
		structure.setMessage("Data is saved successfully.");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(medOrder);
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> findMedOrder(int id) 
	{
		MedOrder medOrder = dao.findMedOrder(id) ;
		ResponseStructure<MedOrder> structure = new ResponseStructure<>() ;
		if (medOrder != null) 
		{
			structure.setMessage("Data is found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<MedOrder>>> findAllMedOrder() 
	{
		List<MedOrder> list = dao.findAllMedOrder() ;
		ResponseStructure<List<MedOrder>> structure = new ResponseStructure<>() ;
		if (list.isEmpty()) 
		{
			throw new DataNotFound("Data is not available") ;
		}
		else
		{
			structure.setMessage("Data is available");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<MedOrder>>>(structure, HttpStatus.FOUND) ;
		}
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int id) 
	{
		MedOrder medOrder = dao.deleteMedOrder(id) ;
		ResponseStructure<MedOrder> structure = new ResponseStructure<>() ;
		if (medOrder != null) 
		{
			structure.setMessage("Data is deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, MedOrder medOrder) 
	{
		MedOrder dbMedOrder = dao.findMedOrder(id) ;
		ResponseStructure<MedOrder> structure = new ResponseStructure<>() ;
		if (dbMedOrder != null) 
		{
			structure.setMessage("Data is updated.");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateMedOrder(id, medOrder));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK) ;
		}
		else
		{
			throw new IdNotFound("Id not found") ;
		}
	}
}
