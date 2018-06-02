package model;
import java.util.ArrayList;
import view.View;

public class Payment 
{
	private double payed;
	private ArrayList listToPayFor;
	private double total = 0.0;
	private View view;
	
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
