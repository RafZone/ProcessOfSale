package startUp;
import view.View;

public class Main 
{
	private static View view;
	
	public static void main(String[] args) 
	{
		view = new View();
		view.launch();
	}
}
