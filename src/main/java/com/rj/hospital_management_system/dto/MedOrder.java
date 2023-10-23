package com.rj.hospital_management_system.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class MedOrder 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private Date date ;
	@NotNull(message = "Doctor name can't be null")
	@NotBlank(message = "Doctor name can't be blank")
	private String doctor ;
	@ManyToOne
	private Encounter encounter ;
}
