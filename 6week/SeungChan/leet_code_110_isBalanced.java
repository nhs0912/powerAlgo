/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Solution {
    
    public boolean isBalanced(TreeNode root){
        
        if(root == null) return true;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int heightDiff = Math.abs(leftHeight - rightHeight);
        
        if(heightDiff > 1) return false;
        
        return isBalanced (root.left) && isBalanced (root.right);
    }
    
    private int getHeight(TreeNode root){
        
        if(root == null) return 0;
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
