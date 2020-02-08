
public class DataSetGen<T> 
{
	private double sum;
	private Measurable maximum;
	private int count;
	
	/*
	 * Constructs an empty data set
	 */
	public DataSetGen()
	{
		sum = 0;
		count = 0;
		maximum = null;
	}

	/*
	 * Adds a data value to the data set.
	 */
	public void add(Measurable x)
	{
		sum = sum + x.getMeasure();
		if (count == 0 || maximum.getMeasure() < x.getMeasure())
		{
			maximum = x;
		}
		count++;
	}
	
	/*
	 * Gets the average of the added data.
	 */
	public double getAverage()
	{
		return (count == 0 ? count : sum / count);
	}
	
	/*
	 * Gets the largest of the added data.
	 */
	public T getMaximum()
	{
		return (T) maximum;
	}
	
}
