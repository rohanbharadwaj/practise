public class BinaryTree {
	private Node root;

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int d) {
			left = null;
			right = null;
			data = d;
		}
	}

	BinaryTree() {
		root = null;
	}

	public boolean lookup(int data) {
		return (lookup(root, data));
	}

	private boolean lookup(Node node, int data) {
		if (node == null)
			return (false);
		if (data == node.data)
			return (true);
		else if (data < node.data) {
			return (lookup(node.left, data));
		} else {
			return (lookup(node.right, data));
		}
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else {
			if (data <= node.data)
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}

	public int maxDepth() {
		return (maxDepth(root));
	}

	private int maxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);
			return (Math.max(lDepth, rDepth) + 1);
		}
	}

	public boolean isBalanced() {
		return (isBalanced(root));
	}

	private boolean isBalanced(Node node) {
		if (node == null)
			return true;
		int heightDiff = maxDepth(node.left) - maxDepth(node.right);
		if (Math.abs(heightDiff) > 1)
			return false;
		else {
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}

	public int checkHeight() {
		return (checkHeight(root));
	}

	private int checkHeight(Node node) {
		if (node == null)
			return 0;// height 0
		int lHeight = checkHeight(node.left);
		int rHeight = checkHeight(node.right);
		int heightDiff = lHeight - rHeight;
		if (lHeight == -1 || rHeight == -1 || Math.abs(heightDiff) > 1)
			return -1;
		else
			return Math.max(lHeight, rHeight) + 1;
	}

	public boolean isBalanced1() { // O(N) Time and O(H) space.
		return isBalanced1(root);
	}

	private boolean isBalanced1(Node node) {
		if ((checkHeight(node)) == -1)
			return false;
		else
			return true;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node node) {
		if (node == null)
			return;
		else {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		if (node == null)
			return;
		else {
			System.out.print(node.data + " ");
			inorder(node.left);
			inorder(node.right);
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		if (node == null)
			return;
		else {
			inorder(node.left);
			inorder(node.right);
			System.out.print(node.data + " ");
		}
	}
	
	public void bfs()
	{
		bfs(root);
	}
	private void bfs(Node node)
	{
		
	}

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		bt.insert(3);
		bt.insert(4);
		bt.insert(1);
		bt.insert(10);
		System.out.println(bt.lookup(4));
		System.out.println(bt.lookup(53));
		bt.insert(53);
		System.out.println(bt.lookup(53));
		System.out.println(bt.maxDepth());
		System.out.println(bt.isBalanced());
		System.out.println(bt.isBalanced1());
		System.out.print("Inorder : ");
		bt.inorder();
		System.out.print("\nPreorder : ");
		bt.preorder();
		System.out.print("\nPostorder : ");
		bt.postorder();
	}
}