import common.TreeNode;

public class Q104_Maximum_Depth_of_Binary_Tree {

    public int maxDepthOld(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root, 1);
    }

    private int helper(TreeNode node, int level) {
        if (node == null)
            return level-1;

        return Math.max(level, Math.max(helper(node.left, level+1), helper(node.right, level+1)));
    }

    public int maxDepth(TreeNode root) {
        if ( root == null )
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Q104_Maximum_Depth_of_Binary_Tree obj = new Q104_Maximum_Depth_of_Binary_Tree();
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNode.createTree(arr);
        System.out.println(obj.maxDepth(root));
    }
}
