package externalConnections;
import java.util.ArrayList;
import model.Item;

public class ItemsInStore 
{
	int numOfItemsInStore = 50;
	private ArrayList list;
	
	public ItemsInStore()
	{
		list = new ArrayList(numOfItemsInStore);
		Item item1 = new Item (111, 50, "Item1");
		list.add(item1);
		Item item2 = new Item (222, 99, "Item2");
		list.add(item2);
		Item item3 = new Item (333, 20, "Item3");
		list.add(item3);
		Item item4 = new Item (444, 199, "Item4");
		list.add(item4);
		Item item5 = new Item (555, 14, "Item5");
		list.add(item5);
		Item item6 = new Item (666, 40, "Item6");
		list.add(item6);
		list.add(item6);
		list.add(item6);
		list.add(item2);
		list.add(item3);
		list.add(item3);
		list.add(item3);
	}
	
	public ArrayList getList()
	{
		return list;
	}
	
	public boolean validate(int idToValidate) 
	{
		Object[] listArray = list.toArray();
		try
		{
			for (int i = 0; i < listArray.length; i++)
			{
				Item item = (Item) listArray[i];
				if (item.getIdentifier() == idToValidate)
					return true;
			}
		}
		
		catch(ArrayIndexOutOfBoundsException e)
		{
			//The following message is for the developer only and should be handled immediately
			System.out.println("The object to be validated is out of reach" + idToValidate);
			return false;
		}
		
		return false;
	}
	
	// This method will return the first occurrence of item having this @identifier 
	public Item getItem(int identifier)
	{
		int position = getIdPosition(identifier);
		Item itemToReturn = new Item ((Item) list.get(position));
		return itemToReturn;////.copyItem((Item) list.get(position));
	}
	
	//This method will return the position of first occurrence of item having this @identifier 
	public int getIdPosition(int identifier)
	{
		int position = 0;
		Object[] listArray = list.toArray();
		for (int i = 0; i < listArray.length; i++)
		{
			Item item = (Item) listArray[i];
			if (item.getIdentifier() == identifier)
				return i;
		}
		
		return position;
	}
	
	//This method is used to check if an item is present at the database using @idToValidate
	//@idToValidate and @quantityToValidate is to see if there are enough items at the store
	public boolean validate (int idToValidate, int quantityToValidate)
	{
		boolean validId = validate(idToValidate);
		if (validId)
		{
			Item item = getItem(idToValidate);
			int occurrences = Item.getOccurences(list, item);
			if (validId == true && quantityToValidate <= occurrences)
				return true;
		}
		return false;
	}
	
	//this method is used to delete an item from the store database once the customer buys the @item
	public void delete(Item item)
	{
		list.remove(item);
	}
}
