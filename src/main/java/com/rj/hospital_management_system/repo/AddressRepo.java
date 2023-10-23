package com.rj.hospital_management_system.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.rj.hospital_management_system.dto.Address;

public interface AddressRepo extends JpaRepositoryImplementation<Address, Integer>
{
	

}
