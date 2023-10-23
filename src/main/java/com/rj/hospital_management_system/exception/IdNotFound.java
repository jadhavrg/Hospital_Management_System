package com.rj.hospital_management_system.exception;


public class IdNotFound extends RuntimeException
{
	String message ;
	
	@Override
	public String getMessage()
	{
		return message ;
	}
	
	public IdNotFound(String message) 
	{
		super();
		this.message = message;
	}
	
	
}
