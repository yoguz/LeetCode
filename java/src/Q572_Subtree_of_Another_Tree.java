import common.TreeNode;

public class Q572_Subtree_of_Another_Tree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return helper(s, t, false);
    }

    private boolean helper(TreeNode s, TreeNode t, boolean continuing) {
        if (s == null && t == null)
            return true;
        else if (s == null || t == null)
            return false;
        else
            return (s.val == t.val && helper(s.left, t.left, true) && helper(s.right, t.right, true))
                    || (!continuing && helper(s.left, t, false))
                    || (!continuing && helper(s.right, t, false));
    }

    public static void main(String[] args) {
        Q572_Subtree_of_Another_Tree obj = new Q572_Subtree_of_Another_Tree();
        TreeNode root1 = TreeNode.createTree(new Integer[]{3,4,5,1,null,2});
        TreeNode root2 = TreeNode.createTree(new Integer[]{3,1,2});
        System.out.println(obj.isSubtree(root1, root2));
        root1 = TreeNode.createTree(new Integer[]{3,4,5,1,2});
        root2 = TreeNode.createTree(new Integer[]{4,1,2});
        System.out.println(obj.isSubtree(root1, root2));
    }
}