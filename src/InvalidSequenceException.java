/**
 * @author Gao Rui
 *
 */
@SuppressWarnings("serial")
public class InvalidSequenceException extends Exception

{
	/**
	 * 
	 */
	public InvalidSequenceException() 
	{
	}
	
	/**
	 * @param message
	 */
	public InvalidSequenceException(String message)
	{
		super(message);
	}
}
