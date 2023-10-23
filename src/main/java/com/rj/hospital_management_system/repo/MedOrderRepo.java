package com.rj.hospital_management_system.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.rj.hospital_management_system.dto.MedOrder;

public interface MedOrderRepo extends JpaRepositoryImplementation<MedOrder, Integer>
{
	
}
