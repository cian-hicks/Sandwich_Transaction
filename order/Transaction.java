package edu.albany.order;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import edu.albany.person.Customer;
import edu.albany.person.Cashier;
import edu.albany.person.SandwichMaker;
import edu.albany.order.Menu.Sandwiches;;

public class Transaction {
	
	private static int OrderNumber = 0;
	private Sandwiches[] Order;

	public Sandwiches[] getOrder() {
		return Order;
	}

	public void setOrder(Sandwiches[] order) {
		this.Order = order;
	}
	
	public static int getOrder_number() {
		return OrderNumber;
	}

	public static void setOrder_number(int order_number) {
		Transaction.OrderNumber = order_number;
	}
	

	public double getPrice() {
		
		final DecimalFormat df = new DecimalFormat("#.##");

		double count = 0;
		for(Sandwiches A : this.getOrder()) {
			count += A.getPrice();
		}

		return Double.parseDouble(df.format(count));
	}

	public double getTax() {
		
		final DecimalFormat df = new DecimalFormat("#.##");

		double count = 0;
		for(Sandwiches s : this.getOrder()) {
			count += s.getPrice();
		}
		

		count = (count * 0.08);
		return Double.parseDouble(df.format(count));
	}

	public Transaction(Sandwiches[] new_order){
		this.Order = new_order;
		OrderNumber++;
	}
	

	public void printReceipt(Customer customer, Cashier cashier, SandwichMaker cook) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		System.out.println("-------------------------------");
		System.out.println("Receipt (Order # " + Transaction.getOrder_number() + "): ");
		System.out.println("-------------------------------");
		System.out.println(String.format("%-25s%s" , "Type", "Price"));
		System.out.println("-------------------------------");
		
		for(Sandwiches A : this.getOrder()) {
			System.out.println(A.toString());
		}
		
		System.out.println("-------------------------------");
		System.out.println(String.format("%-25s%s" , "Tax", formatter.format(this.getTax())));
		System.out.println(String.format("%-25s%s" , "Total", formatter.format(this.getPrice()+this.getTax())));
		System.out.println("-------------------------------");
		System.out.println("You are being served today by, ");
		System.out.println(String.format("%15s, cashier, id " + cashier.getID(), cashier.getFirstName()));
		System.out.println(String.format("%15s, cook, id " + cook.getID(), cook.getFirstName()));
		System.out.println("-------------------------------");
	}
}

