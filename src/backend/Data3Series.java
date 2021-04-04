package backend;

import java.util.List;
import java.util.ArrayList;

// three-series data
public class Data3Series<t1, t2, t3> extends Data<t1>
{
	private List<t2> seriesTwo;
	private List<t3> seriesThree;
	
	public Data3Series()
	{
		super();
		seriesTwo = new ArrayList<t2>();
		seriesThree = new ArrayList<t3>();
	}
	
	public void addSeriesTwo(t2 dataItem)
	{
		seriesTwo.add(dataItem);
	}
	
	public void addSeriesThree(t3 dataItem)
	{
		seriesThree.add(dataItem);
	}
	
	public List<t2> getSeriesTwo()
	{
		return seriesTwo;
	}
	
	public List<t3> getSeriesThree()
	{
		return seriesThree;
	}
}
