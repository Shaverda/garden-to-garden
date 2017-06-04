package com.garden2garden.events;

/**
 * POJO mapped from a Create Account request
 */
public class CreateAccountRequest
{
	private String name;
	private String Email;
	private String location; //TODO This will change

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return Email;
	}

	public void setEmail(String email)
	{
		Email = email;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}
}
