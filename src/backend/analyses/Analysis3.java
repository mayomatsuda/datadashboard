package backend.analyses;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;

import backend.AnalysisStrategy;
import backend.Context;
import backend.Data;
import backend.Data2Series;
import backend.Series;

public class Analysis3 extends AnalysisStrategy
{
	public Analysis3(int yearOne, int yearTwo)
	{
		this.yearOne = yearOne;
		this.yearTwo = yearTwo;
		
		name = "Ratio of CO2 emissions (metric tons per capita) and GDP per capita (current US$)";
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
		
		series[0] = new Series<Float>(type, "Ratio of CO2 emmissions (tons/capita) to GDP ($US/capita)");
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
