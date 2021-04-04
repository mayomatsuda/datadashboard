package backend.analyses;

import backend.AnalysisStrategy;
import backend.Context;
import backend.Data;

public class Analysis1 extends AnalysisStrategy
{
	private String name;
	
	@Override
	public Data doOperation(Context context, Data data)
	{
		
	}
	
	@Override
	public String getName()
	{
		return name;
	}
}
