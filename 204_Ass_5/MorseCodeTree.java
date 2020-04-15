import java.util.ArrayList;


/**
 * @author Rui Gao
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<java.lang.String> {
	private TreeNode<String> root = null;

	private String fetchedLetter;

	/**
	 * 
	 */
	public MorseCodeTree() {
		buildTree();
	}


	/**
	 *
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		if (code.length() == 1) {
			if (code.equals(".")) {
				root.ltchild = new TreeNode<String>(letter);
			} else {
				root.rtchild = new TreeNode<String>(letter);
			}
			return;
		} else {
			if (code.substring(0, 1).equals(".")) {
				addNode(root.ltchild, code.substring(1), letter);
			}

			else {
				addNode(root.rtchild, code.substring(1), letter);
			}
		}
	}


	/**
	 *
	 */
	@Override
	public void buildTree() {

		root = new TreeNode<String>("");

		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 *
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}


	/**
	 *
	 */
	@Override
	public java.lang.String fetch(java.lang.String code) {
		String letter = fetchNode(root, code);
		return letter;
	}


	/**
	 *
	 */
	@Override
	public java.lang.String fetchNode(TreeNode<java.lang.String> root, java.lang.String code) {
		if (code.length() == 1) {
			if (code.equals(".")) {
				fetchedLetter = root.ltchild.getData();
			}
			else {
				fetchedLetter = root.rtchild.getData();
			}
		} 
		else {
			if (code.substring(0, 1).equals(".")) {
				fetchNode(root.ltchild, code.substring(1));
			} 
			else {
				fetchNode(root.rtchild, code.substring(1));
			}
		}
		return fetchedLetter;
	}


	/**
	 *
	 */
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}


	/**
	 *
	 */
	@Override
	public MorseCodeTree insert(java.lang.String code, java.lang.String letter) {
		addNode(root, code, letter);
		return this;
	}


	/**
	 *
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> list) {
		if (root != null) {
			LNRoutputTraversal(root.ltchild, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rtchild, list);
		}
	}

	/**
	 *
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/**
	 *
	 */
	@Override
	public java.util.ArrayList<java.lang.String> toArrayList() {
		ArrayList<String> printTree = new ArrayList<String>();
		LNRoutputTraversal(root, printTree);
		return printTree;
	}


	/**
	 *
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}

}