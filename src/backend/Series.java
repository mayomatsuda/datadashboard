package backend;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;

public class Series<T>
{
	private String type;
	private Object series;
	private String name;
	
	public Series(String type, String name)
	{
		this.type = type;
		this.name = name;
		
		if (type.equals("Line")) series = new XYSeries(name);
		else if (type.equals("Bar")) series = new DefaultCategoryDataset();
		else if (type.equals("Pie")) series = new DefaultCategoryDataset();
		else if (type.equals("Scatter")) series = new TimeSeries(name);
	}
	
	public Object getSeries()
	{
		return series;
	}
	
	public void add(int year, T value, String label)
	{
		if (type.equals("Line")) ((XYSeries) series).add(year, (double) value);
		if (type.equals("Scatter")) ((TimeSeries) series).add(new Year(year), (double) value);
		if (type.equals("Bar")) ((DefaultCategoryDataset) series).addValue((double) value, name, ((Integer) year).toString());
		if (type.equals("Pie")) ((DefaultCategoryDataset) series).addValue((double) value, name, label);
	}
}
