import common.TreeNode;

public class Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode _r = root;

        while (true) {
            if ((p.val <= _r.val && q.val >= _r.val) || (p.val >= _r.val && q.val <= _r.val))
                return _r;
            else if ((p.val <= _r.val && q.val <= _r.val))
                _r = _r.left;
            else
                _r = _r.right;
        }
    }

    public static void main(String[] args) {
        Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree obj = new Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
        TreeNode root = TreeNode.createTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        TreeNode lca = obj.lowestCommonAncestor(root, new TreeNode(0), new TreeNode(5));
        System.out.println(lca.val);
    }
}
