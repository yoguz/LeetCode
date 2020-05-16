import common.TreeNode;

public class Q543_Diameter_of_Binary_Tree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(calculateDiameter(root),
                Math.max(diameterOfBinaryTree(root.left),
                        diameterOfBinaryTree(root.right)));
    }

    private int calculateDiameter(TreeNode node) {
        if (node == null)
            return 0;

        return depth(node.left, 0) + depth(node.right, 0);

    }

    private int depth(TreeNode node, int level) {
        if (node == null)
            return level;

        return Math.max(depth(node.left, level+1), depth(node.right, level+1));
    }

    public static void main(String[] args) {
        Q543_Diameter_of_Binary_Tree obj = new Q543_Diameter_of_Binary_Tree();
        TreeNode root = TreeNode.createTree(new Integer[]{1,2,3,4,5});
        System.out.println(obj.diameterOfBinaryTree(root));
        root = TreeNode.createTree(new Integer[]{1,2,3,4,5, null, null, 6, null, null, 7, 8, null, null, 9});
        System.out.println(obj.diameterOfBinaryTree(root));
    }
}
