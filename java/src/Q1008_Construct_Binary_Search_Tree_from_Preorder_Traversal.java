import common.TreeNode;

public class Q1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        if (preorder.length == 0)
            return root;

        root = new TreeNode(preorder[0]);
        helper(root, preorder, 1, preorder.length);
        return root;
    }

    private void helper(TreeNode parent, int[] arr, int lo, int hi) {
        if (lo == hi)
            return;

        else if (lo+1 == hi) {
            if (arr[lo] > parent.val) {
                parent.right = new TreeNode(arr[lo]);
            } else {
                parent.left = new TreeNode(arr[lo]);
            }
            return;
        }

        int rightIndex = findBreakingPoint(arr, parent.val, lo, hi);
        if (rightIndex > lo) {
            parent.left = new TreeNode(arr[lo]);
            helper(parent.left, arr, lo+1, rightIndex);
        }
        if (rightIndex < hi) {
            parent.right = new TreeNode(arr[rightIndex]);
            helper(parent.right, arr, rightIndex+1, hi);
        }
    }

    private int findBreakingPoint(int[] arr, int val, int lo, int hi) {
        // Returns 4 for inputs: (preorder, 8, 1, 6)
        // Binary search kinda
        if (lo + 1 == hi) {
            if (arr[lo] > val)
                return lo;
            return hi;
        }

        int mid = lo + (hi-lo)/2;
        if (arr[mid-1] < val && arr[mid] > val){
            return mid;
        } else if (arr[mid-1] > val) {
            return findBreakingPoint(arr, val, lo, mid);
        } else {
            return findBreakingPoint(arr, val, mid, hi);
        }
    }

    public static void main(String[] args) {
        Q1008_Construct_Binary_Search_Tree_from_Preorder_Traversal obj = new Q1008_Construct_Binary_Search_Tree_from_Preorder_Traversal();
        TreeNode root = obj.bstFromPreorder(new int[]{8,5,1,7,10,12});
        TreeNode.printTree(root);
        root = obj.bstFromPreorder(new int[]{1,2,3});
        TreeNode.printTree(root);
        root = obj.bstFromPreorder(new int[]{3,2,1});
        TreeNode.printTree(root);
    }
}
