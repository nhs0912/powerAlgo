import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.IOException; 

class BinaryTree {

	private class Node {
		public int value; 
		public Node left = null; 
		public Node right = null; 

		public Node(int value) {
			this.value = value; 
		}
	}

	public Node root; 

	public BinaryTree() {}
	
	public void insert(int newValue) {
		root = insert(root, newValue); 
	}

	private Node insert(Node currNode, int newValue) {
		Node newNode = new Node(newValue);

		// Base Case
		if(currNode == null) {
			currNode = newNode; 
		}
		else {
			// Recursive Case
			if(currNode.value > newValue) {
				currNode.left = insert(currNode.left, newValue); 
			}
			else {
				currNode.right = insert(currNode.right, newValue); 
			}
		}
		return currNode; 
	}

	public void postOrderTraversal() {
		postOrderTraversalHelper(root); 
	}

	private void postOrderTraversalHelper(Node currNode) {
		if(currNode == null)
			return; 

		postOrderTraversalHelper(currNode.left); 
		postOrderTraversalHelper(currNode.right); 

		System.out.println(currNode.value); 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int newVal; 
		BinaryTree tree = new BinaryTree(); 

        while ((line = reader.readLine()) != null) {
        	if (line.equals(""))
        		break;
            newVal = Integer.parseInt(line); 
            tree.insert(newVal); 
        }
        tree.postOrderTraversal();
	}
}