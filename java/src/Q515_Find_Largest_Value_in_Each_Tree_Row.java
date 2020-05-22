import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q515_Find_Largest_Value_in_Each_Tree_Row {

    List<Integer> list;
    public List<Integer> largestValues(TreeNode root) {
        list = new ArrayList<>();
        helper(root, 0);
        return list;
    }

    private void helper(TreeNode node, int level) {
        if (node == null)
            return;

        if (list.size() == level)
            list.add(node.val);
        else
            list.set(level, Math.max(node.val, list.get(level)));

        helper(node.left, level+1);
        helper(node.right, level+1);
    }

    public static void main(String[] args) {
        Q515_Find_Largest_Value_in_Each_Tree_Row obj = new Q515_Find_Largest_Value_in_Each_Tree_Row();
        TreeNode root = TreeNode.createTree(new Integer[]{1,3,2,5,3,null,9});
        List<Integer> result = obj.largestValues(root);
        System.out.print("[");
        for (Integer i: result) {
            System.out.print(i + ",");
        }
        System.out.println("]");
    }
}
