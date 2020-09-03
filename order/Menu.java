package edu.albany.order;

public class Menu {
	
	public enum Sandwiches
	{
		CHICKEN("Buffalo Chicken Sandwich", 3.50),
		CHEESESTEAK("Philly Cheese Steak", 5.50),
		MEATBALL("Meatball Sub", 4.99);
		
	
	
	private String Name;
	private double Price;
	private static int S = 3;
	//# of sandwiches
	
	Sandwiches(String new_Name, double new_Price)
	{
		this.Name = new_Name;
		this.Price = new_Price;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public double getPrice()
	{
		return Price;
	}
	
	public static int getS()
	{
		return S;
	}
	
	public String toString()
	{
		return String.format("%-25s$%s", this.getName(), this.getPrice());
	}
	
	public static void printMenu()
	{
		System.out.println("               Menu            ");
		System.out.println("-------------------------------");
		System.out.println(String.format("%-255s%s", "Type", "Price"));
		System.out.println("-------------------------------");
		for(Sandwiches A: Sandwiches.values()) 
		{
			System.out.println(A);
		}
		System.out.println("-------------------------------");
	}
}

}
