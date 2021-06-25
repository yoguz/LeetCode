import common.TreeNode;

import java.util.Arrays;

public class Q124_Binary_Tree_Maximum_Path_Sum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        Q124_Binary_Tree_Maximum_Path_Sum obj = new Q124_Binary_Tree_Maximum_Path_Sum();
        System.out.println(obj.maxPathSum(TreeNode.createTree(new Integer[]{1,2,3})));
        System.out.println(obj.maxPathSum(TreeNode.createTree(new Integer[]{1,-2,3})));
    }

}
