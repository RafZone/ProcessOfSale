package model;
import java.util.ArrayList;
import view.View;

//<code>Payment</code> calculates the total price of the items in a list
public class Payment 
{
	private double payed;
	private ArrayList listToPayFor;
	private double total = 0.0;
	private View view;
	
	//The price of each item is added in @total
	public Payment (ArrayList listToPayFor)
	{
		view = new View();
		this.listToPayFor = listToPayFor;
		Object[] listArray = listToPayFor.toArray();
		for (int i = 0; i < listArray.length; i++)
		{
			Item item = (Item) listArray[i];
			total = total +item.getPrice();
		}
	}
	
	public double getTotal()
	{
		return total;
	}
	
	//<code>paymentNeeded</code> is for approving the payment and make sure the customer payed the right amount
	//The reason for @sale is for future development and we may need to access more than the customers list in @sale
	public void paymentNeeded(Sale sale)
	{
		view.printTotal(total);
		view.printPaymentInstructions();
		while (true)
		{
			double payed = view.requestPayment();
			if (payed >= total)
			{
				view.printPayed();
				view.printList(sale.getCustomersList());
				view.printPayment(payed, total);
				break;
			}
			view.printNotPayed();
		}
	}
}
