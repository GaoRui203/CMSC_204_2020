import java.util.ArrayList;

/**
 * @author Gao Rui
 *
 */
public class PasswordCheckerUtility {

	/**
	 * @param passwordString
	 * @return
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException {

		// String password to hold the password,
		// char ch to hold the password's first character.
		String password = passwordString;
		char ch = password.charAt(0);

		// If the password is less than 6 characters, throw the lengthExcption.
		if (passwordString.length() < 6) {
			throw new LengthException("The password must be at least 6 characters long.");
		}

		// Check does this password has digit.
		boolean hasDigit = false;
		// check is this password has least one number character.
		for (int i = 0; i < password.length(); i++) {
			ch = password.charAt(i);
			if (Character.isDigit(ch)) {
				hasDigit = true;
				break; // if this number is digit, break the loop
			}
		}
		// If there isn't has digit, throw the NodigirExcption.
		if (!hasDigit) {
			throw new NoDigitException("The password must contain at least one digit.");
		}

		// Check does this password has uppercase alphabetic.
		boolean noUppercase = password.equals(password.toLowerCase());
		// If the password is not has uppercase alphabetic, throw the
		// NoUpperAlphaException.
		if (noUppercase) {
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character.");
		}

		// Check does this password has uppercase alphabetic.
		boolean noLowercase = password.equals(password.toUpperCase());
		// If the password is not has loewercase alphabetic, throw the
		// NoLowerAlphaException.
		if (noLowercase) {
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character.");
		}

		// if the password have digit, uppercase and lowercase,
		// check the password if contain more than 2 of the same character in sequence.
		if (Character.isDigit(ch) || Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
			for (int i = 0; i < password.length(); i++) {
				// If the password have more than 2 of the same character in sequence,
				// throw the InvalidSequenceException.
				if ((password.charAt(i) == password.charAt(i + 1)) && (password.charAt(i) == password.charAt(i + 2))) {
					throw new InvalidSequenceException(
							"The password can not contain more than two of the same character in sequence.");
				}
			}
		}

		return true;
	}

	// Check if the password is a weak password.
	/**
	 * @param passwordString
	 * @return
	 */
	public static boolean isWeakPassword(String passwordString) {

		// String password to hold the password.
		String password = passwordString;

		boolean weak = false;

		// If the password's length is 6~9 character, this is a weak password, return
		// true.
		if (password.length() >= 6 || password.length() <= 9) {
			weak = true;
		}

		return weak;
	}

	/**
	 * @param passwords
	 * @return
	 */
	public static java.util.ArrayList<java.lang.String> invalidPasswords(java.util.ArrayList<java.lang.String> passwords)
 {
		ArrayList<String> illegalPasswords = new ArrayList<String>();

		String errorMessage = null;

		for (int i = 0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));
			} catch (LengthException e) {
				errorMessage = passwords.get(i) + " The password must be at least 6 cgaracter long.";
				illegalPasswords.add(errorMessage);
			} catch (NoDigitException e) {
				errorMessage = passwords.get(i) + " The password must contain at least one digit.";
				illegalPasswords.add(errorMessage);
			} catch (NoUpperAlphaException e) {
				errorMessage = passwords.get(i)
						+ " The password must contain at least one uppercase alphabetic character.";
				illegalPasswords.add(errorMessage);
			} catch (NoLowerAlphaException e) {
				errorMessage = passwords.get(i)
						+ " The password must contain at least one lowercase alphabetic character.";
				illegalPasswords.add(errorMessage);
			} catch (InvalidSequenceException e) {
				errorMessage = passwords.get(i) + " The password can not more than two of same character in sequence.";
				illegalPasswords.add(errorMessage);
			}

		}

		return illegalPasswords;
	}

}
