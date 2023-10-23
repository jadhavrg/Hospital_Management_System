package com.rj.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rj.hospital_management_system.dao.BranchDao;
import com.rj.hospital_management_system.dao.HospitalDao;
import com.rj.hospital_management_system.dto.Branch;
import com.rj.hospital_management_system.dto.Hospital;
import com.rj.hospital_management_system.exception.DataNotFound;
import com.rj.hospital_management_system.exception.IdNotFound;
import com.rj.hospital_management_system.util.ResponseStructure;

@Service
public class BranchService
{
	@Autowired
	private BranchDao dao ;
//	@Autowired
//	private HospitalDao dao2 ;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch)
	{
		ResponseStructure<Branch> structure = new ResponseStructure<>() ;
		structure.setMessage("Data is saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Branch>> findBranch(int id)
	{
		Branch branch = dao.findBranch(id) ;
		ResponseStructure<Branch> structure = new ResponseStructure<>() ;
		if (branch != null)
		{
			structure.setMessage("Data is found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.FOUND) ;
		}
		else
		{
			throw new IdNotFound("Id Not Found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranches() 
	{
		List<Branch> branchs = dao.findAllBranches() ;
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>() ;
		if (branchs.isEmpty()) 
		{
			throw new DataNotFound("Data is not available") ;
		}
		else
		{
			structure.setMessage("Data is available");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branchs);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.FOUND) ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id)
	{
		Branch branch = dao.deleteBranch(id) ;
		ResponseStructure<Branch> structure = new ResponseStructure<>() ;
		if (branch != null)
		{
			structure.setMessage("Branch is deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK) ;
		}
		else {
			throw new IdNotFound("Id Not Found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch branch)
	{
		Branch dbBranch = dao.findBranch(id) ;
		ResponseStructure<Branch> structure = new ResponseStructure<>() ;
		if (dbBranch == null)
		{
			throw new IdNotFound("Id Not Found") ;
		}
		else
		{
			structure.setMessage("Update successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateBranch(id, branch));
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK) ;
		}
	}
	
//	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospitalId(int hid) 
//	{
//		ResponseStructure<List<Branch>> structure = new ResponseStructure<>() ;
//		structure.setMessage("Data found successfuly");
//		structure.setStatus(HttpStatus.FOUND.value());
//		structure.setData(dao.findBranchesByHospitalId(hid));
//		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.FOUND) ;
//	}
}
