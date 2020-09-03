package edu.albany.person;

public abstract class Person {

	private String FirstName;
	private String LastName;
	

	public String getFirstName()
	{
		return this.FirstName;
	}
	
	public String getLastName()
	{
		return this.LastName;
	}
	
	public void setFirstName(String new_FirstName)
	{
		this.FirstName = new_FirstName;
	}
	
	public void setLastName(String new_LastName)
	{
		this.LastName = new_LastName;
	}
	
	public String toString()
	{
		return this.getFirstName() + " " + this.getLastName();
	}
}
