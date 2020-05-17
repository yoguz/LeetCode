import common.TreeNode;

public class Q101_Symmetric_Tree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

       // TreeNode root2 = reverseTree(root); // Unnecessary
       return same(root.left, root.right);
    }

    // Totally unnecessary
   /* private TreeNode reverseTree(TreeNode root) {
        TreeNode root2 = new TreeNode(root.val);
        reverseTreeHelper(root, root2);
        return root2;
    }

    private void reverseTreeHelper(TreeNode original, TreeNode copy) {
        if(original == null)
            return;

        if (original.right != null) copy.left = new TreeNode(original.right.val);
        if (original.left != null) copy.right = new TreeNode(original.left.val);

        reverseTreeHelper(original.left, copy.right);
        reverseTreeHelper(original.right, copy.left);
    }*/

    private boolean same(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null && root2 != null)
            return false;
        else if (root1 != null && root2 == null)
            return false;

        return root1.val == root2.val && same(root1.left, root2.right) && same(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Q101_Symmetric_Tree obj = new Q101_Symmetric_Tree();
        TreeNode root = TreeNode.createTree(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(obj.isSymmetric(root));
        root = TreeNode.createTree(new Integer[]{1,2,2,null,3,null,3});
        System.out.println(obj.isSymmetric(root));
        root = TreeNode.createTree(new Integer[]{});
        System.out.println(obj.isSymmetric(root));
    }
}
