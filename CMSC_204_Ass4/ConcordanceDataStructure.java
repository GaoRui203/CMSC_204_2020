
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Gao Rui
 *
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {

	private LinkedList<ConcordanceDataElement>[] table;
	private double loadingFactor = 1.5;
	private int tableSize;

	/**
	 * @param size
	 */
	public ConcordanceDataStructure(int size) {
		tableSize = nextPrime(size, (int) ((1.0 / loadingFactor - 1) * 100.0));
		table = new LinkedList[tableSize];
	}

	/**
	 * @param size
	 * @param i
	 * @return
	 */
	private int nextPrime(int size, int i) {

		return 0;
	}

	/**
	 * @param size
	 * @param test
	 */
	public ConcordanceDataStructure(int size, String test) {
		tableSize = size;
		table = new LinkedList[tableSize];
	}

	/**
	 *
	 */
	public int getTableSize() {
		return tableSize;
	}

	/**
	 *
	 */
	public ArrayList<String> getWords(int index) {
		ArrayList<String> words = new ArrayList<String>();
		LinkedList<ConcordanceDataElement> list = table[index];

		for (int i = 0; i < list.size(); i++) {
			words.add(list.get(i).getWord());
		}
		return words;
	}

	/**
	 *
	 */
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {

		ArrayList<LinkedList<Integer>> x = new ArrayList<LinkedList<Integer>>();
		LinkedList<ConcordanceDataElement> list = table[index];
		for (int i = 0; i < list.size(); i++) {
			x.add(list.get(i).getList());
		}
		return x;
	}

	/**
	 * 
	 */
	public ConcordanceDataStructure() {
		table = new LinkedList[tableSize];

		for (int i = 0; i < tableSize; i++) {
			table[i] = new LinkedList<ConcordanceDataElement>();
		}
	}

	/**
	 *
	 */
	public void add(String word, int lineNumb) {
		ConcordanceDataElement dataElement = new ConcordanceDataElement(word);
		dataElement.addPage(lineNumb);
		int index = Math.abs(dataElement.hashCode() % tableSize);

		if (table[index] == null) {
			table[index] = new LinkedList<ConcordanceDataElement>();
			table[index].add(dataElement);
		}

		else {
			boolean y = false;
			Iterator<ConcordanceDataElement> iterator = table[index].iterator();
			while (iterator.hasNext()) {
				ConcordanceDataElement curren = iterator.next();
				if (curren.getWord().equals(word)) {
					curren.addPage(lineNumb);
					y = true;

				}
			}
			if (y == false)
				table[index].add(dataElement);
		}

	}

	/**
	 *
	 */
	public ArrayList<String> showAll() {

		ArrayList<String> showArray = new ArrayList<String>();

		for (int i = 0; i < tableSize; i++) {
			LinkedList<ConcordanceDataElement> row = table[i];

			for (int j = 0; j < row.size(); j++) {
				showArray.add(row.get(j).toString() + "\n");
			}
		}
		Collections.sort(showArray);

		return showArray;
	}

	/**
	 * @param n
	 * @return
	 */
	public static int nextPrime(int n) {
		double k;
		int prime;
		BigInteger b = new BigInteger(String.valueOf(n));

		prime = Integer.parseInt(b.nextProbablePrime().toString());
		k = (prime - 3.0) % 4.0;

		while ((prime - 3.0) % 4.0 != 0) {
			b = new BigInteger(String.valueOf(prime + 1));
			prime = Integer.parseInt(b.nextProbablePrime().toString());
			k = (prime - 3.0) / 4.0;
		}
		return prime;
	}
}