import common.TreeNode;

public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if (nums.length == 0)
            return root;

        root = new TreeNode(nums[nums.length/2]);
        helper(root, nums, 0, nums.length/2);
        helper(root, nums, nums.length/2+1, nums.length);
        return root;
    }

    private void helper(TreeNode parent, int[] nums, int lo, int hi) {
        if (lo >= hi)
            return;

        int mid = lo + (hi-lo)/2;
        TreeNode node = new TreeNode(nums[mid]);
        if (parent.val > node.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        helper(node, nums, lo, mid);
        helper(node, nums, mid+1, hi);
    }

    public static void main(String[] args) {
        Q108_Convert_Sorted_Array_to_Binary_Search_Tree obj = new Q108_Convert_Sorted_Array_to_Binary_Search_Tree();
        TreeNode root = obj.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        TreeNode.printTree(root);
    }

}
