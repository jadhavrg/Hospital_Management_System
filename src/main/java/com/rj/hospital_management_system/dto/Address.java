package com.rj.hospital_management_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@NotBlank(message="city name can't be blank")
	@NotNull(message = "city name can't be null")
	private String city ;
	@NotBlank(message="state name can't be blank")
	@NotNull(message = "state name can't be null")
	private String state ;
	@Min(value = 100000)
	@Max(value = 999999)
//	@Pattern(regexp = "[5][0-9]{6}")
	private int pincode ;
}
