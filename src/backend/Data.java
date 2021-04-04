package backend;

import java.util.List;
import java.util.ArrayList;

public class Data<t1, t2, t3> extends Model
{
	private List<t1> seriesOne;
	private List<t2> seriesTwo;
	private List<t3> seriesThree;
	
	public Data()
	{
		seriesOne = new ArrayList<t1>();
		seriesTwo = new ArrayList<t2>();
		seriesThree = new ArrayList<t3>();
	}
	
	public void addSeriesOne(t1 dataItem)
	{
		seriesOne.add(dataItem);
	}
	
	public void addSeriesTwo(t2 dataItem)
	{
		seriesTwo.add(dataItem);
	}
	
	public void addSeriesThree(t3 dataItem)
	{
		seriesThree.add(dataItem);
	}
}
