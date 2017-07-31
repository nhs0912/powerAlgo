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
        if(root == null){
            return false;
        }
        
        boolean[] flag = new boolean[1];
        flag[0] = false;
        
        dfs(root, sum, 0,flag);
        return flag[0];
      
    }
    public void dfs(TreeNode root, int sum, int element, boolean[] flag){
        if(root == null){
            return ;
        }
        int rootVal = root.val;
        int tmpSum= element+root.val;
        if(tmpSum==sum && root.left==null && root.right==null){
            flag[0] = true;
        }
        dfs(root.left, sum, tmpSum, flag);
        dfs(root.right, sum, tmpSum, flag);
    }
}
