package backend.analyses;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;

import backend.AnalysisStrategy;
import backend.Context;
import backend.Data;
import backend.Data3Series;
import backend.Series;

public class Analysis1 extends AnalysisStrategy
{
	public Analysis1(int yearOne, int yearTwo)
	{
		this.yearOne = yearOne;
		this.yearTwo = yearTwo;
		
		name = "CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita) vs PM2.5 air pollution, mean annual exposure (micrograms per cubic meter)";
	}
	
	@Override
	public Series[] getSeries(Context context)
	{
		series = new Series[3];
		String type = context.getType();
		
		Data3Series<Float, Float, Float> data = (Data3Series<Float, Float, Float>) context.getData();
		
		series[0] = new Series<Float>(type, "CO2 emmisions (tons/capita)");
		series[1] = new Series<Float>(type, "Energy use (kg of oil equivalent/capita)");
		series[2] = new Series<Float>(type, "PM2.5 pollution, mean annual (micrograms/cubic meter)");
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
		
		currentYear = yearOne;
		for(float i : data.getSeriesThree())
		{
			series[2].add(currentYear, i, ((Integer) currentYear).toString());
			currentYear++;
		}
		
		return series;
	}
}
