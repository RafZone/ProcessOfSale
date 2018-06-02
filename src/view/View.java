package view;
import java.util.ArrayList;
import java.util.Scanner;
import model.Item;
import handler.Input;
import controller.Controller;
import java.util.NoSuchElementException;

public class View 
{
	private Controller controller;
	
	public void launch()
	{
		controller = new Controller();
	}
	
	public void printItem(Item item)
	{
		//System.out.println("The following Item has been added to the list");
		System.out.print(item.getName() + "\t");
		System.out.print(item.getIdentifier() + "\t");
		System.out.print(item.getPrice() + "\t");
	}
	
	public void printList(ArrayList list)
	{
		if (list.size()==0)
		{
			System.out.println("list is empty");
		}
		
		else
		{
			System.out.println("Name\t" + "Id\t" + "Price\t" + "Quantity");
			ArrayList copy = new ArrayList();
			Object[] original = list.toArray();
			for (int i = 0; i < list.size();i++)
			{
				Item item = (Item) original[i];
				if (!copy.contains(item))
				{
					printItem(item);
					int j = item.getOccurences(list, item);
					System.out.print(j);
					System.out.println();
					copy.add(item);
				}
			}
			
			System.out.println("-------------------------");
		}
	}
	
	public void printGreeting()
	{
		System.out.println("Welcome To My Store");
	}
	
	public void listIstFull()
	{
		System.out.println("The list is full. Cannot add more Items");
	}
	
	public void printError()
	{
		System.out.println("The information you entered is incorrect. Please try again.");
	}
	
	public void printDBerror()
	{
		System.out.println("Failed to connect to DataBase. Please try again later");
	}
	
	public void printInstructions()
	{
		System.out.println("You can either enter an identifer from the list above");
		System.out.println("Or you can enter an identifier and a quantity seperated by whitespace \' \'");
		System.out.println("You can exit by pressing enter");
	}
	
	public boolean getInput(Input myInput)
	{
		Scanner in = new Scanner(System.in);
		while (true)
		{
			String input = in.nextLine();
			Scanner scan = new Scanner(input).useDelimiter("[^0-9]+");
			if (input.isEmpty())
			{
				return false;
			}
			else
			{
				try
				{
					myInput.setId(scan.nextInt());
					if (scan.hasNextInt())
					{
						int q = scan.nextInt();
						if (q > 0)
							myInput.setQuantity(q);
						else
							myInput.setQuantity(1); //need to change this to an exception because if we insert 0 then 
													//the quantity is changed to 1 and instead we should throw invalid
													//quantity exception
					}
					else
						myInput.setQuantity(1);
					return true;
				}
				
				catch(NoSuchElementException e)
				{
					System.out.println("Please write a number");
				}
			}
		}
	}
	
	public double requestPayment()
	{
		Scanner in = new Scanner (System.in);
		String input = in.nextLine();
		Scanner inputScanner = new Scanner(input).useDelimiter("[^0-9]+");
		double payed = 0.0;
		if (inputScanner.hasNextDouble())
		{
			payed = inputScanner.nextDouble();
			return payed;
		}
		
		return payed;
	}
	
	public void printTotal(double total)
	{
		System.out.println("The total price : " + total);
	}
	
	public void printPaymentInstructions()
	{
		System.out.println("Please enter the amount you want to pay");
	}
	
	public void printPayed()
	{
		System.out.println("The Payment is approved");
	}
	
	public void printNotPayed()
	{
		System.out.println("please insert a valid amount");
	}
	
	public void printPayment(double payed, double total)
	{
		System.out.println("Amount payed : " + payed);
		printTotal(total);
		System.out.println("Change : " + (payed - total));
	}
	
	public static void goodbye()
	{
		System.out.println("Thank you for visiting my store. Please come again");
	}
}
