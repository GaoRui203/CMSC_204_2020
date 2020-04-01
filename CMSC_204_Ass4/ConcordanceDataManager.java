
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Gao Rui
 *
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface {

	private ConcordanceDataStructure data = new ConcordanceDataStructure();

	/**
	 *
	 */
	public ArrayList<String> createConcordanceArray(String input) {
		int lineNum = 0;
		int size = 0;
		String[] line = null;
		String[] word;

		ArrayList<String> list = new ArrayList<>();
		String newInput = input.replaceAll("[,.!?\"_]", "");

		for (int i = 0; i < line.length; i++) {
			size += line[i].toLowerCase().split(" ").length;
		}

		for (int i = 0; i < line.length; i++) {
			word = line[i].toLowerCase().split(" ");
			lineNum++;
			for (int j = 0; j < word.length; j++) {
				if (!word[j].equals("the") && !word[j].equals("and") && word[j].length() >= 3) {
					if (word[j].length() >= 3) {
						data.add(word[j], lineNum);
					}
				}
			}
		}
		ArrayList<String> concordance = data.showAll();

		return concordance;
	}

	/**
	 *
	 */
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {

		ArrayList<String> dataFile = new ArrayList<>();

		if (!input.canRead())
			throw new FileNotFoundException("Not found.");

		Scanner inputFile = new Scanner(input);
		String fileInput = "";
		while (inputFile.hasNext()) {
			fileInput += inputFile.nextLine() + " ";
		}

		inputFile.close();
		dataFile = createConcordanceArray(fileInput);
		try {
			FileWriter fw = new FileWriter(output);
			PrintWriter out = new PrintWriter(fw);
			for (int i = 0; i < dataFile.size(); i++) {
				out.print(dataFile.get(i));
			}
			out.flush();
			out.close();
			return true;
		} catch (IOException e) {
			System.out.println("IOException throw");
		}
		return true;
	}
}
