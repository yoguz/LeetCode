import common.TreeNode;

public class Q617_Merge_Two_Binary_Trees {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null || t2 != null) {
            TreeNode root = new TreeNode();
            helper(root, t1, t2);
            return root;
        }

        return null;
    }

    private void helper(TreeNode t, TreeNode t1, TreeNode t2) {
        TreeNode t1left = null, t2left = null, t1right = null, t2right = null;

        if (t1 != null) {
            t.val = t1.val;
            t1left = t1.left;
            t1right = t1.right;
        }

        if(t2 != null) {
            t.val += t2.val;
            t2left = t2.left;
            t2right = t2.right;
        }

        if (t1left != null || t2left != null) {
            TreeNode tleft = new TreeNode();
            t.left = tleft;
            helper(tleft, t1left, t2left);
        }

        if (t1right != null || t2right != null) {
            TreeNode tright = new TreeNode();
            t.right = tright;
            helper(tright, t1right, t2right);
        }
    }
}
