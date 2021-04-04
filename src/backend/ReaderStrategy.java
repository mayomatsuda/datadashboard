package backend;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class ReaderStrategy
{
	protected String urlString;
	protected Data data;
	
	public Data readAppropriateData()
	{
		try
		{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200)
			{
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext())
				{
					inline += sc.nextLine();
				}
				sc.close();
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int size = jsonArray.size();
				int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
				int year;

				interpretData(size, sizeOfResults, jsonArray);
				return data;
			}
		}
		catch (IOException e)
		{
			System.out.println("error");
		}
		return null;
	}
	
	protected void interpretData(int size, int sizeOfResults, JsonArray jsonArray)
	{
		
	}
}
