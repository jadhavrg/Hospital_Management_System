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

import com.rj.hospital_management_system.dto.Branch;
import com.rj.hospital_management_system.service.BranchService;
import com.rj.hospital_management_system.util.ResponseStructure;

@RestController
public class BranchController 
{
	@Autowired
	private BranchService service ;
	
	@PostMapping("/Branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestBody Branch branch)
	{
		return service.saveBranch(branch) ;
	}
	
	@GetMapping("/Branch")
	public ResponseEntity<ResponseStructure<Branch>> findBranch(@PathVariable int id)
	{
		return service.findBranch(id) ;
	}
	
	@GetMapping("/findAllBranches")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranches() 
	{
		return service.findAllBranches() ;
	}
	
	@DeleteMapping("/Branch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable int id) 
	{
		return service.deleteBranch(id) ;
	}
	
	@PutMapping("/Branch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@Valid @PathVariable int id,@RequestBody Branch branch)
	{
		return service.updateBranch(id, branch) ;
	}
	
//	@PostMapping("/saveBranchAndAddress")
//	public ResponseEntity<ResponseStructure<Branch>> saveBranchAndAddress(@RequestBody Branch branch) 
//	{
//		return service.saveBranchAndAddress(branch) ;
//	}
	
//	@GetMapping("/BranchByHospital")
//	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospitalId(@PathVariable int hid)
//	{
//		return service.getBranchByHospitalId(hid) ;
//	}
}
