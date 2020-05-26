import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1161_Maximum_Level_Sum_of_a_Binary_Tree {

    public int maxLevelSum(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        List<Integer> sums = new ArrayList<>();
        helper(root, sums, 0);

        int level = 0;
        for (int i = 1; i < sums.size(); ++i) {
            if (sums.get(i) > sums.get(level))
                level = i;
        }

        return level+1;
    }

    private void helper(TreeNode node, List<Integer> sums, int level) {
        if (node == null)
            return;

        if (sums.size() <= level)
            sums.add(node.val);
        else
            sums.set(level, sums.get(level)+node.val);

        helper(node.left, sums, level+1);
        helper(node.right, sums, level+1);
    }

    public static void main(String[] args) {
        Q1161_Maximum_Level_Sum_of_a_Binary_Tree obj = new Q1161_Maximum_Level_Sum_of_a_Binary_Tree();
        TreeNode root = TreeNode.createTree(new Integer[]{1,7,0,7,-8,null,null});
        System.out.println(obj.maxLevelSum(root));

    }
}
