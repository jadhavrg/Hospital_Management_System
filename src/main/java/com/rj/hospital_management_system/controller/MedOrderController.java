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

import com.rj.hospital_management_system.dto.MedOrder;
import com.rj.hospital_management_system.service.MedOrderService;
import com.rj.hospital_management_system.util.ResponseStructure;

@RestController
public class MedOrderController 
{
	@Autowired
	private MedOrderService service ;
	
	@PostMapping("/MedOrder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody @Valid MedOrder medOrder) 
	{
		return service.saveMedOrder(medOrder) ;
	}
	
	@GetMapping("/MedOrder")
	public ResponseEntity<ResponseStructure<MedOrder>> findMedOrder(@PathVariable int id) 
	{
		return service.findMedOrder(id) ;
	}
	
	@GetMapping("/findAllMedOrders")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> findAllMedOrder() 
	{
		return service.findAllMedOrder() ;
	}
	
	@DeleteMapping("/MedOrder")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@PathVariable int id) 
	{
		return service.deleteMedOrder(id) ;
	}
	
	@PutMapping("/MedOrder")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@PathVariable int id,@RequestBody @Valid MedOrder medOrder) 
	{
		return service.updateMedOrder(id, medOrder) ;
	}
}
