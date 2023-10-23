package com.rj.hospital_management_system.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hospital 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@NotNull(message = "Name can't be null")
	@NotBlank(message = "Name can't be blank")
	private String name ;
	@NotBlank(message = "Email can't be blank")
	@NotNull(message = "Email can't be null")
	@Email(regexp = "[a-z0-9#$&.]+@[a-z0-9]+\\.[a-z]{2,3}")
	@Column(unique = true)
	private String email ;
	@NotNull(message = "gst can't be null")
	@NotBlank(message = "gst can't be blank")
	private String gst ;
}
