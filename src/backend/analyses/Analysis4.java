package backend.analyses;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;

import backend.AnalysisStrategy;
import backend.Context;
import backend.Data;
import backend.Data2Series;
import backend.Series;

public class Analysis4 extends AnalysisStrategy
{
	public Analysis4(int yearOne, int yearTwo)
	{
		this.yearOne = yearOne;
		this.yearTwo = yearTwo;
		
		name = "Average Forest area (% of land area)";
		availableYears = new int[]{2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010};
		availableCountries = new String[]{"CAN", "USA", "BRA", "JPN", "CHI"};
		availableViews = new String[]{"Pie"};
	}
	
	@Override
	public Data doOperation(Context context)
	{
		Data<Float> data = context.getData();
		Data<Float> computedData = new Data<Float>();
		
		float sum = 0;
		
		for(int i = 0; i < data.getSeriesOne().size(); i++)
		{
			sum = sum + data.getSeriesOne().get(i);
		}
		
		float average = sum / (yearTwo - yearOne);
		
		computedData.addSeriesOne(average);
		
		return computedData;
	}
	
	@Override
	public Series[] getSeries(Context context)
	{
		series = new Series[1];
		String type = context.getType();
		
		Data<Float> data = context.getData();
		
		series[0] = new Series<Float>(type, "Average Forest area (% of land area)");
		int currentYear = yearOne;
		
		series[0].add(currentYear, data.getSeriesOne().get(0), "Forest");
		series[0].add(currentYear, (1 - data.getSeriesOne().get(0)), "Not Forest");
		
		return series;
	}
}
