# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum, prevPick = False):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        if not root: 
            return 0
        
        answer = 0 
        if root.val == sum: 
            answer += 1 
        
        answer += self.pathSum(root.left, sum - root.val, True) + self.pathSum(root.right, sum - root.val, True)
        
        if not prevPick: 
            answer += self.pathSum(root.left, sum, False) + self.pathSum(root.right, sum, False)           
            
        return answer