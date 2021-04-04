package backend;

public abstract class AnalysisStrategy
{
	public abstract void doOperation(Context context, Data data);
	public abstract String getName();
}
