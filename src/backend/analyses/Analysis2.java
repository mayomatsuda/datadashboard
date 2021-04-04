package backend.analyses;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;

import backend.AnalysisStrategy;
import backend.Context;
import backend.Data;
import backend.Data2Series;
import backend.Series;

public class Analysis2 extends AnalysisStrategy
{
	public Analysis2(int yearOne, int yearTwo)
	{
		this.yearOne = yearOne;
		this.yearTwo = yearTwo;
		
		name = "PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area)";
		availableYears = new int[]{2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010};
		availableCountries = new String[]{"CAN", "USA", "BRA", "JPN", "CHI"};
		availableViews = new String[]{"Line", "Bar", "Scatter"};
	}
	
	@Override
	public Series[] getSeries(Context context)
	{
		series = new Series[2];
		String type = context.getType();
		
		Data2Series<Float, Float> data = (Data2Series) context.getData();
		
		series[0] = new Series<Float>(type, "PM2.5 pollution, mean annual (micrograms/cubic meter)");
		series[1] = new Series<Float>(type, "Forest area (% of land)");
		int currentYear;
		
		currentYear = yearOne;
		for(float i : data.getSeriesOne())
		{
			series[0].add(currentYear, i, ((Integer) currentYear).toString());
			currentYear++;
		}
		
		currentYear = yearOne;
		for(float i : data.getSeriesTwo())
		{
			series[1].add(currentYear, i, ((Integer) currentYear).toString());
			currentYear++;
		}
		
		return series;
	}
}
