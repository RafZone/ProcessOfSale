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
	
	public void addItems()
	{
		SaleIterator saleIterator = new SaleIterator(this);
	}
}
