package externalConnections;
import java.util.ArrayList;
import view.*;

public class DisplayGrabber implements Subject
{
	private ArrayList <Observer> observers;
	private double runningTotal = 0;
	
	public DisplayGrabber()
	{
		observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer newDisplay) 
	{
		observers.add(newDisplay);
		
	}

	@Override
	public void unregister(Observer deleteDisplay) 
	{
		int observerIndex = observers.indexOf(deleteDisplay);
		observers.remove(observerIndex);
		
	}

	@Override
	public void notifyObserver() 
	{
		for(Observer observer : observers)
		{
			 observer.update(runningTotal);
		}	
	}
	
	public void addNewPrice(double newPrice)
	{
		runningTotal = runningTotal + newPrice;
		notifyObserver();
	}
}