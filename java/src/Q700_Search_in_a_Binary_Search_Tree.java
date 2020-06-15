import common.TreeNode;

public class Q700_Search_in_a_Binary_Search_Tree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        Q700_Search_in_a_Binary_Search_Tree obj = new Q700_Search_in_a_Binary_Search_Tree();
        TreeNode root = TreeNode.createTree(new Integer[]{4,2,7,1,3});
        TreeNode res = obj.searchBST(root, 3);
        System.out.println(res.val);
    }
}
