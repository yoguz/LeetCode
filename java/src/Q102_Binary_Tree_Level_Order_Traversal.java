import java.util.ArrayList;
import java.util.List;

public class Q102_Binary_Tree_Level_Order_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> list, TreeNode node, int level) {
        if (node == null)
            return;

        if (list.size() <= level) {
            List<Integer> sublist = new ArrayList<>();
            list.add(sublist);
        }

        list.get(level).add(node.val);
        helper(list, node.left, level+1);
        helper(list, node.right, level+1);
    }

    public static void main(String[] args) {
        Q102_Binary_Tree_Level_Order_Traversal obj = new Q102_Binary_Tree_Level_Order_Traversal();
        TreeNode root = obj.createTree();
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
    }

    private TreeNode createTree() {
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode n15 = new TreeNode(15, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n3 = new TreeNode(3, n9, n20);
        return n3;
    }
}
