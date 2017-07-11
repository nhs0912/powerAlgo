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
    public boolean isSymmetricallySame(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null && root2 != null) return false; 
        if(root1 != null && root2 == null) return false; 
        if(root1.val != root2.val) return false; 
        
        return isSymmetricallySame(root1.right, root2.left) && isSymmetricallySame(root1.left, root2.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricallySame(root.right, root.left);
    }
}