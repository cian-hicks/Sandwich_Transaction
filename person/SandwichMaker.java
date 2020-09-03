package edu.albany.person;
import edu.albany.order.Menu.Sandwiches;
import edu.albany.order.Transaction;

public class SandwichMaker extends Employee{
	
	private Transaction CurrentTransaction;

	public SandwichMaker(String new_FirstName, String new_LastName, Transaction CurrentOrder) 
	{
		//super(new_FirstName, new_LastName, new_ID);
		this.setID(count);
		this.setFirstName(new_FirstName);
		this.setLastName(new_LastName);
		this.setCurrentTransaction(CurrentOrder);
	}
	
	public Transaction getCurrentTransaction()
	{
		return CurrentTransaction;
	}
	
	public void setCurrentTransaction(Transaction CurrentTransaction)
	{
		this.CurrentTransaction = CurrentTransaction;
	}
	
	public void FinishedOrder()
	{
		if(this.getCurrentTransaction().getOrder() != null)
		{
			System.out.println("\n\t\"Starting order " + Transaction.getOrder_number() + "!\"\n");
			for(Sandwiches A : this.CurrentTransaction.getOrder())
			{
				System.out.println("\t" + A.getName() + " ...done.");
			}
				System.out.println("\n\t\"Order up!\"");
			} else {
				System.out.println("\n\t\"No current orders!\"");
			}
		}
	public String toString() 
	{
		return this.getFirstName();
	}

	public void completeOrder() {
		System.out.println("Order Complete.");
	}
	
}
