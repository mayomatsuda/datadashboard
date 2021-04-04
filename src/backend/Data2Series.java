package backend;

import java.util.List;
import java.util.ArrayList;

// two-series data
public class Data2Series<t1, t2> extends Data<t1>
{
	private List<t2> seriesTwo;
	
	public Data2Series()
	{
		super();
		seriesTwo = new ArrayList<t2>();
	}
	
	public void addSeriesTwo(t2 dataItem)
	{
		seriesTwo.add(dataItem);
	}
}
