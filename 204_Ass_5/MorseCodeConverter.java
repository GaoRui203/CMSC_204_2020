import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rui Gao
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree t = new MorseCodeTree();

	/**
	 * 
	 */
	public MorseCodeConverter() {
	}

	
	/**
	 * @return
	 */
	public static java.lang.String printTree() {
		ArrayList<String> treeData = new ArrayList<String>();
		treeData = t.toArrayList();
		String print = "";
		for (int i = 0; i < treeData.size(); i++) {
			print += treeData.get(i) + " ";
		}
		return print;
	}

	
	/**
	 * @param code
	 * @return
	 */
	public static java.lang.String convertToEnglish(java.lang.String code) {
		String[] word = null;
		String[] letter = null;
		String result = " ";

		word = code.split(" / ");

		for (int i = 0; i < word.length; i++) {
			letter = word[i].split(" ");
			for (int j = 0; j < letter.length; j++) {
				result += t.fetch(letter[j]);
			}
			result += " ";
		}
		result = result.trim();
		return result;
	}


	/**
	 * @param codeFile
	 * @return
	 * @throws java.io.FileNotFoundException
	 */
	public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException {
		ArrayList<String> line = new ArrayList<String>();
		String[] word;
		String[] letter;
		String result = " ";
		Scanner inputFile;
		inputFile = new Scanner(codeFile);

		while (inputFile.hasNext()) {
			line.add(inputFile.nextLine());
		}
		inputFile.close();

		for (int i = 0; i < line.size(); i++) {
			word = line.get(i).split(" / ");

			for (int j = 0; j < word.length; j++) {
				letter = word[j].split(" ");

				for (int k = 0; k < letter.length; k++) {
					result += t.fetch(letter[k]);
				}
				result += " ";
			}
		}
		result = result.trim();
		return result;
	}
}
