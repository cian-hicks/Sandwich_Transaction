package edu.albany.order;
import java.text.NumberFormat;
import java.util.Random;

import edu.albany.person.Customer;
import edu.albany.person.Cashier;
import edu.albany.person.SandwichMaker;
import edu.albany.order.Menu.Sandwiches;
import edu.albany.order.Transaction;


public class OrderTest {
	
	public static void main(String[]args) {
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	Customer customer = new Customer("Billy", "Smith", 35.22); 
	Cashier cashier = new Cashier("Shane", "Atwood", 370.35); 
	SandwichMaker cook = new SandwichMaker("Shelly", "Brook", null);
			
	Menu.Sandwiches.printMenu();
	
	System.out.println("\n\t\"Hello, what are you having?\"");
	
	
	Random rand = new Random();
	int num_sandwiches = rand.nextInt(Sandwiches.getS()) + 1;
	int temp;
	Sandwiches[] sandwiches_ordered = new Sandwiches[num_sandwiches]; 
	

	for(int i = 0; i < num_sandwiches; i++) 
	{
		temp = rand.nextInt(Sandwiches.getS())+1;
		switch (temp) 
		{
        		case 1:  sandwiches_ordered[i] = Sandwiches.CHICKEN;
            		break;
            case 2:  sandwiches_ordered[i] = Sandwiches.CHEESESTEAK;
                break;
            case 3:  sandwiches_ordered[i] = Sandwiches.MEATBALL;
                break;		
		}
	}
	
	
	System.out.print("\n\t\"I would like a...");
	for(Sandwiches A: sandwiches_ordered) 
		{
		System.out.print("\n\t " + A.getName());
		} System.out.println("\"");
	Transaction test_transaction = new Transaction(sandwiches_ordered);

	
	//NumberFormat formatter = null;
	System.out.println("\n\t\"Sure, that will be " + 
	formatter.format(test_transaction.getPrice() + test_transaction.getTax()) +
	" including tax"+ ".\"");
	
	try {
		cashier.Collection(customer, cashier, test_transaction);
		
	} catch(Exception e) 
	{
		System.out.println("\n\t" + e.getLocalizedMessage());
		System.out.println("\nDenied.");
		return;
	}
	
	System.out.println("\n\t\"Here you are.\"");
	System.out.println("\nApproved.");
	System.out.println("\n\t\"Have a nice day, here is your receipt.");
	
	test_transaction.printReceipt(customer, cashier, cook);
	
	cook.setCurrentTransaction(test_transaction);
	
	cook.completeOrder();
}
}
