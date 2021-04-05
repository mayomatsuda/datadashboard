package backend;

import backend.analyses.*;
import backend.readers.*;
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
	
	private String currentAnalysis;
	private int currentStartYear;
	private int currentEndYear;
	private String currentCountry;
	
	Series[] series;
	
	public Facade()
	{
		
	}
	
	public void checkSelections()
	{
		// NOTE if another class makes instances of the selector boxes change this to use them
		currentStartYear = yearBox.getCurrentSelectionOne();	// tentative code please change
		currentEndYear = yearBox.getCurrentSelectionTwo();		// tentative code please change
		currentAnalysis = analysisBox.getCurrentSelection();	// tentative code please change
		currentCountry = countryBox.getCurrentSelection();		// tentative code please change
		
		
		if (currentAnalysis.equals("Analyses 1"))
		{
			context.setReaderStrategy(new Reader1(currentStartYear, currentEndYear, currentCountry));
			context.setAnalysisStrategy(new Analysis1(currentStartYear, currentEndYear));
		}
		
		if (currentAnalysis.equals("Analyses 2"))
		{
			context.setReaderStrategy(new Reader2(currentStartYear, currentEndYear, currentCountry));
			context.setAnalysisStrategy(new Analysis2(currentStartYear, currentEndYear));
		}
		
		if (currentAnalysis.equals("Analyses 3"))
		{
			context.setReaderStrategy(new Reader3(currentStartYear, currentEndYear, currentCountry));
			context.setAnalysisStrategy(new Analysis3(currentStartYear, currentEndYear));
		}
		
		if (currentAnalysis.equals("Analyses 4"))
		{
			context.setReaderStrategy(new Reader4(currentStartYear, currentEndYear, currentCountry));
			context.setAnalysisStrategy(new Analysis4(currentStartYear, currentEndYear));
		}
		
		if (currentAnalysis.equals("Analyses 5"))
		{
			context.setReaderStrategy(new Reader5(currentStartYear, currentEndYear, currentCountry));
			context.setAnalysisStrategy(new Analysis5(currentStartYear, currentEndYear));
		}
		
		if (currentAnalysis.equals("Analyses 6"))
		{
			context.setReaderStrategy(new Reader6(currentStartYear, currentEndYear, currentCountry));
			context.setAnalysisStrategy(new Analysis6(currentStartYear, currentEndYear));
		}
		
		if (currentAnalysis.equals("Analyses 7"))
		{
			context.setReaderStrategy(new Reader7(currentStartYear, currentEndYear, currentCountry));
			context.setAnalysisStrategy(new Analysis7(currentStartYear, currentEndYear));
		}
		
		if (currentAnalysis.equals("Analyses 8"))
		{
			context.setReaderStrategy(new Reader8(currentStartYear, currentEndYear, currentCountry));
			context.setAnalysisStrategy(new Analysis8(currentStartYear, currentEndYear));
		}
	}
	
	public void ReadData()
	{
		// Run context readers
		// Check read data - if null, open error box
		context.executeReader();
		if (context.getData() == null) //PUT UP UI ERROR HERE SAYING THERE IS NO DATA;
			;
		series = context.executeAnalysis();
	}
	
	public void populateViewers()
	{
		
	}
}
