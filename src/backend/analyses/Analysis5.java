package backend.analyses;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;

import backend.AnalysisStrategy;
import backend.Context;
import backend.Data;
import backend.Data2Series;
import backend.Series;

public class Analysis5 extends AnalysisStrategy
{
	public Analysis5(int yearOne, int yearTwo)
	{
		this.yearOne = yearOne;
		this.yearTwo = yearTwo;
		
		name = "Average of Government expenditure on education, total (% of GDP)";
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
		
		series[0] = new Series<Float>(type, "Average of Government expenditure on education, total (% of GDP)");
		int currentYear = yearOne;
		
		series[0].add(currentYear, data.getSeriesOne().get(0), "Education");
		series[0].add(currentYear, (1 - data.getSeriesOne().get(0)), "Not Education");
		
		return series;
	}
}
