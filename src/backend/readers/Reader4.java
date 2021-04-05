package backend.readers;

import com.google.gson.JsonArray;

import backend.Data;
import backend.ReaderStrategy;

public class Reader4 extends ReaderStrategy
{
	int currentSeries;
	
	// make urls based on parameters
	public Reader4(int year1, int year2, String country)
	{
		data = new Data<Float>();
		
		currentSeries = 1;
		urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/AG.LND.FRST.ZS?date=%d:%d&format=json", country, year1, year2);
		readAppropriateData();
	}
	
	// read, format, and return data from World Bank
	@Override
	protected void interpretData(int size, int sizeOfResults, JsonArray jsonArray)
	{
		goodDataFound = false;
		for (int i = 0; i < sizeOfResults; i++)
		{
			//year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
			if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
			{
				if (currentSeries == 1) data.addSeriesOne(-1.0f);
			}
			else
			{
				goodDataFound = true;
				if (currentSeries == 1) data.addSeriesOne(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat());
			}
		}
	}
}
