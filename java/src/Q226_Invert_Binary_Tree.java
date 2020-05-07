import java.util.LinkedList;
import java.util.Queue;

public class Q226_Invert_Binary_Tree {

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

    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if (node == null)
            return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        helper(node.left);
        helper(node.right);
    }

    public static void main(String[] args) {
        Q226_Invert_Binary_Tree obj = new Q226_Invert_Binary_Tree();
        TreeNode root = obj.createTree();
        obj.printLevelOrder(root);
        root = obj.invertTree(root);
        System.out.println();
        obj.printLevelOrder(root);
    }

    void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    private TreeNode createTree() {
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n7 = new TreeNode(7, n9, n6);
        TreeNode n2 = new TreeNode(2, n3, n1);
        TreeNode n4 = new TreeNode(4, n7, n2);
        return n4;
    }
}
