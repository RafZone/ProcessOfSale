package model;
import handler.SaleIterator;
import java.util.ArrayList;
import controller.Controller;
import externalConnections.*;

public class Sale 
{
	private int maxNumOfItems = 10;
	private ArrayList customersList;
	private ItemsInStore itemsInStore;
	private DisplayGrabber displayGrabber;
	
	
	//<code>Sale</Sale> create an ArrayList for the customer and his items. At this moment, the customer
	//is allowed to purchase only 10 items which is @maxNumOfItems.(rules of the store)
	public Sale()
	{
		customersList = new ArrayList(maxNumOfItems);
		itemsInStore = Controller.getItemsInStore();
		displayGrabber = Controller.getDisplayGrabber();
		
	}
	
	public ArrayList getCustomersList()
	{
		return customersList;
	}
	
	public int getMaxNumOfItems()
	{
		return maxNumOfItems;
	}
	
	public ItemsInStore getItemsInStore()
	{
		return itemsInStore;
	}
	
	public DisplayGrabber getDisplayGrabber()
	{
		return displayGrabber;
	}
	
	
	//<code>addItems</code> this will create the <code>SaleIterator</code> object and the user will be able to add
	// items to the customers list.
	public void addItems()
	{
		SaleIterator saleIterator = new SaleIterator(this);
	}
}
