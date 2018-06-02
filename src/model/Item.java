package model;
import java.util.ArrayList;
import java.util.Objects;

/**<code>Item<code/> is a class with a constructor that takes three pparameters
 * @id is an int type representing the identifier of the item
 * @price is an int type representing the price, it could be converted to double
 * for more accurecy
 * @name is a String type used to store the name of the item
 * @item is Item type and is used to create a copy of this item 
**/
public class Item 
{
	private int identifier;
	private int price;
	private String name;
	
	public Item (int id, int price , String name)
	{
		this.identifier = id;
		this.name = name;
		this.price = price;
	}
	
	//This method will return the identifier of the item
	public int getIdentifier()
	{
		return identifier;
	}
	
	//This method will return the price of the item
	public int getPrice()
	{
		return price;
	}
	
	//This method will return the name of the item
	public String getName()
	{
		return name;
	}
	
	//This method compares two objects of the type Item and returns a boolean as a result
	@Override 
	public boolean equals(Object object)
	{
	    if(this == object)
	    {
	        return true;
	    }

	    if(object == null || getClass() != object.getClass())
	    {
	        return false;
	    }

	    Item item = (Item) object;

	    return Objects.equals(this.name, item.name) &&
	         this.identifier == item.identifier &&
	         this.price == item.price;
	}
	
	//This will create a copy of the type item having the same fields as the @item sent as a parameter 
	public Item (Item item)
	{
		identifier = item.getIdentifier();
		price = item.getPrice();
		name = item.getName();
		
	}
	
	/**<code>getOccurrences<code/> takes any @list of type ArrayList and any Object
	to check if this @o is in the @list **/
	public static int getOccurences(ArrayList <Item>list, Object o)
	{
		if (list.contains(o) == false)
			return 0;
		else
		{
			int occurences = 0;
			Object [] items = list.toArray();
			for (int i = 0; i < items.length; i++)
			{
				if (items[i].equals(o))
				{
					occurences++;
				}
			}
			return occurences;
		}
	}
}