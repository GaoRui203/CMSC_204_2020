
/**
 * @author Rui Gao
 *
 * @param <T>
 */
public class TreeNode<T> {
	protected T data;
	protected TreeNode<T> ltchild;
	protected TreeNode<T> rtchild;


	/**
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.ltchild = null;
		this.rtchild = null;
	}

	/**
	 * @return
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		new TreeNode<T>(node);
	}

}