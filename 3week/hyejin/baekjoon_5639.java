import java.io.FileInputStream;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node insertBTS(Node root, int data) {
		Node node = null;
		
		if(root == null) {
			return new Node(data);
		} 
		
		if(root.data > data) {
			node = insertBTS(root.left, data);
			root.left = node;
			return root;
		} else if(root.data < data) {
			node = insertBTS(root.right, data);
			root.right = node;
			return root;
		} else
			return root; 
	}
	
	public void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
            System.out.println(root.data);
        }	
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		Node root = new Node(sc.nextInt());
		
		while(sc.hasNext()) {
			int data = sc.nextInt();
			root.insertBTS(root, data);
		}
		
		root.postOrder(root);
	}
}
