package backend.readers;

import com.google.gson.JsonArray;

import backend.Data;
import backend.Data3Series;
import backend.ReaderStrategy;

public class Reader1 extends ReaderStrategy
{
	int currentSeries;
	
	// make urls based on parameters
	public Reader1(int year1, int year2, String country)
	{
		data = new Data3Series<Float, Float, Float>();
		
		currentSeries = 1;
		urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/EN.ATM.CO2E.PC?date=%d:%d&format=json", country, year1, year2);
		readAppropriateData();
		
		currentSeries = 2;
		urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/EG.USE.PCAP.KG.OE?date=%d:%d&format=json", country, year1, year2);
		readAppropriateData();
		
		currentSeries = 3;
		urlString = String.format(
				"http://api.worldbank.org/v2/country/%s/indicator/EN.ATM.PM25.MC.M3?date=%d:%d&format=json", country, year1, year2);
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
				if (currentSeries == 2) ((Data3Series<Float, Float, Float>) data).addSeriesTwo(-1.0f);
				if (currentSeries == 3) ((Data3Series<Float, Float, Float>) data).addSeriesThree(-1.0f);
			}
			else
			{
				goodDataFound = true;
				if (currentSeries == 1) data.addSeriesOne(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat());
				if (currentSeries == 2) ((Data3Series<Float, Float, Float>) data).addSeriesTwo(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat());
				if (currentSeries == 3) ((Data3Series<Float, Float, Float>) data).addSeriesThree(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat());
			}
		}
	}
}
