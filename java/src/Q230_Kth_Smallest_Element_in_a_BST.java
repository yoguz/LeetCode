import common.TreeNode;

public class Q230_Kth_Smallest_Element_in_a_BST {

    int K, res = 0;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode node) {
        if (node != null && K > 0) {
            helper(node.left);

            if (K == 1) {
                res = node.val;
            }
            K--;

            helper(node.right);
        }
    }

    public static void main(String[] args) {
        Q230_Kth_Smallest_Element_in_a_BST obj = new Q230_Kth_Smallest_Element_in_a_BST();
        TreeNode root = TreeNode.createTree(new Integer[]{3,1,4,null,2});
        System.out.println(obj.kthSmallest(root, 1));
        root = TreeNode.createTree(new Integer[]{5,3,6,2,4,null,null,1});
        System.out.println(obj.kthSmallest(root, 3));
    }
}
