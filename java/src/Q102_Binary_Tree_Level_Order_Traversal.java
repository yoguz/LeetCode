import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q102_Binary_Tree_Level_Order_Traversal {


    public List<List<Integer>> levelOrderOld(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helperOld(res, root, 0);
        return res;
    }

    private void helperOld(List<List<Integer>> list, TreeNode node, int level) {
        if (node == null)
            return;

        if (list.size() <= level) {
            List<Integer> sublist = new ArrayList<>();
            list.add(sublist);
        }

        list.get(level).add(node.val);
        helperOld(list, node.left, level+1);
        helperOld(list, node.right, level+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode node, List<List<Integer>> res, int level) {
        if ( node == null )
            return;

        if ( res.size() == level ) {
            res.add(new LinkedList<>());
        }

        res.get(level).add(node.val);
        helper(node.left, res, level+1);
        helper(node.right, res, level+1);
    }

    public static void main(String[] args) {
        Q102_Binary_Tree_Level_Order_Traversal obj = new Q102_Binary_Tree_Level_Order_Traversal();
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createTree(arr);
        List<List<Integer>> result = obj.levelOrder(root);
        System.out.println("[");
        for (List<Integer> sublist: result) {
            System.out.print("\t[");
            for (int i = 0; i < sublist.size()-1; ++i) {
                System.out.print(sublist.get(i) + ",");
            }
            System.out.println(sublist.get(sublist.size()-1) + "]");
        }
        System.out.println("]");

        TreeNode.printTree(root);
    }

}
