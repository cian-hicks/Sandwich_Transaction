package edu.albany.person;

public abstract class Employee extends Person{

	private int ID;
	protected static int count;
	
	public int getCount()
	{
		return count;
	}
	
	public static void setCount(int count)
	{
		Employee.count = count;
	}
	
	public int getID()
	{
		return this.ID;
	}
	
	public void setID(int new_ID)
	{
		this.ID = new_ID;
	}
	
	public abstract String toString();
}
