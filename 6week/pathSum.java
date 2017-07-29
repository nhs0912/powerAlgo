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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root!= null){
            if(root.right == null && root.left == null){
            	return (root.val == sum);
            }

            return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
        }


       return false;
    }
}
