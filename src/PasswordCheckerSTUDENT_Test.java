
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
/**
 * @author Gao Rui
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> pw;
	String pw1,pw2;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		String[] p = {"849685FG", "Am6solw9Q", "jsiwop9AAA", "9iskw", "oksjwk95", "6aiqwAbcd", 
				"apwlks94", "mxjuwi", "Rpaowksv", "qs86a", "spowijeudjsn", "okPwjskwie", 
				"okPwjskwie2"};
		pw = new ArrayList<String>();
		pw.addAll(Arrays.asList(p));
		
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		pw = null;
	
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	/**
	 * 
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("pwqPWQ89"));
			PasswordCheckerUtility.isValidPassword("qwe78");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}	
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	/**
	 * 
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("5879123sD"));
			PasswordCheckerUtility.isValidPassword("5879123s");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	/**
	 * 
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("5879123Ds"));
			PasswordCheckerUtility.isValidPassword("5879123D");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	/**
	 * 
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("4578ssDD"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("4578ssDD");
			assertTrue(weakPwd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	/**
	 * 
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("4578ddDD"));
			PasswordCheckerUtility.isValidPassword("4578dDDD");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
		
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	/**
	 * 
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("58wrPSxswk"));
			PasswordCheckerUtility.isValidPassword("wrPSxswk");
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	/**
	 * 
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("58wrPSxswk"));
			PasswordCheckerUtility.isValidPassword("58wrPSxswk");
			assertTrue("Did not throw UnmatchedException",false);
		}
		catch(UnmatchedException e)
		{
			assertTrue("Successfully threw a UnmatchedException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides UnmatchedException",false);
		}
		
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	/**
	 * 
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.validPasswords(pw);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "778899AA");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "tyioty4QQQ");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("more than two"));
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "sdwehb88");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "pqosku");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		scan = new Scanner(results.get(6)); //a
		assertEquals(scan.next(), "Qoskwlpa");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		
	}
	
}
