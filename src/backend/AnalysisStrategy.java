package backend;

import org.jfree.data.time.TimeSeries;

public class AnalysisStrategy
{
	protected String name;
	protected int[] availableYears;
	protected String[] availableCountries;
	protected String[] availableViews;
	
	protected Series[] series;
	protected int yearOne;
	protected int yearTwo;
	
	public String getName()
	{
		return name;
	}
	
	// By default, assume no operation
	public Data doOperation(Context context)
	{
		return context.getData();
	}
	
	public Series[] getSeries(Context context)
	{
		return series;
	}
}
