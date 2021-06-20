import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        Map<Integer, Integer> idxs = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            idxs.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; ++i) {
            helper(root, preorder, i, idxs);
        }

        return root;
    }

    private void helper(TreeNode parent, int[] pre, int i, Map<Integer, Integer> idxs) {
        if (idxs.get(pre[i]) < idxs.get(parent.val) && parent.left == null) {
            parent.left = new TreeNode(pre[i]);
        } else if (idxs.get(pre[i]) < idxs.get(parent.val) && parent.left != null) {
            helper(parent.left, pre, i, idxs);
        } else if (idxs.get(pre[i]) > idxs.get(parent.val) && parent.right == null) {
            parent.right = new TreeNode(pre[i]);
        } else {
            helper(parent.right, pre, i, idxs);
        }
    }

    public static void main(String[] args) {
        Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal obj = new Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        TreeNode res = obj.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        TreeNode.printTree(res);
    }

}
