/**
 * @author Gao Rui
 *
 */
@SuppressWarnings("serial")
public class NoLowerAlphaException extends Exception
{
	/**
	 * 
	 */
	public NoLowerAlphaException()
	{
	}
	
	
	/**
	 * @param message
	 */
	public NoLowerAlphaException(String message)
	{
		super(message);
	}
}
