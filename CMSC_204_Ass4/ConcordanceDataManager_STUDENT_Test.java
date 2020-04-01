
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Gao Rui
 *
 */
public class ConcordanceDataManager_STUDENT_Test {
	private ConcordanceDataManagerInterface concordanceManager = new ConcordanceDataManager();
	private File inputFile, outputFile;
	private String text;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		concordanceManager = new ConcordanceDataManager();
		text = "Hello\n how are you\n" + "I like your bag\n";
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		concordanceManager = null;
	}

	/**
	 * 
	 */
	@Test
	public void testCreateConcordanceArray() {
		ArrayList<String> word = concordanceManager.createConcordanceArray(text);
	}

	/**
	 * 
	 */
	@Test
	public void testCreateConcordanceFile() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("Hello\n" + "how are you\n" + "I like your bag\n");

			inFile.close();
			outputFile = new File("Test1Out.txt");
			PrintWriter outFile = new PrintWriter(outputFile);
			outFile.print(" ");

			concordanceManager.createConcordanceFile(inputFile, outputFile);
			Scanner scan = new Scanner(outputFile);
			while (scan.hasNext()) {
				words.add(scan.nextLine());
			}

			scan.close();
			outFile.close();

		} catch (FileNotFoundException e) {

			System.out.println("IOException throw");
		} catch (Exception e) {

			System.out.println("IOException throw");
		}
	}
}