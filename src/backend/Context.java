package backend;

public class Context
{
	private AnalysisStrategy analysisStrategy;
	private ReaderStrategy readerStrategy;
	
	public Context()
	{
		
	}
	
	public void setAnalysisStrategy(AnalysisStrategy analysisStrategy)
	{
		this.analysisStrategy = analysisStrategy;
	}
	
	public void setAnalysisStrategy(ReaderStrategy readerStrategy)
	{
		this.readerStrategy = readerStrategy;
	}
	
	public void executeAnalysis()
	{
		analysisStrategy.doOperation(this);
	}
	
	public void executeReader()
	{
		readerStrategy.doOperation(this);
	}
}
