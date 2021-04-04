package backend.readers;

import com.google.gson.JsonArray;

import backend.Data;
import backend.Data2Series;
import backend.Data3Series;
import backend.ReaderStrategy;

public class Reader8 extends ReaderStrategy
{
	int currentSeries;
	
	// make urls based on parameters
	public Reader8(int year1, int year2, String country)
	{
		data = new Data2Series<Float, Float>();
		
		currentSeries = 1;
		urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/SE.XPD.TOTL.GD.ZS?date=%d:%d&format=json", country, year1, year2);
		readAppropriateData();
		
		currentSeries = 2;
		urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/SH.XPD.CHEX.GD.ZS?date=%d:%d&format=json", country, year1, year2);
		readAppropriateData();
	}
	
	// read, format, and return data from World Bank
	@Override
	protected void interpretData(int size, int sizeOfResults, JsonArray jsonArray)
	{
		for (int i = 0; i < sizeOfResults; i++)
		{
			//year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
			if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
			{
				if (currentSeries == 1) data.addSeriesOne(-1.0f);
				if (currentSeries == 2) ((Data2Series<Float, Float>) data).addSeriesTwo(-1.0f);
			}
			else
			{
				if (currentSeries == 1) data.addSeriesOne(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat());
				if (currentSeries == 2) ((Data2Series<Float, Float>) data).addSeriesTwo(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat());
			}
		}
	}
}
