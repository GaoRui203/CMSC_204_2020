import java.util.ArrayList;

/**
 * @author Gao Rui
 *
 */
public interface PasswordCheckerUtilityInterface {

	/**
	 * @param passwordString
	 * @return
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws InvalidSequenceException
	 */
	public boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException;
	
	/**
	 * @param passwords
	 * @return
	 */
	public ArrayList<String> validPasswords(ArrayList<String> passwords);
	

}
