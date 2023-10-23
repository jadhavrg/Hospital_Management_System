package com.rj.hospital_management_system.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Branch
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@NotBlank(message = "Name can't be blank")
	@NotNull(message = "Name can't be null")
	private String name ;
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l) 
	private long phone ;
	@NotBlank(message = "Manager name can't be blank")
	@NotNull(message = "Manager name can't be null")
	private String manager ;
	@ManyToOne(cascade = CascadeType.ALL)
	private Hospital hospital ;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address ;
}
