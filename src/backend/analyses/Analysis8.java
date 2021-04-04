package backend.analyses;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;

import backend.AnalysisStrategy;
import backend.Context;
import backend.Data;
import backend.Data2Series;
import backend.Series;

public class Analysis8 extends AnalysisStrategy
{
	public Analysis8(int yearOne, int yearTwo)
	{
		this.yearOne = yearOne;
		this.yearTwo = yearTwo;
		
		name = "Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)";
		availableYears = new int[]{2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010};
		availableCountries = new String[]{"CAN", "USA", "BRA", "JPN", "CHI"};
		availableViews = new String[]{"Line", "Bar", "Scatter"};
	}
	
	@Override
	public Data doOperation(Context context)
	{
		Data2Series<Float, Float> data = (Data2Series<Float, Float>) context.getData();
		Data<Float> computedData = new Data<Float>();
		
		for(int i = 0; i < data.getSeriesOne().size(); i++)
		{
			float ratio = data.getSeriesOne().get(i) / data.getSeriesTwo().get(i);
			computedData.addSeriesOne(ratio);
		}
		
		return computedData;
	}
	
	@Override
	public Series[] getSeries(Context context)
	{
		series = new Series[2];
		String type = context.getType();
		
		Data2Series<Float, Float> data = (Data2Series) context.getData();
		
		series[0] = new Series<Float>(type, "Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)");
		int currentYear;
		
		currentYear = yearOne;
		for(float i : data.getSeriesOne())
		{
			series[0].add(currentYear, i, ((Integer) currentYear).toString());
			currentYear++;
		}
		
		return series;
	}
}
