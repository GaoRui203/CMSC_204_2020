
import java.util.LinkedList;

/**
 * @author Gao Rui
 *
 */
public class ConcordanceDataElement implements Comparable<ConcordanceDataElement> {

	private String word;
	private LinkedList<Integer> pageNum;
	private int hashCodeNumber;

	/**
	 * @param word
	 */
	public ConcordanceDataElement(java.lang.String word) {
		this.word = word;
		pageNum = new LinkedList<Integer>();
	}

	/**
	 * 
	 */
	public ConcordanceDataElement() {
		word = null;
	}

	/**
	 * @param lineNum
	 */
	public void addPage(Integer lineNum) {
		if (pageNum.contains(lineNum)) {
			return;
		} else {
			pageNum.addLast(lineNum);
		}
	}

	/**
	 * @return
	 */
	public LinkedList<Integer> getList() {
		return pageNum;
	}

	/**
	 *
	 */
	public String toString() {
		String lines = " ";
		for (int i = 0; i < pageNum.size(); i++) {

			if (i < pageNum.size() - 1) {
				lines += pageNum.get(i) + ", ";
			}

			else {
				lines += pageNum.get(i);
			}
		}
		System.out.println(lines);
		return this.word + ": " + lines;
	}

	/**
	 * @return
	 */
	public String getWord() {
		return word;
	}

	/**
	 *
	 */
	public int hashCode() {
		return word.hashCode();
	}

	/**
	 *
	 */
	public int compareTo(ConcordanceDataElement o) {

		return word.replaceAll("'", "").compareTo(o.word.replaceAll("'", ""));
	}
}