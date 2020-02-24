class ArraySum
{

	public int sumOfArray(Integer array[], int size) 
	{
		if (size <= 0) 
		{
			return 0;
		}

		return sumOfArray(array, size - 1) + array[size - 1];

	}

}