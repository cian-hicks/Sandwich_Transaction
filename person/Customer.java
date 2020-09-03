package edu.albany.person;

public class Customer extends Person{

	private double Money;
	
	public Customer(String new_FirstName, String new_LastName, double new_Money)
	{
		this.setFirstName(new_FirstName);
		this.setLastName(new_LastName);
		this.setMoney(new_Money);
		
	}
	public double getMoney()
	{
		return Money;
	}
	
	public void setMoney(double Money)
	{
		this.Money = Money;
	}
	
	public String toString() 
	{
		return this.getFirstName() + " " + this.getLastName() + " has " 
				+ this.getMoney() + " in their wallet.";
	}
	
	public void Pay(double TransactionTotal)
	{
		if((this.Money -= TransactionTotal) > 0) this.Money -= TransactionTotal;
		else throw new IllegalArgumentException("\"Sorry, I don't have enough\".");	
	}
}
