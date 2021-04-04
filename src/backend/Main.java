package backend;

import backend.readers.Reader1;
import frontend.MainUI;

public class Main
{
	private static MainUI UI;
	
	public static void main(String[] args)
	{
		//UI = new MainUI();
		Reader1 reader = new Reader1(2000, 2007, "CAN");
		Data data = reader.getData();
	}
}
