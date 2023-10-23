package com.rj.hospital_management_system.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Encounter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@NotNull(message = "Reason can't be null")
	@NotBlank(message = "Reason can't be blank")
	private String reason ;
	@NotNull(message = "Cost can't be null")
	@NotBlank(message = "Cost can't be blank")
	private long cost ;
	@OneToOne
	private Person person ;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Branch> branchs ;
}
