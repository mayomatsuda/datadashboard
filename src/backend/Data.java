package backend;

import java.util.List;
import java.util.ArrayList;

// one-series data
public class Data<t1> extends Model
{
	protected List<t1> seriesOne;
	
	public Data()
	{
		seriesOne = new ArrayList<t1>();
	}
	
	public void addSeriesOne(t1 dataItem)
	{
		seriesOne.add(dataItem);
	}
}
