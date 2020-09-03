package edu.albany.person;
import edu.albany.order.Transaction;

public class Cashier extends Employee{
	
	private double RegisterAmount;

	public Cashier(String new_FirstName, String new_LastName, double new_RegisterAmount)
	{
		//super(new_FirstName, new_LastName, new_ID);
		this.setID(count);
		this.setFirstName(new_FirstName);
		this.setLastName(new_LastName);
		this.setRegisterAmount(new_RegisterAmount);
	}
	
	public double getRegisterAmount()
	{
		return RegisterAmount;
	}

	private void setRegisterAmount(double new_RegisterAmount) 
	{
		this.RegisterAmount = new_RegisterAmount;
	}
	
	public String toString() 
	{
		return this.getFirstName() + " " + this.getLastName() + " "
				+ this.getID() + " has " + this.getRegisterAmount()
				+ " in their register.";
	}
	
	public void Collect(double TransactionTotal)
	{
		this.RegisterAmount += TransactionTotal;
	}
	
	public void Collection(Customer customer, Cashier cashier, Transaction Test)
	{
		double TransactionTotal = Test.getPrice() + Test.getTax();
		customer.Pay(TransactionTotal);
		cashier.Collect(TransactionTotal);
	}

}
