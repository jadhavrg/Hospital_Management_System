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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rj.hospital_management_system.dto.MedItem;
import com.rj.hospital_management_system.service.MedItemService;
import com.rj.hospital_management_system.util.ResponseStructure;

@RestController
public class MedItemController 
{
	@Autowired
	private MedItemService service ;
	
	@PostMapping("/MedItem")
	public ResponseEntity<ResponseStructure<MedItem>> saveMedItem(@RequestBody @Valid MedItem medItem) 
	{
		return service.saveMedItem(medItem) ;
	}
	
	@GetMapping("/MedItem")
	public ResponseEntity<ResponseStructure<MedItem>> findMedItem(@RequestParam int id) 
	{
		return service.findMedItem(id) ;
	}
	
	@GetMapping("/findAllMedItems")
	public ResponseEntity<ResponseStructure<List<MedItem>>> findAllMedItem() 
	{
		return service.findAllMedItem() ;
	}
	
	@DeleteMapping("/MedItem")
	public ResponseEntity<ResponseStructure<MedItem>> deleteMedItem(@PathVariable int id) 
	{
		return service.deleteMedItem(id) ;
	}
	
	@PutMapping("/MedItem")
	public ResponseEntity<ResponseStructure<MedItem>> updateMedItem(@PathVariable int id, @RequestBody @Valid MedItem item) 
	{
		return service.updateMedItem(id, item) ;
	}
}
