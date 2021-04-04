package backend;

import org.jfree.data.time.TimeSeries;

public class Context
{
	private AnalysisStrategy analysisStrategy;
	private ReaderStrategy readerStrategy;
	
	private Data data;
	private String type;
	
	public Context()
	{
		
	}
	
	public Data getData()
	{
		return data;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setAnalysisStrategy(AnalysisStrategy analysisStrategy)
	{
		this.analysisStrategy = analysisStrategy;
	}
	
	public void setAnalysisStrategy(ReaderStrategy readerStrategy)
	{
		this.readerStrategy = readerStrategy;
	}
	
	public Series[] executeAnalysis()
	{
		data = analysisStrategy.doOperation(this);
		return analysisStrategy.getSeries(this);
	}
	
	public void executeReader()
	{
		data = readerStrategy.readAppropriateData();
	}
}
