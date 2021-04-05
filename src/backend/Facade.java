package backend;

import backend.local_databases.AnalysisDatabase;

public class Facade
{
	private String[] currentSelections;
	private AnalysisDatabase analysisDb;
	private Context context;
	
	private ViewSelectorBox viewBox;
	private CountrySelectorBox countryBox;
	private YearSelectorBox yearBox;
	private AnalysisSelectorBox analysisBox;
	
	public Facade()
	{
		
	}
	
	public void checkSelections()
	{
		
	}
	
	public void ReadData()
	{
		// Run context readers
		// Check read data - if null, open error box
	}
	
	public void populateViewers()
	{
		
	}
}
