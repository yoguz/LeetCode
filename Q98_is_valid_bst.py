class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        max_val = sys.maxint
        min_val = -1*sys.maxint - 1
        
        if root is None:
            return True
        
        ret_left = self._is_in_interval(root.left, min_val, root.val)
        ret_right = self._is_in_interval(root.right, root.val, max_val)
        
        return (ret_left and ret_right)
        
        
    def _is_in_interval(self, node, min_val, max_val):
        if node is None:
            return True
        
        if node.val <= min_val or node.val >= max_val:
            return False
        
        ret_left = self._is_in_interval(node.left, min_val, node.val)
        ret_right = self._is_in_interval(node.right, node.val, max_val)
        return (ret_left and ret_right)
            