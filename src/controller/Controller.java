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
