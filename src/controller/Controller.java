package controller;
import externalConnections.*;
import model.Sale;
import model.Payment;
import view.*;

public class Controller 
{
	private static ItemsInStore itemsInStore;
	private static DisplayGrabber displayGrabber;
	private TotalRevenueView display;
	private Payment payment;
	
	//This is the <code>Controller</code> constructor which create a connection to the database and then starts a sale
	//@displayGrabber is the publisher responsible for updating the display and @display is the observer to be updated
	public Controller()
	{
		itemsInStore = new ItemsInStore();
		displayGrabber = new DisplayGrabber();
		display = new TotalRevenueView(displayGrabber);
		Sale sale = new Sale();
		sale.addItems();
		if (!sale.getCustomersList().isEmpty())
		{
			payment = new Payment(sale.getCustomersList());
			payment.paymentNeeded(sale);
		}
		View.goodbye();
	}
	
	public static ItemsInStore getItemsInStore()
	{
		return itemsInStore;
	}
	
	public static DisplayGrabber getDisplayGrabber()
	{
		return displayGrabber;
	}
}
