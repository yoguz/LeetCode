public class Q104_Maximum_Depth_of_Binary_Tree {

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

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root, 1);
    }

    private int helper(TreeNode node, int level) {
        if (node == null)
            return level-1;

        return Math.max(level, Math.max(helper(node.left, level+1), helper(node.right, level+1)));
    }

    public static void main(String[] args) {
        Q104_Maximum_Depth_of_Binary_Tree obj = new Q104_Maximum_Depth_of_Binary_Tree();
        TreeNode root = obj.createTree();
        System.out.println(obj.maxDepth(root));
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
