package com.rj.hospital_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.rj.hospital_management_system.dto.Branch;

public interface BranchRepo extends JpaRepositoryImplementation<Branch, Integer> 
{
//	@Query("select b from Branch where b.hospital=?1")
//	List<Branch> findBranchesByHospitalId(int hid) ;
}
