import java.util.Scanner;

//노드 클래스를 먼저 생성
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
		this.left = null;
		this.right = null;
	}

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BinarySearchTree {
	private TreeNode root; 
	
	public TreeNode rootNode(int inputValue){
		root = new TreeNode(inputValue);
		return root;
	}

	public TreeNode insertKey(TreeNode root, int x) {
		TreeNode p = root;

		TreeNode newNode = new TreeNode(x);

		if (p == null) {
			return newNode;
		} else if (p.data > newNode.data) {
			p.left = insertKey(p.left, x);
			return p;
		} else if (p.data < newNode.data) {
			p.right = insertKey(p.right, x);
			return p;
		} else {
			return p;
		}
	}

	public void insertBST(int x) {
		root = insertKey(root, x);
	}

	// 후순위
	public void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);
		}
	}

	public void printBST() {
		postorder(root);
	}
}

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		// bst.insertBST(50);

		int inputValue = scan.nextInt();
		bst.rootNode(inputValue);

		while (scan.hasNext()) {
			try {
				inputValue = scan.nextInt();
				bst.insertBST(inputValue);
			} catch (Exception e) {
				System.out.println("숫자만을 입력해야 합니다. 종료합니다.");
				break;
			}
		}

		bst.printBST();

	}

}