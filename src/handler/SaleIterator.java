package handler;
import view.*;
import model.Sale;
import externalConnections.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import model.Item;
import handler.exceptions.*;

public class SaleIterator 
{
	private ItemsInStore itemsInStore;
	private ArrayList customersList;
	private int maxNumOfItems;
	private View view;
	private DisplayGrabber displayGrabber;
	
	public SaleIterator(Sale sale)
	{
		this.itemsInStore = sale.getItemsInStore();
		this.customersList = sale.getCustomersList();
		this.maxNumOfItems = sale.getMaxNumOfItems();
		this.displayGrabber = sale.getDisplayGrabber();
		view = new View();
		view.printGreeting();
		view.printList(itemsInStore.getList());
		getItems();
	}
	
	private void getItems()
	{
		view.printInstructions();
		Input userInput = new Input();
		try 
		{
			while(view.getInput(userInput) && customersList.size() <= maxNumOfItems && !itemsInStore.getList().isEmpty())
			{
				//System.out.println(userInput.getId()+" "+userInput.getQuantity());
				buy(userInput.getId(),userInput.getQuantity());
				
			}
			if (customersList.size() >= maxNumOfItems)
			{
				throw new UserListIsFullException(view, customersList);
			}
			
			if (itemsInStore.getList().isEmpty())
			{
				throw new DbFailureException(view);
			}
		}
		
		catch(NoSuchElementException e)
		{
			//This message is for the user only. It includes instructions on how to use the program.
			view.printError();
		}
		
		catch(UserListIsFullException fullList)
		{
			//This exception has comments in the relative class
			view.printError();
		}
		
		catch(DbFailureException dbFailed)
		{
			//This exception has comments in the relative class
			view.printError();
		}
		
	}
	
	private void buy(int identifier, int quantity)
	{
		Boolean valid = null;
		
		try
		{
			valid = itemsInStore.validate(identifier, quantity);
			if (valid == null)
			{
				throw new DbFailureException(view);
			}
		}
		
		catch(DbFailureException dbFail)
		{
			//This exception has comments in the relative class
			return;
		}
		for (int i = 0; i < quantity && valid; i++)
		{
			Item newItem = itemsInStore.getItem(identifier);
			customersList.add(newItem);
			view.printItem(newItem);
			itemsInStore.delete(newItem);
			displayGrabber.addNewPrice(newItem.getPrice());
		}
		if (!valid)
		{
			view.printError();
		}
	}
	
}
