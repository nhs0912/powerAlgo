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
    
    public boolean isBalanced(TreeNode root) {
        if(root==null){
          return true;  
        }
      
        boolean balance[] = new boolean[1];
        balance[0] = true;
        dfs(root, 0, balance);
            
        return balance[0];
    }
    
    public int dfs(TreeNode root, int depth, boolean balance[]){
        if(root==null){
            return depth;
        }    
        
        int leftNode = dfs(root.left,depth+1, balance);
        int rightNode = dfs(root.right,depth+1, balance);
        
        int diff = Math.abs(leftNode - rightNode);
        
        if(diff >= 2){
            balance[0] = false;
        }
    
        return Math.max(leftNode, rightNode); 
    }
    
}
