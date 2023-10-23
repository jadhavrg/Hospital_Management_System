package com.rj.hospital_management_system.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.rj.hospital_management_system.dto.MedItem;

public interface MedItemRepo extends JpaRepositoryImplementation<MedItem, Integer> 
{

}
