package handler.exceptions;
import view.View;
import java.util.ArrayList;

public class UserListIsFullException extends Exception
{
	private View view;
	private ArrayList list;
	
	public UserListIsFullException(View view, ArrayList list)
	{
		this.view = view;
		this.list = list;
		//the following message is for the user only.
		view.listIstFull();
	}
}
