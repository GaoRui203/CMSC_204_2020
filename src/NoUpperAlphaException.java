/**
 * @author Gao Rui
 *
 */
@SuppressWarnings("serial")
public class NoUpperAlphaException extends Exception 
{
	/**
	 * 
	 */
	public NoUpperAlphaException()
	{
	}
	
	/**
	 * @param message
	 */
	public NoUpperAlphaException(String message)
	{
		super(message);
	}
}
