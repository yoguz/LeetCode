import common.TreeNode;

public class Q100_Same_Tree {

    public boolean isSameTreeOld(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        else if (p == null && q == null)
            return true;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p != null && q == null)
            return false;
        else if (p == null && q != null)
            return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Q100_Same_Tree obj = new Q100_Same_Tree();
        TreeNode root = TreeNode.createTree(new Integer[]{1,2,3});
        System.out.println(obj.isSameTree(root, root));
        TreeNode root2 = TreeNode.createTree(new Integer[]{1,3,2});
        System.out.println(obj.isSameTree(root, root2));
    }
}
