/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int getHeight(TreeNode root) {
        if(root == null) 
            return 1; 
        
        int leftHeight = 1 + getHeight(root.left); 
        int rightHeight = 1 + getHeight(root.right); 
        
        return leftHeight > rightHeight ? leftHeight : rightHeight; 
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true; 
        int leftHeight = getHeight(root.left); 
        int rightHeight = getHeight(root.right);
        
        int diff = Math.abs(leftHeight - rightHeight); 

        if(diff > 1) {
            return false; 
        }
        else {
            return true && isBalanced(root.left) && isBalanced(root.right);  
        }
    }
}