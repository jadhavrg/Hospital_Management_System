package com.rj.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.rj.hospital_management_system.dto.Branch;
import com.rj.hospital_management_system.dto.Hospital;
import com.rj.hospital_management_system.repo.BranchRepo;
import com.rj.hospital_management_system.util.ResponseStructure;

@Repository
public class BranchDao 
{
	@Autowired
	private BranchRepo repo ;
	
	public Branch saveBranch(Branch branch)
	{
		return repo.save(branch) ;
	}
	
	public Branch findBranch(int id)
	{
		Optional<Branch> optional = repo.findById(id) ;
		if (optional.isPresent())
		{
			return optional.get() ;
		}
		return null ;
	}
	
	public List<Branch> findAllBranches() 
	{
		return repo.findAll() ;
	}
	
	public Branch deleteBranch(int id) 
	{
		Optional<Branch> optional = repo.findById(id) ;
		if (optional.isEmpty()) 
		{
			return null ;
		}
		repo.deleteById(id);
		return optional.get() ;
	}
	
	public Branch updateBranch(int id, Branch branch)
	{
		Optional<Branch> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			branch.setId(id);
			return repo.save(branch) ;
		}
		return null ;
	}
	
//	public List<Branch> findBranchesByHospitalId(int hid) 
//	{
//		return repo.findBranchesByHospitalId(hid) ;
//	}
	
}
