package handler;

public class Input 
{
	int id;
	int quantity;
	
	//<code>Input</code> is a very simple object to get the user input from view interface
	public Input()
	{
		id = 0;
		quantity = 0;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
}
