package handler.exceptions;

import view.View;

public class DbFailureException extends Exception
{
	private View view;
	
	public DbFailureException(View view)
	{
		this.view = view;
		//the following message is for the developer and the user, should handled immediately
		view.printDBerror();
	}
}
