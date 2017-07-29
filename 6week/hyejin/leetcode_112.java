public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        int result = sum;
        result -= root.val;
        
        boolean left, right;
        if(root.left == null && root.right == null) {
            if(result == 0)
                return true;
            else
                return false;
        } else {
            left = hasPathSum(root.left, result);
            right = hasPathSum(root.right, result);
            if(left || right)
                return true;
            else
                return false;
        }
    }
}
